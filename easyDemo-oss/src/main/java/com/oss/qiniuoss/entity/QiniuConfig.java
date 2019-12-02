package com.oss.qiniuoss.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 七牛云oss配置
 *
 * @auther: chenyunxuan
 * @date: 2019-11-30 17:41
 */
@Data
@Component
public class QiniuConfig implements Serializable {
    /**
     * 产品accessKeyId
     */
    @Value("${qiniu.info.accessKeyId}")
    private String accessKeyId;
    /**
     * 产品accessKeySecret
     */
    @Value("${qiniu.info.accessKeySecret}")
    private String accessKeySecret;
    /**
     * 快照名称
     */
    @Value("${qiniu.info.bucketName}")
    private String bucketName;
    /**
     * 地址域名
     */
    @Value("${qiniu.info.path}")
    private String path;
}
