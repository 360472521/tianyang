package cn.TianYang.controller;

import cn.TianYang.pojo.Role;
import cn.TianYang.pojo.UserInfo;
import cn.TianYang.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;

    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "pagesize",required = true,defaultValue = "5")Integer pagesize){
        ModelAndView mv = new ModelAndView();
        List<UserInfo>userinfos = service.findAll(page,pagesize);
        PageInfo pageinfo = new PageInfo(userinfos);
        mv.addObject("pageinfo",pageinfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        service.save(userInfo);
        return "redirect:/user/findAll.do";
    }


    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id){
        UserInfo userInfo = service.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.setViewName("user-show1");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id){
        //先把当前用户的数据查出来，然后把他没有的角色也查询出来传递回显前台
        UserInfo user = service.findById(id);
        List<Role>roles=service.findRoleId(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList",roles);
        mv.addObject("user",user);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId,String [] ids){
        service.addRoleToUser(userId,ids);
        return "redirect:/user/findAll.do";
    }

}
