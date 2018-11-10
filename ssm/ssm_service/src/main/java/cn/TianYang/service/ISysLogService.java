package cn.TianYang.service;

import cn.TianYang.pojo.SysLog;

import java.util.List;

public interface ISysLogService {
    void save(SysLog sysLog);

    List<SysLog> findAll();
}
