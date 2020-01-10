package com.oss.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 * @ClassName:photoUtil
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2020/1/9 7:18 下午
 * @version: 1.0.0
 **/
public class photoUtil {
    /**
     * 二维码图片的生成
     *
     * @param content       链接
     * @param qrcode_width  二维码宽
     * @param qrcode_height 二维码高
     * @return
     * @throws Exception
     */
    public static BufferedImage createImage(String content, int qrcode_width, int qrcode_height) throws Exception {

        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, qrcode_width, qrcode_height, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        /*背景色,默认黑色 0xFF000000*/
        /*前景色，默认白色 0xFFFFFFFF*/
        /*前景色，默认黄色 0xFFffe400*/
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
                        : 0xFFFFFFFF);
            }
        }
        return image;

    }

    // 从服务器获得一个输入流(本例是指从服务器获得一个image输入流)
    public static InputStream getInputStream(String URL_PATH) {
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(URL_PATH);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            // 设置网络连接超时时间
            httpURLConnection.setConnectTimeout(3000);
            // 设置应用程序要从网络连接读取数据
            httpURLConnection.setDoInput(true);

            httpURLConnection.setRequestMethod("GET");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                // 从服务器返回一个输入流
                inputStream = httpURLConnection.getInputStream();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    /**
     * 缩小Image，此方法返回源图像按给定宽度、高度限制下缩放后的图像
     *
     * @param inputImage
     * @param newWidth：压缩后宽度
     * @param newHeight：压缩后高度
     * @throws IOException return
     */
    public static BufferedImage scaleByPercentage(BufferedImage inputImage, int newWidth, int newHeight) throws Exception {
        //获取原始图像透明度类型
        int type = inputImage.getColorModel().getTransparency();
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();
        //开启抗锯齿
        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //使用高质量压缩
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        BufferedImage img = new BufferedImage(newWidth, newHeight, type);
        Graphics2D graphics2d = img.createGraphics();

        graphics2d.setRenderingHints(renderingHints);
        graphics2d.drawImage(inputImage, 0, 0, newWidth, newHeight, 0, 0, width, height, null);
        graphics2d.dispose();
        return img;
    }

    /**
     * 变为圆形
     * 传入的图像必须是正方形的 才会 圆形 如果是长方形的比例则会变成椭圆的
     *
     * @param bi1 用户头像
     * @return
     * @throws IOException
     */
    public static BufferedImage convertCircular(BufferedImage bi1) throws IOException {
        //这种是黑色底的
        //BufferedImage bi2 = new BufferedImage(bi1.getWidth(),bi1.getHeight(),BufferedImage.TYPE_INT_RGB);

        //透明底的图片
        BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, bi1.getWidth(), bi1.getHeight());
        Graphics2D g = bi2.createGraphics();
        g.setClip(shape);
        // 使用 setRenderingHint 设置抗锯齿
        // 设置“抗锯齿”的属性
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.drawImage(bi1, 0, 0, null);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP));
        //设置颜色
        g.setBackground(Color.WHITE);
        g.dispose();
        return bi2;
    }

    /**
     * 指定位置合并图片
     *
     * @param imgNew
     * @param x      相对背景图片的X轴
     * @param y      相对背景图片的Y轴
     * @return
     */
    public static BufferedImage compositeTwoImg(BufferedImage imgNew, int x, int y) {

        try {

            BufferedImage headImage = imgNew;

            InputStream inputStream = getInputStream("http://xiaovapppic.xiaovka.com/ein/tinymall/sao/1104.jpg");
            BufferedImage back = ImageIO.read(inputStream);
            // 画图
            Graphics2D g = back.createGraphics();
            g.setColor(Color.black);

            //画二维码
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.9f));
            g.drawImage(headImage, 558, 210, 100, 100, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

            g.dispose();
            back.flush();

            return back;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static BufferedImage compositeImage(String url, int startX, int startY, int codeWidth, int codeHeight) {
        try {
            // 二维码图片
            BufferedImage headImage = createImage(url, 500, 500);

//            BufferedImage compositeTwoImg = compositeTwoImg(headImage, startX, startY);

            return headImage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 测试代码，线上注释掉
    public static void main(String[] args) throws Exception {

//  String path1 = "C:\\image\\Downloads\\";
//  String formatName = "12.png";
        String url = "https:www.baidu.com";
        BufferedImage compositeImage = compositeImage(url, 0, 0, 0, 0);
//  BufferedImage compositeImage = createImage(url,500,500);

//  ImageIO.write(compositeImage, "png", new File(path1+formatName));

        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ImageOutputStream imOut = ImageIO.createImageOutputStream(bs);
        ImageIO.write(compositeImage, "png", imOut);
        InputStream is = new ByteArrayInputStream(bs.toByteArray());

        Integer available = is.available();
        Long size = available.longValue();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = sdf.format(new Date()) + "001";
        //初始化OSSClient
//        String fileNameOSS = UploadOss.uploadFile(fileName+".png", is, size);
//        System.out.println(fileNameOSS);
    }
}
