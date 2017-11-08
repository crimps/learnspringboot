package com.crimps.learnspringboot.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author crimps
 * @create 2017-11-08 13:49
 **/
@Component
public class ConstantProperties {
    @Value("${com.crimps.title}")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
