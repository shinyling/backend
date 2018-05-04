package com.shiny.ftl.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiny
 **/
@Controller
public class TestController {

    private static final Logger logger= LogManager.getLogger(TestController.class);

    @RequestMapping("test")
    public String test(Map<String,Object> map){
        logger.info("开始渲染freemarker 文件");
        Map<String,String> all=new HashMap<>();
        all.put("fullName","机动及党员基层");
        all.put("custName","测试");
        all.put("custCode","11");
        all.put("billCode","12321");
        all.put("billGenTime","2018-04-3");
        all.put("area","100");
        all.put("bankAccount","12312311231");
        all.put("lastTotalBill","100");
        all.put("currTotalBill","200");
        all.put("totalLateFee","300");
        all.put("currBilling","500");
        Map<String,String> wy=new HashMap<>();
        wy.put("currFee","1");
        wy.put("lastBillFee","1");
        wy.put("lateFee","1");
        wy.put("shareFee","1");
        wy.put("lastPayed","1");
        wy.put("currPayed","1");
        wy.put("total","1");
        Map<String,String> bt=new HashMap<>();
        bt.put("currFee","1");
        bt.put("lastBillFee","1");
        bt.put("lateFee","1");
        bt.put("shareFee","1");
        bt.put("lastPayed","1");
        bt.put("currPayed","1");
        bt.put("total","1");
        Map<String,String> water=new HashMap<>();
        water.put("total","1");
        water.put("lastReading","1");
        water.put("totalReading","1");
        water.put("rate","1");
        water.put("useCount","1");
        water.put("currFee","1");
        water.put("lastBillFee","1");
        water.put("lateFee","1");
        water.put("shareFee","1");
        water.put("lastPayed","1");
        water.put("currPayed","1");
        Map<String,String> ele=new HashMap<>();
        ele.put("total","1");
        ele.put("lastReading","1");
        ele.put("totalReading","1");
        ele.put("rate","1");
        ele.put("useCount","1");
        ele.put("currFee","1");
        ele.put("lastBillFee","1");
        ele.put("lateFee","1");
        ele.put("shareFee","1");
        ele.put("lastPayed","1");
        ele.put("currPayed","1");
        map.put("all",all);
        map.put("wy",wy);
        map.put("bt",bt);
        map.put("water",water);
        map.put("ele",ele);
        return "bill";
    }
}
