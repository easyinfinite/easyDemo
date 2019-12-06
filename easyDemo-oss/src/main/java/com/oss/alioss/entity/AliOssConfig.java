package com.oss.alioss.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 *
 * 阿里云oss配置
 * @author: chenyunxuan
 * @date: 2019-11-30 17:41
 */
@Data
@Component
public class AliOssConfig implements Serializable {
    /**
     * 产品accessKeyId
     */
    @Value("${aliyun.info.accessKeyId}")
    private String accessKeyId;
    /**
     * 产品accessKeySecret
     */
    @Value("${aliyun.info.accessKeySecret}")
    private String accessKeySecret;
    /**
     * 节点域名
     */
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    /**
     * 快照名称
     */
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    /**
     * 返回文件地址前缀
     */
    @Value("${aliyun.oss.backUrl}")
    private String backUrl;
    /**
     * 文件夹名称
     */
    @Value("${aliyun.oss.fileName}")
    private String fileName;
}
