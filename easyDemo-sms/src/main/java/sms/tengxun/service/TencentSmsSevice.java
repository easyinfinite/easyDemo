package sms.tengxun.service;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sms.tengxun.entity.TencentSmsModel;

/**
 * 功能描述: 发送
 *
 * @param:
 * @return: sms.tengxun.SendSMSUtils
 * @auther: chenyunxuan
 * @date: 2019-11-29 18:01
 */
@Component
public class TencentSmsSevice {
    @Autowired
    private TencentSmsModel tencentSmsModel;

    //验证码以及过期时间
    static String[] toolList = new String[2];

    /**
     * 功能描述:  这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
     *
     * @return: sms.tengxun.SendSMSUtils
     * @auther: chenyunxuan
     * @date: 2019-11-29 18:00
     */
    public String sendCode(String phoneNumber) {
        String code = String.valueOf((long) (Math.random() * 9 * Math.pow(10, 4 - 1)) + (long) Math.pow(10, 4 - 1));
        try {
            toolList[0] = code;
            toolList[1] = tencentSmsModel.getExpireTime();
            SmsSingleSender ssender = new SmsSingleSender(tencentSmsModel.getAppid(), tencentSmsModel.getAppkey());
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber, tencentSmsModel.getTemplateId(), toolList, tencentSmsModel.getSmsSign(), "", "");
        } catch (Exception e) {// HTTP响应码错误
            e.printStackTrace();
        }
        return code;
    }


}
