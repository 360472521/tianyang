package cn.TianYang.controller;

import cn.TianYang.pojo.Product;
import cn.TianYang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService service;


    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> all = service.findAll();
        mv.addObject("productList",all);
        mv.setViewName("product-list1");//返回值路径名字，视图解析器根据我们返回的字符串进行地址解析
        return mv;
    }

    @RequestMapping("/save")
    public String save(Product product){
//        System.out.println(product);
        service.saveProduct(product);
        return "redirect:findAll.do";
    }
}
