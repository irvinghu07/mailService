package com.irving.mail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest{
    @Autowired
    private  MailService mailService;

    @Test
    public void sendSimpleMsg() {
        mailService.sendSimpleMessage("1609501206@qq.com", "测试邮件发送", "Hello from Spring Boot Mail");
    }
}