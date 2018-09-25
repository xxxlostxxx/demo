package com.lst.service;

import com.lst.utils.PageData;

public interface DemoService {
    String demo(String id);
    String demo1();

    String demoPageData(Object pageData);

    String testAop();
    String testAop1();
}
