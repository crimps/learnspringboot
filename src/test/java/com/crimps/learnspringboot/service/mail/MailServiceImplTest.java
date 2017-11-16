package com.crimps.learnspringboot.service.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by crimps on 2017/11/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {
    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleMain() throws Exception {
        mailService.sendSimpleMain("xxxyy@oo.com", "test simple mail", "蛤蛤蛤蛤蛤蛤");
    }

    @Test
    public void sendHtmlMail() throws Exception {
        String content = "<html>\n" +
                "    <body>\n" +
                "        <h1>蛤蛤蛤蛤</h1>\n" +
                "    </body>\n" +
                "</html>";
        mailService.sendHtmlMail("xxxyy@oo.com", "test html mail", content);
    }


}