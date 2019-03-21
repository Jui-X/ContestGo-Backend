package com.contestgo.contestgobackend.Controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class sendMailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/sendMail")
    public void sendMail(@RequestBody(required = true)JSONObject contest_info) throws MessagingException {
        String receiver = contest_info.getString("email_address");
        String contest = contest_info.getString("contest_name");
        System.out.println(receiver);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        //是否发送的邮件是富文本（附件，图片，html等）
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("501315555@qq.com");
        mimeMessageHelper.setTo(receiver);

        mimeMessageHelper.setSubject(contest + "比赛的相关信息附件");
        mimeMessageHelper.setText("附件是" + contest + "比赛的相关附件，请您查收~");
        mimeMessageHelper.addAttachment("附件.docx", new FileSystemResource("C:\\Users\\50131\\Documents\\GitHub\\ContestGo-Backend\\src\\main\\resources\\file\\report.docx"));

        javaMailSender.send(mimeMessage);
    }
}
