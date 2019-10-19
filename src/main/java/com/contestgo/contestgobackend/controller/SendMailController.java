package com.contestgo.contestgobackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.service.ContestService;
import com.contestgo.contestgobackend.utils.JsonResult;
import com.contestgo.contestgobackend.vo.ContestAttachmentVO;
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
public class SendMailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ContestService contestService;

    @PostMapping("/sendMail")
    public JsonResult sendMail(@RequestBody()JSONObject contest_info) throws MessagingException {
        String receiver = contest_info.getString("email_address");
        int contest_id = Integer.valueOf(contest_info.getString("contest_id"));

        // 获得竞赛附件相关信息
        ContestAttachmentVO contestAttachmentVO = contestService.getContestAttachment(contest_id);
        if (contestAttachmentVO == null) {
            return JsonResult.errorMsg("Contest Attachment is not found...");
        }
        String contest_name = contestAttachmentVO.getContest_name();
        String contest_attachment = contestAttachmentVO.getContest_attachment();

        // 需要发送的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        //是否发送的邮件是富文本（附件，图片，html等）
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("501315555@qq.com");
        mimeMessageHelper.setTo(receiver);

        mimeMessageHelper.setSubject(contest_name + "比赛的相关信息附件");
        mimeMessageHelper.setText("附件是" + contest_name + "比赛的相关附件，请您查收~");
        mimeMessageHelper.addAttachment("附件.docx", new FileSystemResource(contest_attachment));

        javaMailSender.send(mimeMessage);

        return JsonResult.ok("已成功发送附件～～");
    }
}
