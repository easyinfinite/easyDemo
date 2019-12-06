package com.oss.alioss.sevice;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.oss.alioss.entity.AliOssConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * alioss 工具类
 * @author: chenyunxuan
 * @date: 2019-11-30 17:58
 */
@Component
public class AliOssService {

    @Autowired
    private AliOssConfig config;

    /**
     * 上传文件，返回访问链接
     * <p>Description: </p>
     *
     * @param imageFile
     * @return
     * @author: luoshun
     * @version: v1.0 2016年10月24日
     */
    public String uploadFile(MultipartFile imageFile) {
        String fileName = imageFile.getOriginalFilename();
        try {
            InputStream stream = imageFile.getInputStream();
            Long size = imageFile.getSize();
            fileName = uploadFile(fileName, stream, size);
            return config.getBackUrl() + fileName + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 功能描述: 上传到阿里云
     *
     * @param: [key, stream, size]
     * @return: com.oss.alioss.util.UploadOss
     * @author: chenyunxuan
     * @date: 2019-11-30 17:56
     */
    public String uploadFile(String key, InputStream stream, long size) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String d = formatter.format(new Date());
        String first = d.substring(0, 7).replace("-", "");
        String sec = d.substring(8, 10);
        key = first + "/" + sec + "/" + key;
        OSSClient client = new OSSClient(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(size);
        client.putObject(config.getBucketName(), config.getFileName() + key, stream, meta);
        return key;
    }

    public void uploadFile(String bucketName, String key, String filePath) throws Exception {
        OSSClient client = new OSSClient(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
        File file = new File(filePath);
        InputStream stream = new FileInputStream(file);

        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(file.length());
        //PutObjectResult result =
        client.putObject(bucketName, key, stream, meta);

    }


}
