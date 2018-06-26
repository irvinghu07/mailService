package com.irving.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送简单文字版本的邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    public boolean sendSimpleMessage(String to, String subject, String content) {
        boolean isSuccess = true;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            sender.send(message);
            logger.info("已经发送");
        } catch (MailException e) {
            isSuccess = false;
            e.printStackTrace();
            logger.error("发送简单邮件时候遇到错误", e);
        }
        return isSuccess;
    }
}
