package cn.TianYang.service.impl;

import cn.TianYang.dao.ISysLogDao;
import cn.TianYang.pojo.SysLog;
import cn.TianYang.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ISysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog log)  {
        sysLogDao.save(log);
    }
    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}

