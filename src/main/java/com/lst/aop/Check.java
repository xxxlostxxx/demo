package com.lst.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author youzhu@dian.so
 * @version 1.0.0
 * @Date 2018-09-16
 * @Copyright 北京伊电园网络科技有限公司 2016-2018 © 版权所有 京ICP备17000101号
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Check {

}
