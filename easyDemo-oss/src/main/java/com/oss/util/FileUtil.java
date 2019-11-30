package com.oss.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * oss 工具类
 * @auther: chenyunxuan
 * @date: 2019-11-30 17:58
 */
public class FileUtil {
    /**
     * 生成随机文件名：当前年月日时分秒+五位随机数
     *
     * @return
     */
    public static String getRandomFileName() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return rannum + str;// 当前时间

    }
}
