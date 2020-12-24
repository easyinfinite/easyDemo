package com.validation.valiNote.mobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: MobileValidator
 * @Description 自定义电话验证类
 * @Author: chenyunxuan
 * @Date: 2019-12-18 17:28
 * @version: 1.0.0
 **/
//ConstraintValidator接口使用了泛型，需要指定两个参数，第一个自定义注解类，第二个为需要校验的数据类型。
public class MobileValidator  implements ConstraintValidator<MobileVail, String> {
    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$"
    );

    @Override
    //初始化配置
    public void initialize(MobileVail constraintAnnotation) {

    }

    //检测方法
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value == null || value.length() == 0 ) {
            return false;
        }
        Matcher m = PHONE_PATTERN.matcher(value);
        return m.matches();
    }
}
