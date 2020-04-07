package com.lechidemo.consumer.service;

import com.lechidemo.consumer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Myservice {
   @Autowired
    RestTemplate restTemplate;


    public String login(@RequestParam String name, @RequestParam String password){
       /* HashMap<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("password",password);*/
        boolean s = restTemplate.getForEntity("http://lechi-service/lechi/login?name={1}&password={2}", boolean.class, new Object[
                ]{name, password}).getBody();
        //String s = restTemplate.getForObject("http://lechi-service/lechi/login", String.class,map);
        if (s){
            return "Order";
        }
        return "login";
    }
    public PageResult findpage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = restTemplate.postForObject("http://lechi-service/lechi/findpage", queryPageBean, PageResult.class);

        return pageResult;
    }

    public Result findRroduct(){
        Result productresult = restTemplate.getForObject("http://lechi-service/lechi/findproduct", Result.class);
        return productresult;
    }

    public Result findOrderById(String orderid) {
        Result forObject = restTemplate.getForObject("http://lechi-service/lechi/findorderbyid?orderid=" + orderid, Result.class);
        return forObject;

    }

    public Result editOrderByOrderId(String orderid, Order order) {
        Result result = restTemplate.postForObject("http://lechi-service/lechi/editOrder?orderid=" + orderid, order, Result.class);
        return result;
    }

    public Result deleteOrderByid(String orderid) {
        return restTemplate.getForObject("http://lechi-service/lechi/deleteOrderByid?orderid="+orderid,Result.class);

    }

    public PageResult showProductByid(String orderid) {
        return restTemplate.getForObject("http://lechi-service/lechi/showproductById?orderid="+orderid,PageResult.class);
    }

    public Result addProduct(Product product) {
        return restTemplate.postForObject("http://lechi-service/lechi/addproduct",product,Result.class);

    }

    public Result addOrderAndProduct(List productids, Order order) {
        return restTemplate.postForObject("http://lechi-service/lechi/addOrderAndProduct?productids="+productids,order,Result.class);
    }
}
