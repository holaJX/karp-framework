package com.lanpower.core.usercore.controller;

import com.lanpower.core.common.ExcelData;
import com.lanpower.core.common.ExportExcelUtils;
import com.lanpower.core.common.ResponseDTO;
import com.lanpower.core.common.Util;
import com.lanpower.core.usercore.entity.CoreDict;
import com.lanpower.core.usercore.entity.CoreUser;
import com.lanpower.core.usercore.service.ICoreDictService;
import com.lanpower.core.usercore.service.ICoreUserService;
import com.lanpower.core.usercore.entity.CoreDict;
import com.lanpower.core.usercore.service.ICoreDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.*;

/**
 * @Author: pujx
 * @Date: 2019/5/22 15:04
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ICoreUserService coreUserService;

    @Autowired
    private ICoreDictService coreDictService;

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("getuser/{id}")
    public ResponseDTO getUser(@PathVariable("id") String id) {
        CoreUser user = coreUserService.getById(id);
        return ResponseDTO.success(user);
    }

    /**
     * 导出字典信息
     *
     * @param request
     * @param response
     * @throws ParseException
     */
    @RequestMapping(value = "/dictReport", method = RequestMethod.GET)
    public void overdueWeekReport(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        List<CoreDict> list = coreDictService.list();
        ExcelData data = new ExcelData();
        List<List<Object>> rows = new ArrayList();
        Map map = new HashMap();
        String[] titles = {
                "ID",
                "名称",
                "字典编码",
                "类型描述",
                "排序",
                "父id",
                "删除标记",
                "备注",
                "创建时间"
        };
        for (CoreDict dic : list) {
            List<Object> row = new ArrayList();
            row.add(dic.getId());
            row.add(dic.getName());
            row.add(dic.getValue());
            row.add(dic.getTypeName());
            row.add(dic.getSort());
            row.add(dic.getParent());
            row.add(dic.getDelFlag());
            row.add(dic.getRemark());
            row.add(Util.date2StringFormat(dic.getCreateTime()));
            rows.add(row);
        }

        data.setName("字典信息");
        data.setTitles(titles);
        data.setRows(rows);

        try {
            ExportExcelUtils.exportExcel(response, "字典信息_" + Util.date2StringFormat(new Date()).substring(0, 10) + ".xlsx", data);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
