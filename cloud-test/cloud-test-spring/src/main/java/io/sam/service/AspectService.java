package io.sam.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/7 15:48
 */
@Slf4j
@Service
public class AspectService {

    public String logInfo(String name){
        log.info("AspectService.logInfo:{}",name);
        return "OK";
    }

    public String before(String name){
        log.info("AspectService.before:{}",name);
        return "OK";
    }

    public String after(boolean isExection,String name) throws Exception {
        log.info("AspectService.after:{}",name);
        if (isExection) {
            throw new Exception("抛出异常");
        }
        return "OK";
    }

    public String afterReturn(boolean isExection,String name) throws Exception {
        log.info("AspectService.afterReturn:{}",name);
        if (isExection) {
            throw new Exception("抛出异常");
        }
        return "OK";
    }

    public String afterThrowing(boolean isExection,String name) throws Exception {
        log.info("AspectService.afterThrowing:{}",name);
        if (isExection) {
            throw new Exception("抛出异常");
        }
        return "OK";
    }
}
