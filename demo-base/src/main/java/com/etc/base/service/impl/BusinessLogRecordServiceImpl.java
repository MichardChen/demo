package com.etc.base.service.impl;

import com.etc.base.entity.BusinessLogRecord;
import com.etc.base.mapper.BusinessLogRecordMapper;
import com.etc.base.service.BusinessLogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenDang
 * @date 2019/7/1 0001
 */
@Service
public class BusinessLogRecordServiceImpl implements BusinessLogRecordService {

    @Autowired
    BusinessLogRecordMapper businessLogRecordDao;

    @Override
    public String count() {

        List<BusinessLogRecord> list = businessLogRecordDao.findAll();
        Long exist = businessLogRecordDao.count();
        return exist.toString();
    }
}
