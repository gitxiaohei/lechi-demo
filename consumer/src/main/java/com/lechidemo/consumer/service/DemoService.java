package com.lechidemo.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("lechi-service")
public interface DemoService {
    @RequestMapping("/lechi/login")
    String login(@RequestParam("name") String name, @RequestParam("password") String password);
}
