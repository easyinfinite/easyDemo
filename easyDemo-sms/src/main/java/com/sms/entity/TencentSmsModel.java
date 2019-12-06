package com.sms.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 功能描述: 腾讯短信模板实体
 *
 * @return: sms.tengxun.entity.TencentSmsModel
 * @author: chenyunxuan
 * @date: 2019-11-29 17:26
 */
@Data
@Component
//@ConfigurationProperties(prefix = "tencent.sms")
public class TencentSmsModel implements Serializable {

    /**
     * 短信应用SDK AppID
     */
    @Value("${tencent.sms.appid}")
    private Integer appid;
    /**
     * 短信应用SDK AppKey
     */
    @Value("${tencent.sms.appkey}")
    private String appkey;
    /**
     * 短信模板ID，需要在短信应用中申请
     */
    @Value("${tencent.sms.templateId}")
    private Integer templateId;
    /**
     * 签名
     */
    @Value("${tencent.sms.smsSign}")
    private String smsSign;
    /**
     * 过期时间
     */
    @Value("${tencent.sms.expireTime}")
    private String expireTime;
}
