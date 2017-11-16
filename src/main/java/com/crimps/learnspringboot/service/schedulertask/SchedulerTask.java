package com.crimps.learnspringboot.service.schedulertask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *
 * @author crimps
 * @create 2017-11-16 15:20
 **/
@Component
public class SchedulerTask {
    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task runing " + (count ++));
    }
}
