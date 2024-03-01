package pers.xingang.demo.ds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.xingang.demo.ds.domain.DsDatasource;
import pers.xingang.demo.ds.service.IDsDatasourceService;

import javax.annotation.Resource;

/**
 * 数据源（暂时只考虑MySQL） 前端控制器
 *
 * @author xingang
 * @since 2024-03-01
 */
@RestController
@RequestMapping("/ds/datasource")

public class DsDatasourceController {

    @Resource
    private IDsDatasourceService datasourceService;

    /**
     * 创建数据源
     * @param dsDatasource 数据源信息
     * @return OK
     */
    @PostMapping
    public ResponseEntity<?> createDataSource(@RequestBody DsDatasource dsDatasource) {
        boolean success = datasourceService.createDataSource(dsDatasource);
        return ResponseEntity.ok().body(success ? "成功" : "失败");
    }

}
