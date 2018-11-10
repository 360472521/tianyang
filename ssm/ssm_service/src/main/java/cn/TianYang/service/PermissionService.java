package cn.TianYang.service;

import cn.TianYang.pojo.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    void savePermission(Permission permission);
}
