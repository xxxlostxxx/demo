package com.lst.service.impl;


import com.lst.dao.DemoDao;
import com.lst.service.DemoService;

import com.lst.utils.Page;
import com.lst.utils.PageData;
import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DemoServiceImpl implements DemoService{
    @Autowired
    private DemoDao demoDao;
    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);
    @Override
    public String demo() {
        logger.error("errororororo");
        String demo = demoDao.demo(1L);
        return demo;
    }
    @Email
    @Override
    public String demoPageData(Object pageData) {
        boolean b = pageData instanceof PageData;

        System.out.println(b);
        return null;
    }
}
