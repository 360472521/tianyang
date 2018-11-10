package cn.TianYang.dao;

import cn.TianYang.pojo.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDe"),
            @Result(column = "productId",property = "product",one = @One(select =
                    "cn.TianYang.dao.IProductDao.findById"))

    })//配置一对一关系映射封装,由于我们这里并没有给他定义旅客的信息，所以不能复用
    List<Orders> findAll();


    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDe"),
            @Result(column = "productId",property = "product",one = @One(select =
                    "cn.TianYang.dao.IProductDao.findById")),
            @Result(column = "id",property = "travellers",many = @Many(select =
                    "cn.TianYang.dao.ITravellerDao.findByOrdersId")),
            @Result(column = "memberId",property = "member",one = @One(select =
                    "cn.TianYang.dao.IMemberDao.findById")),
    })
    Orders findById(String id);
}
