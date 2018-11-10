package cn.TianYang.service.impl;

import cn.TianYang.dao.IPermissionDao;
import cn.TianYang.pojo.Permission;
import cn.TianYang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private IPermissionDao dao;
    @Override
    public List<Permission> findAll() {
        return dao.findAll();
    }

    @Override
    public void savePermission(Permission permission) {
        dao.savePermission(permission);
    }
}
