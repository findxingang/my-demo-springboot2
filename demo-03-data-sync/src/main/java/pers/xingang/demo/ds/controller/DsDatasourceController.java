package pers.xingang.demo.ds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pers.xingang.demo.ds.domain.DsDatasource;
import pers.xingang.demo.ds.service.IDsDatasourceService;

import javax.annotation.Resource;
import java.util.List;

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
     * 新增数据源
     * @param dsDatasource 数据源信息
     * @return OK
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody DsDatasource dsDatasource) {
        return ResponseEntity.ok(datasourceService.createDataSource(dsDatasource));
    }

    /**
     * 查询指定数据源
     * @param id 数据源ID
     * @return 指定数据源信息
     */
    @GetMapping("{id}")
    public ResponseEntity<DsDatasource> readOne(@PathVariable String id) {
        return ResponseEntity.ok(datasourceService.getById(id));
    }

    /**
     * 查询所有数据源
     * @return 指定数据源信息
     */
    @GetMapping
    public ResponseEntity<List<DsDatasource>> readList() {
        return ResponseEntity.ok(datasourceService.list());
    }

    /**
     * 删除数据源
     * @param id 数据源ID
     * @return OK
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return ResponseEntity.ok(datasourceService.removeById(id));
    }

    /**
     * 修改数据源
     * @param dsDatasource 数据源信息
     * @return OK
     */
    @PutMapping
    public ResponseEntity<?> update(@RequestBody DsDatasource dsDatasource) {
        return ResponseEntity.ok(datasourceService.updateById(dsDatasource));
    }


    /**
     * 连接数据源
     * @param id 数据源ID
     * @return OK
     */
    @PutMapping("{id}")
    public ResponseEntity<?> connect(@PathVariable String id) {
        return ResponseEntity.ok(datasourceService.connect(id));
    }


}
