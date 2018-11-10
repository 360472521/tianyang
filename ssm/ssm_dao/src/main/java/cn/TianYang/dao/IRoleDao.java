package cn.TianYang.dao;

import cn.TianYang.pojo.Permission;
import cn.TianYang.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    /**
     * 注意：这个方法是多对多查询，所以需要在where中嵌套一个子查询
     * @param userid
     * @return
     */
    @Select("select * from role where id in(select roleId from users_role where userId=#{userid})")
    @Results({
            @Result(id = true, property = "id", column = "ID"),
            @Result(column = "ROLENAME", property = "roleName"),
            @Result(column = "ROLEDESC", property = "roleDesc"),
            //@Result(column="id",property="permissions",javaType=List.class,many=@Many(select="cn.TianYang.dao.IPermissionDao.findByRoleId"))
 })
    List<Role> findByUserId(String userid);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void saveRole(Role role);

    @Select("select * from role where id=#{id}")
    Role findById(String id);

    @Select("select * from permission where id not in(select permissionid from role_permission where roleid=#{id})")
    List<Permission> findPermissionId(String id);

    //不使用@param的情况下只能有一个参数，如果有多个参数则必须需用param
    @Insert("insert into role_permission (roleid,permissionid) values(#{roleId},#{permissionid})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionid") String permissionid);
}
