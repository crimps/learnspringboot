package com.crimps.learnspringboot.service.schedulertask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间定时任务
 *
 * @author crimps
 * @create 2017-11-16 15:22
 **/
@Component
public class SchedulerTimeTask {
    private static final SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("now time :" + dateFormate.format(new Date()));
    }
}
