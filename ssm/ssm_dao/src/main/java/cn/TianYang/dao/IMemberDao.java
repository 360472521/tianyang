package cn.TianYang.dao;

import cn.TianYang.pojo.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;

}
