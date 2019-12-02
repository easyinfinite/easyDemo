package com.oss.qiniuoss.sevice;

import com.google.gson.Gson;
import com.oss.qiniuoss.entity.QiniuConfig;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

/**
 * qiniu 工具类
 *
 * @auther: chenyunxuan
 * @date: 2019-11-30 17:58
 */
@Component
public class QiniuService {

    @Autowired
    private QiniuConfig config;


    public String uploadQiniuFiles(FileInputStream file, String fileName) {
        // 构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        // 其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            // 生成上传凭证，然后准备上传
            Auth auth = Auth.create(config.getAccessKeyId(), config.getAccessKeySecret());
            String upToken = auth.uploadToken(config.getBucketName());
            try {
                Response response = uploadManager.put(file, fileName, upToken, null, null);
                // 解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return config.getPath() + "/" + putRet.key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
