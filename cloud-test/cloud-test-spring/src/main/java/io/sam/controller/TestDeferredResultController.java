package io.sam.controller;

import common.BaseResponse;
import io.sam.bean.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuweimu
 * @description
 * @date 2022/7/26 8:57
 */
@Slf4j
@RestController
@RequestMapping(value = "/deffered/")
public class TestDeferredResultController {

    /**
     * 长轮询，请求未响应，长时间挂起，可设置超时时间
     */
    private static Map<String, List<DeferredResult<Object>>> MAP = new ConcurrentHashMap<>(16);
    @GetMapping("getUser/{id}")
    public DeferredResult<Object> getUser(@PathVariable String id){
        DeferredResult<Object> deferredResult = new DeferredResult<>(1000*10L);
        //请求完成时回调执行
        deferredResult.onCompletion(() -> {
            log.info("请求[{}]完成",id);
            MAP.remove(id);
        });
        List<DeferredResult<Object>> deferredResults = MAP.computeIfAbsent(id, s -> new ArrayList<>());
        deferredResults.add(deferredResult);
        return deferredResult;
    }

    @GetMapping("pushUser/{id}")
    public BaseResponse pushUser(@PathVariable String id){
        log.info("接收数据：{}",id);
        List<DeferredResult<Object>> deferredResults = MAP.get(id);
        if (CollectionUtils.isEmpty(deferredResults)) {
            return BaseResponse.success();
        }
        //设置请求响应结果
        for (DeferredResult<Object> deferredResult : deferredResults) {
            deferredResult.setResult(new UserBean()
                    .setName("Sam"+id));
        }
        return BaseResponse.success();
    }
}
