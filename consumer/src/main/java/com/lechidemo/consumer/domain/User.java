package com.lechidemo.consumer.domain;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String password;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
