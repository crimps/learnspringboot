package com.crimps.learnspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author crimps
 * @create 2017-11-08 10:11
 **/
@RestController
public class DestoryWorldController {

    @RequestMapping("/destory")
    public String index() {
        return "Destory World !!!";
    }
}
