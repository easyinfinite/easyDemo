package com.oss.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * oss 工具类
 *
 * @auther: chenyunxuan
 * @date: 2019-11-30 17:58
 */
public class FileUtil {
    /**
     * 功能描述: 生成随机文件名：当前年月日时分秒+五位随机数
     *
     * @param: []
     * @return: com.oss.util.FileUtil
     * @auther: chenyunxuan
     * @date: 2019-12-02 15:25
     */
    public static String getRandomFileName() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();
        // 获取5位随机数
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;
        // 当前时间
        return rannum + str;
    }

    /**
     * 功能描述: 是否支持格式
     *
     * @param: [contentType, allowTypes]
     * @return: com.oss.util.FileUtil
     * @auther: chenyunxuan
     * @date: 2019-12-02 15:25
     */
    public static boolean isValid(String contentType, String... allowTypes) {
        if (null == contentType || "".equals(contentType)) {
            return false;
        }
        for (String type : allowTypes) {
            if (contentType.indexOf(type) > -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 功能描述: 是否支持所有格式
     *
     * @param: [contentType]
     * @return: com.oss.util.FileUtil
     * @auther: chenyunxuan
     * @date: 2019-12-02 15:45
     */
    public static boolean isValid(String contentType) {
        return isValid(contentType, Constant.allSuffixSupport());
    }

}
