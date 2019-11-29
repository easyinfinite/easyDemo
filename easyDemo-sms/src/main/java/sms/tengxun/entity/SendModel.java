package sms.tengxun.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 功能描述: 发送短信参数
 *
 * @param:
 * @return: sms.tengxun.entity.SendModel
 * @auther: chenyunxuan
 * @date: 2019-11-29 19:34
 */
@Data
public class SendModel implements Serializable {

    /**
     * 电话
     */
    private String mobile;
    /**
     * 发送参数
     * 格式:  Map<String, String> parm = new HashMap<>();
     *         parm.put("model", "巴博斯 smart fortwo 2018款 0.9T 硬顶BRABUS Xclusive");
     *         parm.put("branch", "巴博斯");
     *         parm.put("colorInner", "红色/绿色");
     *         parm.put("num", "111");
     *         System.out.println(JSON.toJSONString(parm));
     */
    private String templateParam;
}
