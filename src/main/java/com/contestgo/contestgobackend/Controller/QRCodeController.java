package com.contestgo.contestgobackend.Controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.DO.WXSession;
import com.contestgo.contestgobackend.Utils.JsonResult;
import com.contestgo.contestgobackend.Utils.QRCodeGenerator;
import com.contestgo.contestgobackend.Utils.RedisUtils;
import com.contestgo.contestgobackend.Utils.WXLogin;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-31 20:19
 **/
@Controller
@RequestMapping("/QRcode")
public class QRCodeController {

    @Autowired
    private RedisUtils redis;

    @RequestMapping("")
    public String QRCode() {
        return "QRCode";
    }

    @RequestMapping("/getQRCode")
    public void getQRCode(HttpServletResponse response) {
        ServletOutputStream stream = null;

        QRCodeGenerator qrCodeGenerator = new QRCodeGenerator();

        try {
            stream = response.getOutputStream();
            qrCodeGenerator.QRCodeGenerate(stream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(stream != null) {
                try {
                    stream.flush();
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @PostMapping("/login")
    public JsonResult login(@RequestBody(required = true)JSONObject codeJson) {
        String code = codeJson.getString("code");

        WXLogin wxLogin = new WXLogin();

        WXSession session = wxLogin.WXLogin(code);

        String open_id = session.getOpenid();

        if (redis.get(open_id) != null) {
            if (redis.get(open_id) == session.getSession_key()) {
                return JsonResult.ok();
            }
            else {return JsonResult.errorMsg("登录出错！请在小程序端重新授权登陆。");}
        }
        else {return JsonResult.errorMsg("您尚未在小程序端授权登陆！");}
    }
}
