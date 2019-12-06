package com.sms.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 功能描述: 阿里云短信模板实体
 *
 * @return: sms.tengxun.entity.TencentSmsModel
 * @author: chenyunxuan
 * @date: 2019-11-29 17:26
 */
@Data
@Component
public class AliyunSmsModel implements Serializable {

    /**
     * 短信模板ID，需要在短信应用中申请
     */
    @Value("${aliyun.sms.templateCode}")
    private String templateCode;
    /**
     * 签名
     */
    @Value("${aliyun.sms.smsSign}")
    private String smsSign;
    /**
     * 云通信短信API产品,开发者无需替换
     */
    @Value("${aliyun.info.product}")
    private String product;
    /**
     * 产品域名,开发者无需替换
     */
    @Value("${aliyun.info.domain}")
    private String domain;
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
}
