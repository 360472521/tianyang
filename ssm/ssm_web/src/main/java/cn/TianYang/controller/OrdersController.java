package cn.TianYang.controller;

import cn.TianYang.pojo.Orders;
import cn.TianYang.service.IOdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOdersService service;

    //未分页
//    @RequestMapping("/findAll")
//    public ModelAndView findAll(){
//        ModelAndView mv = new ModelAndView();
//        List<Orders> list = service.findAll();
//        mv.addObject("ordersList",list);
//        mv.setViewName("orders-list");
//        return mv;
//    }

    //分页
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "pagesize",required = true,defaultValue = "5")int pagesize){
        ModelAndView mv = new ModelAndView();
        List<Orders> list = service.findAll(page,pagesize);
        PageInfo pi = new PageInfo(list);
        mv.addObject("pageinfo",pi);
        mv.setViewName("orders-page-list");
        return mv;
    }


    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        Orders orders = service.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
