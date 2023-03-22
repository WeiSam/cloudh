package io.sam.controller;

import common.BaseResponse;
import io.sam.annotation.MyRequestBody;
import io.sam.bean.UserBean;
import io.sam.dto.ro.UserInfoRo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuweimu
 * @classname TestController
 * @description
 * @date 2021/1/8 11:36
 */
@Slf4j
@RestController
@RequestMapping(value = "/test/")
public class TestController {

    @Value("${test.name}")
    private String name;

    private final Lock lock = new ReentrantLock();

    @GetMapping(value = "getName")
    public BaseResponse testName(){
        log.info("========================");
        return BaseResponse.success(name);
    }

    @GetMapping(value = "getUserInfo")
    public BaseResponse<UserBean> getUserInfo(UserBean userBean){
        return BaseResponse.success(new UserBean().setName("fdsd").setAge(12));
    }

    @PostMapping("postUserInfo")
    public BaseResponse<UserBean> postUserInfo(@RequestBody UserBean userBean, HttpServletRequest request){
        log.info("参数:{}",request.getParameter("param"));
        return BaseResponse.success(new UserBean().setName("fdsd").setAge(12));
    }

    @DeleteMapping(value = "udms/videoMerge/mergeFile")
    public String getMergeVideo(@RequestParam(value = "fileName",required = false) String fileName,
                                   @RequestBody(required = false) MultiValueMap<String,Object> map,
                                            HttpServletRequest httpServletRequest){
        if (StringUtils.isEmpty(fileName)) {
            if (map != null) {
                fileName = (String)map.getFirst("fileName");
            }else {
            }
        }
        return fileName;
    }

    @GetMapping(value = "udms/videoMerge/mergeFile")
    public String deleteMergeVideo(@RequestParam(value = "fileName",required = false) String fileName,
                                   @RequestBody(required = false) MultiValueMap<String,Object> map,
                                   HttpServletRequest httpServletRequest){
        return "delete";
    }

    @GetMapping(value = "udms/videoMerge/{fileName}")
    public String deleteFile(@PathVariable(value = "fileName") String fileName){
        return fileName;
    }

    @PostMapping(value = "getMyRequestBody/{fileName}")
    public BaseResponse<UserBean> getMyRequestBody(@MyRequestBody UserBean userBean,String fileName){
        userBean.setName(fileName);
        return BaseResponse.success(userBean);
    }

    @GetMapping("{fileName}")
    public BaseResponse<String> test(String fileName, HttpServletResponse response){
        //attachment 内容以文件下载,inline: 页面中展示
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=f.txt");
        return BaseResponse.success(fileName);
    }

    @GetMapping("lock/{seconds}")
    public BaseResponse<String> testLock(@PathVariable Integer seconds){
        String str = "获取锁失败";
        log.info("当前线程:{},锁对象:{}",Thread.currentThread().getName(),lock);
        if (lock.tryLock()) {
            try {
                Thread.sleep(1000*seconds);
                str = "获取锁成功";
            }catch (Exception e){
                log.error("异常",e);
            }finally {
                log.info("释放锁,当前线程:{},锁对象:{}",Thread.currentThread().getName(),lock);
                lock.unlock();
            }
        }

        return BaseResponse.success(str);
    }

    @GetMapping("testMaxThread/{seconds}")
    public BaseResponse<String> testMaxThread(@PathVariable Integer seconds){
        log.info("当前线程:{},锁对象:{}",Thread.currentThread().getName(),lock);
        try {
            Thread.sleep(1000*seconds);
        }catch (Exception e){
            log.error("异常",e);
        }
        return BaseResponse.success();
    }

}
