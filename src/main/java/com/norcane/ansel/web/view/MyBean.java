package com.norcane.ansel.web.view;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyBean {

    public MyBean() {
        System.out.println("Created!");
    }

    public String getFrom() {
        return this.toString();
    }

    public String getDate() {
        return new Date().toString();
    }
}
