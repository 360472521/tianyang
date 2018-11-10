package cn.TianYang.service;

import cn.TianYang.pojo.Orders;

import java.util.List;

public interface IOdersService {
    List<Orders> findAll(int page, int pagesize);

    Orders findById(String id);
}
