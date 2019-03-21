package com.contestgo.contestgobackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-21 12:18
 **/
@RestController
@RequestMapping("/sendMail")
public class sendMailController {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String receiver) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        //是否发送的邮件是富文本（附件，图片，html等）
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("501315555@qq.com");
        mimeMessageHelper.setTo(receiver);

        mimeMessageHelper.setSubject("请查收比赛附件~");
        mimeMessageHelper.setText("附件是比赛相关信息，请您查收~");
        mimeMessageHelper.addAttachment("附件", new FileSystemResource("C:\\Users\\50131\\Documents\\GitHub\\ContestGo-Backend\\src\\main\\resources\\file\\report.txt"));

        javaMailSender.send(mimeMessage);
    }
}
