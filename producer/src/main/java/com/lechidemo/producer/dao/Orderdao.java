package com.lechidemo.producer.dao;

import com.github.pagehelper.Page;
import com.lechidemo.producer.domain.Order;
import com.lechidemo.producer.domain.PageResult;
import com.lechidemo.producer.domain.Product;
import com.lechidemo.producer.domain.QueryPageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface Orderdao {
    List<Order> findpage(QueryPageBean queryPageBean);

    Page<Order> findpages(String queryString);

    List<Product> findallProduct();

    Order findByOrderId(String orderid);

    void editOrderByorderId(@Param("orderid") String orderid, @Param("order") Order order);
    void editOrderid(@Param("orderid") String orderid,@Param("neworderid") String neworderid);

    void deleteOrderwithID(String orderid);

    //Page<Product> findProductByorderid(String orderid);
    List<Product> findProductsByorderid(String orderid);

    void addProduct(Product product);
}
