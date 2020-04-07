package com.lechidemo.producer.domain;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String orderid;
    private String ordercode;
    private Date ordertime;
    private String builder;
    private String str_ordertime;

    public String getStr_ordertime() {
        return str_ordertime;
    }

    public void setStr_ordertime(String str_ordertime) {
        this.str_ordertime = str_ordertime;
    }
    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    private float totalprice;


    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }



    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }
}
