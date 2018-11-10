package cn.TianYang.service;

import cn.TianYang.pojo.Permission;
import cn.TianYang.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void saveRole(Role role);

    Role findById(String id);

    List<Permission> findPermissionId(String id);

    void addPermissionToRole(String roleId, String[] ids);
}
