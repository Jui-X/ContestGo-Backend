package com.contestgo.contestgobackend.utils;

import com.contestgo.contestgobackend.vo.ContestAttachmentVO;
import com.contestgo.contestgobackend.vo.ResumeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-24 13:26
 **/
@Service
public class SendMailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendContestAttachmentEmail(String receiver, ContestAttachmentVO attachment) throws MessagingException {
        String contest_name = attachment.getContest_name();
        String contest_attachment = attachment.getContest_attachment();

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
    }

    public void sendResume(String receiver, ResumeVO resumeVO) throws MessagingException {
        String stu_id = resumeVO.getStu_id();
        String username = resumeVO.getUsername();
        String school = resumeVO.getSchool();
        String department = resumeVO.getDepartment();
        String phone_num = resumeVO.getPhone_num();
        String resume = resumeVO.getResume();

        StringBuilder resumeInfo = new StringBuilder();
        resumeInfo.append("来自 ");
        resumeInfo.append(school);
        resumeInfo.append(" ");
        resumeInfo.append(department);
        resumeInfo.append(" 学院的同学 ");
        resumeInfo.append(username);
        resumeInfo.append(" （学号：");
        resumeInfo.append(stu_id);
        resumeInfo.append("）向您发起组队邀请。以下是他的个人自我介绍：");
        resumeInfo.append(resume);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("501315555@qq.com");
        mimeMessageHelper.setTo(receiver);
        mimeMessageHelper.setSubject("您收到新的组队邀请，请查收～");
        mimeMessageHelper.setText(resumeInfo.toString());

        javaMailSender.send(mimeMessage);
    }
}
