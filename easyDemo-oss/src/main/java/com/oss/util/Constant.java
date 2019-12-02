package com.oss.util;

/**
 * 功能描述: 常量类
 *
 * @param:
 * @return: com.oss.util.Constant
 * @auther: chenyunxuan
 * @date: 2019-12-02 15:28
 */
public final class Constant {

    /**
     * 功能描述: 文件后缀
     *
     * @param:
     * @return: com.oss.util.Constant.suffix
     * @auther: chenyunxuan
     * @date: 2019-12-02 15:32
     */
    public interface suffix {
        String TXT = ".txt";
        String JPG = ".jpg";
        String GIF = ".gif";
        String JPEG = ".jpeg";
        String PNG = ".png";
        String BMP = ".bmp";
        String ZIP = ".zip";
        String RAR = ".rar";
        String DOC = ".doc";
        String DOCX = ".docx";
        String PDF = ".pdf";
        String XLS = ".xls";
        String XLSX = ".xlsx";
    }

    public interface limitSise {
        Integer MIDSIZE = 1024 * 1024 * 200;
    }

    /**
     * 功能描述: 支持所有类型
     *
     * @param: []
     * @return: com.oss.util.Constant
     * @auther: chenyunxuan
     * @date: 2019-12-02 15:38
     */
    public static String[] allSuffixSupport() {
        return new String[]{
                suffix.TXT,
                suffix.JPG,
                suffix.GIF,
                suffix.JPEG,
                suffix.PNG,
                suffix.BMP,
                suffix.ZIP,
                suffix.RAR,
                suffix.DOC,
                suffix.DOCX,
                suffix.PDF,
                suffix.XLS,
                suffix.XLSX
        };
    }


}
