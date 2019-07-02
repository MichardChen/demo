package com.etc.base.mapper;

import com.etc.base.entity.BusinessLogRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 业务日志实体持久层操作类
 * @author ChenDang
 * @date 2019/5/29 0028
 */
public interface BusinessLogRecordMapper extends MongoRepository<BusinessLogRecord,String> {
}
