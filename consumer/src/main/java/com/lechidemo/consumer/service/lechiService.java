package com.lechidemo.consumer.service;

import com.lechidemo.consumer.dao.Userdao;
import com.lechidemo.consumer.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class lechiService {
    @Autowired
    Userdao userdao;

    public String login(String name, String password) {

/*  if (name.equals("123")&&password.equals("123")){
            return true;
        }*/

        User user = userdao.login(name, password);
        if (user!=null){
            return user.getName();
        }
        return null;
    }
}

