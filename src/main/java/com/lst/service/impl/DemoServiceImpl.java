package com.lst.service.impl;


import com.alibaba.fastjson.JSON;
import com.lst.dao.DemoDao;
import com.lst.entity.Demo;
import com.lst.service.DemoService;

import com.lst.utils.Page;
import com.lst.utils.PageData;
import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class DemoServiceImpl implements DemoService{
    @Autowired
    private DemoDao demoDao;
    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

    private static ConcurrentHashMap<String,AtomicLong> i = new ConcurrentHashMap();
    @Override
    public String demo(String id) {
        Demo demo= new Demo();
        demo.setId(1234);
        demo.setName("xxx");
        demoDao.demo(demo);
        return "";
    }
    @Override
    public String demo1() {
        Demo demo= new Demo();
        demo.setId(1234);
        demo.setName("xxx");
        demoDao.insert(demo);
        return null;
    }
    @Email
    @Override
    public String demoPageData(Object pageData) {
        boolean b = pageData instanceof PageData;

        System.out.println(b);
        return null;
    }
}
