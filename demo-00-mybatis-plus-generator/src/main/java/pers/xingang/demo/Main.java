package pers.xingang.demo;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Types;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author xingang
 * @since 2024/02/29 17:43
 */
@Slf4j
@SpringBootApplication
public class Main implements CommandLineRunner{

    @Value("${spring.datasource.dynamic.datasource.master.url}")
    private String url;

    @Value("${spring.datasource.dynamic.datasource.master.username}")
    private String username;

    @Value("${spring.datasource.dynamic.datasource.master.password}")
    private String password;

    @Resource
    private DataSource dataSource;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        // 默认输出路径 = 当前工作目录
        String outputDir = new File("").getAbsolutePath();

        String in = scannerNext("\n\n请输入子模块的名称（回车跳过，在根目录生成）:");
        // 输入空白，则默认是当前文件的工作目录
        if (!StringUtils.isBlank(in)) {
            outputDir = in;
        }

        // 默认的mapper.xml文件的路径
        String mapperXmlDir = outputDir + "\\src\\main\\resources\\mapper";

        // 默认包名 = org.example.demo
        String packageDir;
        in = scannerNext("请输入包路径（例如org.spring.framework）：");
        // 输入空白，则默认是当前文件的工作目录
        if (!StringUtils.isBlank(in)) {
            packageDir = in;
        } else {
            packageDir = "org.example.demo";
        }


        // 模块名
        String moduleName;
        in = scannerNext("请输入模块名（例如core）：");
        // 输入空白，则默认是当前文件的工作目录
        if (!StringUtils.isBlank(in)) {
            moduleName = in;
        } else {
            moduleName = "";
        }

        String finalOutputDir = outputDir  + "\\src\\main\\java";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("xingang") // 设置作者
                            .commentDate("yyyy-MM-dd")
                            // .enableSwagger() // 开启 swagger 模式
                            .outputDir(finalOutputDir); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent(packageDir) // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .entity("domain") // 设置实体类包名为domain
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperXmlDir)); // 设置mapperXml生成路径
                })
                .templateConfig(builder -> {
                    builder.controller("templates/controller.java");
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_datasource") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_") // 设置过滤表前缀

                            // 实体类配置
                            .entityBuilder()
                            .enableFileOverride()
                            .disableSerialVersionUID()
                            .enableColumnConstant()
                            // .enableChainModel()
                            .enableLombok()
                            .enableTableFieldAnnotation()

                            // Controller配置
                            .controllerBuilder()
                            .enableFileOverride()
                            .enableRestStyle()

                            // Service配置
                            .serviceBuilder().enableFileOverride()

                            .mapperBuilder()
                            .enableFileOverride()
                            .mapperAnnotation(Mapper.class)
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    public String scannerNext(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

}