package com.lst.controller;

import com.lst.redis.RedisService;
import com.lst.service.DemoService;
import com.lst.utils.PageData;
import com.lst.utils.Result;
import com.lst.utils.ResultsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DemoController{
    @Autowired
    private DemoService demoService;

    @Autowired
    private RedisService redisService;
    @GetMapping(value = "demo/{id}")
    public Result demo(@PathVariable String id){
        Result result  = new Result();
        String demo = demoService.demo(id);
        result.data = demo;
        return result;
    }
    @GetMapping(value = "demo1")
    public Result demo1(){
        Result result  = new Result();
        String demo = demoService.demo1();
        result.data = demo;
        return null;
    }
    @GetMapping(value = "demoAop")
    public Result demoAop(){
        Result result  = new Result();
        String demo = demoService.testAop();
        result.data = demo;
        return null;
    }
    @GetMapping(value = "demoAop1")
    public Result demoAop1(){
        Result result  = new Result();
        String demo = demoService.testAop1();
        result.data = demo;
        return null;
    }
  /*  @GetMapping(value = "demo1")
    public Result demo1() throws Exception{
        Result result  = new Result();
        DCDemo javacTest = new DCDemo();
        String input_str = DCDemo.eval("input_str");
        result.data = input_str;
        return result;
    }*/

    @RequestMapping("/redis/set")
    public Result redisSet(@RequestParam("value")String value){
        redisService.set("name", value);
        return ResultsFactory.buildSuccess("q2");
    }

    @RequestMapping("/redis/get")
    public Result redisGet(){
        String name = redisService.get("name");
        return ResultsFactory.buildSuccess(name);
    }

    @RequestMapping("/demo/pageData")
    public String pageData(){
        PageData pageData =new PageData();
        pageData.put("channelid",1);
        pageData.put("userid",1);
        List list = new ArrayList();
        list.add("userid");
        list.add("channelid");
        pageData.put("list",list);
        return demoService.demoPageData(pageData);
    }

    public static void main(String[] args) {
        for (int i = 0 ; i<100 ; i++){
            Integer flag = new Random().nextInt(999999);
            if (flag < 100000)
            {
                flag += 100000;
            }

            System.out.println(flag.toString());
        }

    }

}
