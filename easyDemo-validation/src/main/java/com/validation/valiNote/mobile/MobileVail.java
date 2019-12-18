package com.validation.valiNote.mobile;

/**
 * @ClassName:MobileVail
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2019-12-18 17:20
 * @version: 1.0.0
 **/

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
// 指定真正实现校验规则的类
@Constraint(validatedBy = MobileValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MobileVail {
    String message() default "不是正确的手机号码";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ElementType.METHOD,ElementType.FIELD,ElementType.PACKAGE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        MobileVail[] value();
    }
}
