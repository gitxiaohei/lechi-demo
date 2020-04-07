package com.lechidemo.producer.domain;

import java.io.Serializable;

public class Product implements Serializable {
    private String pname;
    private float price;
    private String pmsg;
    private int count;

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public Product(String pname, float price, String pmsg, int count, float totalprice) {
        this.pname = pname;
        this.price = price;
        this.pmsg = pmsg;
        this.count = count;
        this.totalprice = totalprice;
    }

    private String orderid;
    private float totalprice;

    public Product(String pname, float price, String pmsg, int count, String orderid) {
        this.pname = pname;
        this.price = price;
        this.pmsg = pmsg;
        this.count = count;
        this.orderid = orderid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product(String pname, float price, String pmsg, int count, int id) {
        this.pname = pname;
        this.price = price;
        this.pmsg = pmsg;
        this.count = count;
        this.id = id;
    }

    private int id;


    public Product() {
    }

    public Product(String pname, float price, String pmsg, int count) {
        this.pname = pname;
        this.price = price;
        this.pmsg = pmsg;
        this.count = count;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPmsg() {
        return pmsg;
    }

    public void setPmsg(String pmsg) {
        this.pmsg = pmsg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
