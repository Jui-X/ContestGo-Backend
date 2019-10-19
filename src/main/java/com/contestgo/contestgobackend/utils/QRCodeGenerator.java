package com.contestgo.contestgobackend.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-21 19:59
 **/
public class QRCodeGenerator {

    public void QRCodeGenerate(ServletOutputStream stream){
        int width = 300;
        int height = 300;
        String format = ".png";
        String content = "http://127.0.0.1:8081/QRCode/login";

        HashMap hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 3);
        try {
            BitMatrix bitMatrix = null;
            try {
                bitMatrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            } catch (WriterException e) {
                e.printStackTrace();
            }

            MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
