package cn.TianYang.controller;

import cn.TianYang.pojo.Permission;
import cn.TianYang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService service;

    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request){
        List<Permission> list = service.findAll();
        request.setAttribute("permissionList",list);
        return "/permission-list";
    }

    @RequestMapping("/save")
    public String savePermission(Permission permission){
        service.savePermission(permission);
        return "redirect:/permission/findAll.do";
    }
}
