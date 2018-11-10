package cn.TianYang.service;

import cn.TianYang.pojo.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void saveProduct(Product product);
}
