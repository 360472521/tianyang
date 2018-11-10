package cn.TianYang.service.impl;

import cn.TianYang.pojo.Orders;
import cn.TianYang.dao.IOrdersDao;
import cn.TianYang.service.IOdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IOdersServiceImpl implements IOdersService {
    @Autowired
    private IOrdersDao dao;
    @Override
    public List<Orders> findAll(int page, int pagesize) {
        //在执行之前调用pagehelper的方法进行分页
        PageHelper.startPage(page,pagesize);
        return dao.findAll();
    }

    @Override
    public Orders findById(String id) {
        Orders byId = dao.findById(id);
        return byId;
    }
}
