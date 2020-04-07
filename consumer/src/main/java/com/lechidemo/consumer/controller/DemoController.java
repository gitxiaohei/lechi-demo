package com.lechidemo.consumer.controller;

import com.lechidemo.consumer.domain.*;
import com.lechidemo.consumer.service.Myservice;
import com.lechidemo.consumer.service.lechiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/lechi")
@Controller
public class DemoController {
     @Autowired
     Myservice myservice;
    /*@Autowired
    DemoService demoService;*/
    @Autowired
    lechiService lechiservice;

    @RequestMapping("/login")
    public String login( String name,String password,Model model) {

        String loginname = lechiservice.login(name, password);
        if (loginname!=null&&loginname.length()>0){
            model.addAttribute("msg",loginname);
            return "setmeal";
        }
        model.addAttribute("msg","登陆失败");
        return "login";
    }
    @RequestMapping("/liu")
    public String a5(Model model){
        model.addAttribute("msg","失败是成功之母");
        return "login2";
    }
    @RequestMapping("/pro")

    public String aa5( ){
        return "pro";
    }
    @RequestMapping("/showOrder")
    @ResponseBody
    public PageResult orderList(@RequestBody QueryPageBean queryPageBean){

     return myservice.findpage(queryPageBean);
    }

    @RequestMapping("/findproduct")
    @ResponseBody
    public Result findallproduct(){
        return myservice.findRroduct();
    }

    @RequestMapping("/findorderbyid")
        @ResponseBody
        public Result findorderbyid (String orderid){
            return myservice.findOrderById(orderid);
        }
        @RequestMapping("/editOrder")
        @ResponseBody
        public Result editOrder(String orderid,@RequestBody Order order){
            return myservice.editOrderByOrderId(orderid,order);

    }
    @ResponseBody
    @RequestMapping("/deleteOrder")
    public Result deleteOrder (String orderid){
        return myservice.deleteOrderByid(orderid);
    }

    @RequestMapping("/showprodectByid")
    @ResponseBody
    public PageResult showprodectByid(String orderid){

        return myservice.showProductByid(orderid);

    }
    @RequestMapping("/addProduct")
    @ResponseBody
    public Result addProduct(@RequestBody Product product){
        return myservice.addProduct(product);
    }

    @RequestMapping("/addOrderAndProduct")
    @ResponseBody
    public Result addOrderAndProduct(@RequestParam("productids")List productids,@RequestBody Order order){
        return myservice.addOrderAndProduct(productids,order);
    }
}
