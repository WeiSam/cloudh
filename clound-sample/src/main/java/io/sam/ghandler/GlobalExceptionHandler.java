package io.sam.ghandler;

import common.BaseResponse;
import io.sam.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhuweimu
 * @description 全局异常处理
 * @date 2021/7/28 9:20
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<String> exception(Exception e){
        log.error("发生异常:{}",e.getMessage(),e);
        return BaseResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),"");
    }


    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = ServiceException.class)
    public BaseResponse<String> serviceException(ServiceException e){
        log.error("发生异常:{}",e.getMessage(),e);
        return BaseResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),"");
    }
}
