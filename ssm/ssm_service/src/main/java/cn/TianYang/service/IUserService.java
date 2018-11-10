package cn.TianYang.service;

import cn.TianYang.pojo.Role;
import cn.TianYang.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll(Integer page, Integer pagesize);

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findRoleId(String id);

    void addRoleToUser(String id, String[] ids);
}
