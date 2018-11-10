package cn.TianYang.dao;

import cn.TianYang.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    @Select("select * from product")
    List<Product> findAll();

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product);

    //Orders传递过来的是他的外键约束，而对应的则是商品表的主键
    @Select("select * from product where id=#{oid}")
    Product findById(String id);
}
