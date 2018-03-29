package com.example.scheduleService.dao;

import com.example.scheduleService.model.order;

public interface orderMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(order record);

    int insertSelective(order record);

    order selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(order record);

    int updateByPrimaryKey(order record);
}