package sms.tengxun.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}

