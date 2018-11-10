package cn.TianYang.service.impl;

import cn.TianYang.dao.IProductDao;
import cn.TianYang.pojo.Product;
import cn.TianYang.service.IProductService;
import cn.TianYang.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional//开启事务
public class IProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao dao;
    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        product.setDepartureTimeStr(DateUtils.date2String(product.getDepartureTime(),"yyyy-MM-dd HH:mm"));
        product.setProductStatusStr(product.getProductStatus()==0?"否":"是");
        dao.saveProduct(product);
    }
}
