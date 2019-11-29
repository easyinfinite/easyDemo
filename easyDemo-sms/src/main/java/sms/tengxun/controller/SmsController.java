package sms.tengxun.controller;


import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sms.tengxun.entity.SendModel;
import sms.tengxun.service.AliyunSmsService;
import sms.tengxun.service.TencentSmsSevice;

/**
 * <p>
 * 发送短信控制器
 * </p>
 *
 * @author 陈云轩
 * @since 2019-10-21
 */
@RestController
@RequestMapping("/send")
public class SmsController {
    @Autowired
    private TencentSmsSevice tencentSmsSevice;
    @Autowired
    private AliyunSmsService aliyunSmsService;


    /**
     * 功能描述: 发送腾讯sms短信
     *
     * @param: [mobile]
     * @return: sms.tengxun.controller.SmsController
     * @auther: chenyunxuan
     * @date: 2019-11-29 18:31
     */
    @GetMapping("{mobile}")
    public void sendTencentSms(@PathVariable("mobile") String mobile) {
        tencentSmsSevice.sendCode(mobile);
    }


    /**
     * 功能描述: 发送aliyunsms短信
     *
     * @param: [mobile]
     * @return: sms.tengxun.controller.SmsController
     * @auther: chenyunxuan
     * @date: 2019-11-29 18:31
     */
    @GetMapping("/aliyun/{mobile}")
    public void sendAliyunSms(@PathVariable("mobile") String mobile) {
        SendModel sendModel=new SendModel();
        sendModel.setMobile(mobile);
        //传入JSON字符串
        sendModel.setTemplateParam("{\"branch\", \"巴博斯\"}");
        try {
            aliyunSmsService.sendSms(sendModel);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}

