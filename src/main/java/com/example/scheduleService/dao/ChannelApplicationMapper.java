package com.example.scheduleService.dao;

import com.example.scheduleService.model.ChannelApplication;

public interface ChannelApplicationMapper {
    int deleteByPrimaryKey(String id);

    int insert(ChannelApplication record);

    int insertSelective(ChannelApplication record);

    ChannelApplication selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ChannelApplication record);

    int updateByPrimaryKey(ChannelApplication record);
}