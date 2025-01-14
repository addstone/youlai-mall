package com.youlai.admin.controller;

import com.youlai.admin.pojo.entity.SysDept;
import com.youlai.admin.pojo.query.DeptQuery;
import com.youlai.admin.pojo.vo.dept.DeptVO;
import com.youlai.admin.service.SysDeptService;
import com.youlai.common.result.Result;
import com.youlai.common.web.domain.Option;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门控制器
 *
 * @author haoxr
 * @date 2020/11/6
 */
@Api(tags = "部门接口")
@RestController
@RequestMapping("/api/v1/depts")
@RequiredArgsConstructor
public class SysDeptController {

    private final SysDeptService deptService;

    @ApiOperation(value = "部门列表")
    @GetMapping
    public Result<List<DeptVO>> listDepts(DeptQuery queryParams) {
        List<DeptVO> list = deptService.listDepts(queryParams);
        return Result.success(list);
    }

    @ApiOperation(value = "部门下拉列表")
    @GetMapping("/select_list")
    public Result lisetDeptOptions() {
        List<Option> list = deptService.lisetDeptOptions();
        return Result.success(list);
    }

    @ApiOperation(value = "部门表单数据")
    @GetMapping("/{deptId}/form_data")
    public Result getDeptDetail(@ApiParam("部门ID") @PathVariable Long deptId) {
        SysDept sysDept = deptService.getById(deptId);
        return Result.success(sysDept);
    }

    @ApiOperation(value = "新增部门")
    @PostMapping
    public Result addDept(@RequestBody SysDept dept) {
        Long id = deptService.saveDept(dept);
        return Result.success(id);
    }

    @ApiOperation(value = "修改部门")
    @PutMapping(value = "/{deptId}")
    public Result updateDept(@ApiParam("部门ID") @PathVariable Long deptId, @RequestBody SysDept dept) {
        deptId = deptService.saveDept(dept);
        return Result.success(deptId);
    }

    @ApiOperation(value = "删除部门")
    @DeleteMapping("/{ids}")
    public Result deleteDepartments(@ApiParam("部门ID，多个以英文逗号(,)分割") @PathVariable("ids") String ids) {
        boolean result = deptService.deleteByIds(ids);
        return Result.judge(result);
    }

}
