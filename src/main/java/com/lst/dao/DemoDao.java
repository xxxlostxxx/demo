package com.lst.dao;

import com.lst.entity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DemoDao {
    String demo(Demo demo);
    Integer insert(Demo demo);
}
