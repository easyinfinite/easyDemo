package com.oss.qiniuoss.sevice;

import com.google.gson.Gson;
import com.oss.qiniuoss.entity.QiniuConfig;
import com.oss.util.FileUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
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

    /**
     * 获取token
     * <p>Description: </p>
     *
     * @param imageFile
     * @return
     * @author: luoshun
     * @version: v1.0 2016年10月24日
     */
//    public String getToken(MultipartFile imageFile) throws AuthException {
//        Mac mac = new Mac(config.getAccessKeyId(), config.getAccessKeySecret());
//        // 请确保该bucket已经存在
//        String bucketName = config.getBucketName();
//        PutPolicy putPolicy = new PutPolicy(bucketName);
//        String uptoken = putPolicy.token(mac);
//        return uptoken;
//    }
    public String uploadQNImg(FileInputStream file) {
        // 构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        // 其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        // 生成上传凭证，然后准备上传

        try {
            Auth auth = Auth.create(config.getAccessKeyId(), config.getAccessKeySecret());
            String upToken = auth.uploadToken(config.getBucketName());
            try {
                Response response = uploadManager.put(file, FileUtil.getRandomFileName(), upToken, null, null);
                // 解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//
                String returnPath = config.getPath() + "/" + putRet.key;
                return returnPath;
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
