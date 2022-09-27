package com.omnipotent.work.control;

import com.alibaba.fastjson.JSONObject;
import com.omnipotent.work.service.impl.RedisServiceImpl;
import com.omnipotent.work.utils.CodeUtils;
import com.omnipotent.work.utils.VerificationCodeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author tanxinguang
 * 2022/9/16
 */
@RestController
@RequestMapping("/util")
public class UtilsControl {
    @Autowired
    RedisServiceImpl redisService;

    //验证码缓存
    private static String code;

    @RequestMapping("/imgCode")
    public void imgcode(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
        //生成验证码
        code = CodeUtils.getCode4Hard();
        String remortIP = getRemortIP(request);
        System.out.println("用户ip访问：" + remortIP);
        //将验证码存储redis中
//        redisService.setValue("code", code);
//        System.out.println("当前验证码" + code);
        //设置响应的内容类型（图片）
        response.setContentType("img/jpeg");
        //防止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //将图片通过respose输出流输出图片
        ImageIO.write(new VerificationCodeImage(code).createImg(), "JPEG", response.getOutputStream());
    }

    /**
     * 获得用户uuid存入redis
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/setUUid")
    public void setUUid(HttpServletRequest request) throws IOException, InterruptedException {

        while (!Objects.nonNull(code)) {
            Thread.sleep(1000);
        }
        System.out.println("UUid的code:"+code);
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String s = reader.readLine();
        JSONObject jsonObject = JSONObject.parseObject(s);
        String data = jsonObject.getString("data");
        jsonObject = JSONObject.parseObject(data);
        String codeKey = jsonObject.getString("codeKey");
        System.out.println("redis key:"+codeKey);
        //将验证码存储redis中
        redisService.setValue(codeKey, code);
    }


    /**
     * 获得访问者真实ip
     *
     * @param request
     * @return
     */
    public String getRemortIP(HttpServletRequest request) {
        String ip = "";
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        } else {
            ip = request.getHeader("x-forwarded-for");
        }
        return ip.split(",")[0];
    }
}
