package com.example.scheduleService.dao;

import com.so.dian.woms.dao.model.AlarmEventDO;

public interface AlarmEventDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlarmEventDO record);

    int insertSelective(AlarmEventDO record);

    AlarmEventDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlarmEventDO record);

    int updateByPrimaryKey(AlarmEventDO record);
}