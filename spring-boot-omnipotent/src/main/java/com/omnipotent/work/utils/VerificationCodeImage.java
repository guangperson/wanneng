package com.omnipotent.work.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerificationCodeImage {
    //生成的验证码
    private String code;
    //验证码图片的宽高
    private static final int CAPTCHA_WIDTH  = 200;
    private static final int CAPTCHA_HEIGHT = 50;

    private Random random = new Random();
    //用于随机的验证码字体
    private String[] fontFamilies = { "宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312" };
    //构造一个包含了指定验证码图片的工具对象
    public VerificationCodeImage(String code) {
        this.code = code;
    }
    //生成随机颜色
    //0：黑 255：白：
    private Color randomColor(){
        int r = random.nextInt(180);
        int g = random.nextInt(180);
        int b = random.nextInt(180);
        return new Color(r,g,b);
    }
    //随机字体
    private Font randomFont(){
        //随机字体名
        String fontName = fontFamilies[random.nextInt(fontFamilies.length)];
        // 生成随机的样式, 0(无样式), 1(粗体), 2(斜体), 3(粗体+斜体)
        int style = random.nextInt(4);
        //随机字体大小
        int size = random.nextInt(5) + 24;
        return new Font(fontName,style,size);
    }
    //绘制线条，干扰线
    private void drawLine(BufferedImage img){
        //生成条数
        int lineCount = 20;
        //获取画笔对象
        Graphics2D g = (Graphics2D) img.getGraphics();
        for (int i = 0; i < lineCount; i++) {
            //随机线条的起始喝结束位置坐标
            int x1 = random.nextInt(CAPTCHA_WIDTH);
            int y1 = random.nextInt(CAPTCHA_HEIGHT);
            int x2 = random.nextInt(CAPTCHA_WIDTH);
            int y2 = random.nextInt(CAPTCHA_HEIGHT);
            //设置线条的粗细
            g.setStroke(new BasicStroke(1F));
            //设置线条的颜色
            g.setColor(randomColor());
            //绘制线条
            g.drawLine(x1, y1, x2, y2);
        }
    }
    //创建图片
    public BufferedImage createImg(){
        //创建一个指定大小的图片对象
        BufferedImage img = new BufferedImage(CAPTCHA_WIDTH, CAPTCHA_HEIGHT, BufferedImage.TYPE_INT_RGB);
        //获取图片的画笔
        Graphics2D g = (Graphics2D) img.getGraphics();
        //设置画笔颜色
        g.setColor(new Color(255, 255, 255));
        //设置画笔的绘制范围
        g.fillRect(0, 0, CAPTCHA_WIDTH, CAPTCHA_HEIGHT);
        //对每一个验证码字符串进行样式处理之后显示到图片中
        for (int i = 0; i < code.length(); i++) {
            //获取每一个验证码字符
            String s = code.charAt(i) + "";
            //获取一个当前字符绘制坐标
            float x = i * 1.0F * CAPTCHA_WIDTH / code.length() + 7F;
            //设置随机字体
            g.setFont(randomFont());
            //设置随机颜色
            g.setColor(randomColor());
            //将字符写入到图片中
            g.drawString(s,x,CAPTCHA_HEIGHT - 7);
        }
        //绘制干扰线
        drawLine(img);
        //返回图片
        return img;
    }


}
