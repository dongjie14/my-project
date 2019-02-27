package com.easyget.controller;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 获取图片验证码
 */
@Controller
@RequestMapping
public class JcaptchaController {
    public static final String CAPTCHA_IMAGE_FORMAT = "jpeg";

    @Resource
    private ImageCaptchaService captchaService;

    @RequestMapping("/captcha.svl")
    protected void captcha(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        byte[] captchaChallengeAsJpeg = null;
        // the output stream to render the captcha image as jpeg into
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // get the session id that will identify the generated captcha.
            // the same id must be used to validate the response, the session id
            // is a good candidate!

            String captchaId = request.getSession().getId();
            BufferedImage challenge = captchaService.getImageChallengeForID(
                    captchaId, request.getLocale());
            // Jimi.putImage("image/jpeg", challenge, jpegOutputStream);
            ImageIO.write(challenge, CAPTCHA_IMAGE_FORMAT, jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        } catch (CaptchaServiceException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        // catch (JimiException e) {
        // response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        // return;
        // }

        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

        // flush it in the response
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/" + CAPTCHA_IMAGE_FORMAT);

        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
