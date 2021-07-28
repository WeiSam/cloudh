package io.sam.exception;

import java.io.Serializable;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/28 9:28
 */
public class ServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 2347758351045892088L;

    public ServiceException() {
        super();
    }

    public ServiceException(String s) {
        super(s);
    }

    public ServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
