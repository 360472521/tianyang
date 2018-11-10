package cn.TianYang.service.impl;

import cn.TianYang.dao.IUserDao;
import cn.TianYang.pojo.Role;
import cn.TianYang.pojo.UserInfo;
import cn.TianYang.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//注意不要导错包！！！！
import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao dao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = dao.findByName(username);
        //SpringSecurity的User对象提供了两个构造，我们使用带有账户状态判断的构造
        System.err.println(userInfo+"--------------------------------------!!!!!!!!!!");
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
//        list.add(new SimpleGrantedAuthority("ROLE_USER"));
//        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        for (int i = 0; i < roles.size(); i++) {
            list.add(new SimpleGrantedAuthority("ROLE_"+roles.get(i).getRoleName()));
        }
        System.out.println(list.get(0)+"----------------"+list.get(1));
        return list;
    }

    @Override
    public List<UserInfo> findAll(Integer page, Integer pagesize) {
        PageHelper.startPage(page,pagesize);
        return dao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        //加密
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        dao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {

        return dao.findById(id);
    }

    @Override
    public List<Role> findRoleId(String id) {
        return dao.findRoleId(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String roleId : ids) {
            dao.addRoleToUser(userId,roleId);
        }
    }
}
