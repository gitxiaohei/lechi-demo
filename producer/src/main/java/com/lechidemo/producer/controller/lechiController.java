package com.lechidemo.producer.controller;

import com.lechidemo.producer.domain.*;
import com.lechidemo.producer.service.lechiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@RequestMapping("/lechi")
@Controller
public class lechiController {
    @Autowired
    lechiService lechiService1;
    @RequestMapping("/login")
    public String login(@RequestParam("name") String name,@RequestParam("password") String password){
        boolean b = lechiService1.login(name, password);
        System.out.println(b);
        if (b){

            return "Order";
        }
        return "login";

    }
    @RequestMapping("/findpage")
    @ResponseBody
    public PageResult findpages(@RequestBody QueryPageBean queryPageBean){

       return lechiService1.findpage(queryPageBean);
    }

    @RequestMapping("/findproduct")
    @ResponseBody
    public Result findallProduct(){
        return lechiService1.findproduct();
    }

    @RequestMapping("/findorderbyid")
    @ResponseBody
    public Result findorderbyid(String orderid){
        return lechiService1.findByOrderId(orderid);
    }

    @RequestMapping("/editOrder")
    @ResponseBody
    public Result editOrder(String orderid,@RequestBody Order order){
        return lechiService1.editOrder(orderid,order);
    }

    @RequestMapping("/deleteOrderByid")
    @ResponseBody
    public Result deleteOrderByid (String orderid){
        return lechiService1.deleteByOrderid(orderid);
    }

    @ResponseBody
    @RequestMapping("/showproductById")
    public PageResult showproductByid(String orderid){
        return lechiService1.findproductByid(orderid);
    }
    @ResponseBody
    @RequestMapping("/showallproduct")
    public PageResult showproductByid(){
        return lechiService1.findallproduct();
    }

    @RequestMapping("/addproduct")
    @ResponseBody
    public Result addproduct(@RequestBody Product product){
        System.out.println("ZZZZZZZZZcccccccccZZZ"+product.getPname());
        return lechiService1.addproduct(product);
    }
}