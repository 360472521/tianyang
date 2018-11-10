package cn.TianYang.controller;

import cn.TianYang.pojo.Permission;
import cn.TianYang.pojo.Role;
import cn.TianYang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService service;

    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
//    @Secured("ROLE_ADMIN")//使用rolesAllowed可以省略前缀，使用这个不能省略
//    @PreAuthorize("authentication.principal.username=='tianyang'")//相当于secured和rolesAllowed的加强版，许哟使用SEL表达式
    //上面的注解表示，当我的用户名为tianyang的时候才能执行这个方法
    public ModelAndView findAll(){
        List<Role> roles = service.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-list");
        mv.addObject("roleList",roles);
        return mv;
    }

    @RequestMapping("/save")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")//需要有admin权限才能执行
    public String saveRole(Role role){
        service.saveRole(role);
        return "redirect: /role/findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String id){
        Role role = service.findById(id);
        List<Permission>permissions = service.findPermissionId(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList",permissions);
        mv.addObject("role",role);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(String roleId,String []ids){
        service.addPermissionToRole(roleId,ids);
        return "redirect:/role/findAll.do";
    }

}
