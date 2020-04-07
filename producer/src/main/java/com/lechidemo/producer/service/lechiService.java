package com.lechidemo.producer.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lechidemo.producer.dao.Orderdao;
import com.lechidemo.producer.dao.Userdao;
import com.lechidemo.producer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class lechiService {
    @Autowired
    Userdao userdao;
    @Autowired
    Orderdao orderdao;

    public boolean login(String name, String password) {
      /*  if (name.equals("123")&&password.equals("123")){
            return true;
        }*/
        User login1 = userdao.login(name, password);
        if (login1 != null) {
            return true;
        }
        return false;
    }

    public PageResult findpage(QueryPageBean queryPageBean) {
        //使用pagehelper插件进行分页
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<Order> findpages = orderdao.findpages(queryPageBean.getQueryString());
        long total = findpages.getTotal();
        /*List<Order> findpage = orderdao.findpage(queryPageBean);这个是不使用pagehelp查询所有记录*/
        List<Order> result = findpages.getResult();
        for (int i = 0; i < result.size(); i++) {
            Order order = result.get(i);
                Date ordertime = order.getOrdertime();
                String format = null;
                if (ordertime != null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                format = simpleDateFormat.format(ordertime);
            }
            order.setStr_ordertime(format);
        }

        return new PageResult(total, result);
    }

    public Result findproduct() {
        List<Product> products = orderdao.findallProduct();
        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getPname());
            list.add(products.get(i));
        }
        return new Result(true, "Giao", list);
    }

    public Result findByOrderId(String orderid) {

        Order order = orderdao.findByOrderId(orderid);
        if (order != null) {
            Date ordertime = order.getOrdertime();
            String format = null;
            if (ordertime != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                format = simpleDateFormat.format(ordertime);
            }
            order.setStr_ordertime(format);
            return new Result(true, "true", order);
        }
        return new Result(false, "查询失败");
    }

    public Result editOrder(String orderid, Order order) {
        try {
            String str_ordertime = order.getStr_ordertime();
            if (str_ordertime != null) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date parse = simpleDateFormat.parse(str_ordertime);
                    order.setOrdertime(parse);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return new Result(false, "修改失败");
                }
            }
            orderdao.editOrderByorderId(orderid, order);
            orderdao.editOrderid(orderid, order.getOrderid());
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "修改失败");
    }

    public Result deleteByOrderid(String orderid) {
        try {
            orderdao.deleteOrderwithID(orderid);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
        return new Result(true, "删除成功");
    }

    public PageResult findproductByid(String orderid) {
        //if (orderid == null||orderid.length()==0) {
        if (orderid.equals("0")) { //如果orderid为0的话，查询所有
            List<Product> productList = orderdao.findallProduct();
            for (int i = 0; i < productList.size(); i++) {
                float price = productList.get(i).getPrice();
                int count = productList.get(i).getCount();
                productList.get(i).setTotalprice(price*count);
            }
            return new PageResult((long) productList.size(), productList);
        } else {
            //PageHelper.startPage(0, 20, orderid);
            //Page<Product> productPage = orderdao.findProductByorderid(orderid);
            List<Product> productsByorderid = orderdao.findProductsByorderid(orderid);
            for (int i = 0; i < productsByorderid.size(); i++) {
                float price = productsByorderid.get(i).getPrice();
                int count = productsByorderid.get(i).getCount();
                productsByorderid.get(i).setTotalprice(price*count);
            }
            long total = (long) productsByorderid.size();
            return new PageResult(total,productsByorderid);
        }
    }

    public PageResult findallproduct() {
        List<Product> products = orderdao.findallProduct();
        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getPname());
            list.add(products.get(i));
        }
        return new PageResult(20l, products);
    }

    public Result addproduct(Product product) {
        if (product==null){
            return new Result(false,"添加失败");
        }
        try {
            orderdao.addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
        return new Result(true,"添加成功");
    }
}
