package cn.TianYang.service.impl;

import cn.TianYang.dao.IRoleDao;
import cn.TianYang.pojo.Permission;
import cn.TianYang.pojo.Role;
import cn.TianYang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private IRoleDao dao;
    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }

    @Override
    public void saveRole(Role role) {
        dao.saveRole(role);
    }

    @Override
    public Role findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Permission> findPermissionId(String id) {
        return dao.findPermissionId(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        for (String permissionid : ids) {
            dao.addPermissionToRole(roleId,permissionid);
        }
    }
}
