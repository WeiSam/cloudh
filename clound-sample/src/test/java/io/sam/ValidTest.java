package io.sam;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author zhuweimu
 * @classname ValidTest
 * @description
 * @date 2020/12/1 16:25
 */
public class ValidTest {

    public @NotNull String getStr(String str) throws NoSuchMethodException {
        System.out.println("执行");
        String result = str;
        Method currMethod = this.getClass().getMethod("getStr",String.class);
        Set<ConstraintViolation<ValidTest>> validResult = obtainExecutableValidator().validateReturnValue(this,currMethod, result);
        if (!validResult.isEmpty()) {
            // ... 输出错误详情validResult
            validResult.stream().map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue()).forEach(System.out::println);
            throw new IllegalArgumentException("参数错误");
        }
        return str;
    }

    @Test
    public void testNotNull() throws Exception {
        String str = null;
        @NotNull String str1 = getStr(str);
        @NotNull String str2 = getStr(str);
        if (str2 == null) {
            System.out.println();
        }
        System.out.println(str1);

    }

    /**
     * @see Validator
     * @return
     */
    private Validator obtainValidator() {
        // 1、使用【默认配置】得到一个校验工厂  这个配置可以来自于provider、SPI提供
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        // 2、得到一个校验器
        return validatorFactory.getValidator();
    }

    // 用于方法校验的校验器
    private ExecutableValidator obtainExecutableValidator() {
        return obtainValidator().forExecutables();
    }
}
