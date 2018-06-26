package com.irving.mail.controller;

import com.irving.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MailController {
    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/mail/tosend")
    public String toSendMail() {
        return "mail";
    }

    @PostMapping("/mail/fetchMail.do")
    @ResponseBody
    public Map<String, Object> sendMail(@RequestParam("receiver") String receiver, @RequestParam("subject") String subject, @RequestParam("content") String content) {
        Map<String, Object> model = new HashMap<>();
        model.put("isSuccess", mailService.sendSimpleMessage(receiver, subject, content));
        return model;
    }
}
