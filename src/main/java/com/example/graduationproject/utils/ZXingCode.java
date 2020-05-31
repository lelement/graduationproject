package com.example.graduationproject.utils;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 画制定logo和制定描述的二维码
 *
 * @author songyz
 *
 */
public class ZXingCode implements Serializable {
    /**
     * 生成支付二维码
     * @param response 响应
     * @param contents url链接
     * @throws Exception
     */
    public static void writerPayImage(HttpServletResponse response, String contents) throws Exception{
        ServletOutputStream out = response.getOutputStream();
        try {
            Map<EncodeHintType,Object> hints = new HashMap<EncodeHintType,Object>();
            hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE,300,300,hints);
            MatrixToImageWriter.writeToStream(bitMatrix,"jpg",out);
        }catch (Exception e){
            throw new Exception("生成二维码失败！");
        }finally {
            if(out != null){
                out.flush();
                out.close();
            }
        }
    }
}