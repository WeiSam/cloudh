package io.sam;

import cn.hutool.core.bean.BeanUtil;

import java.util.Map;

/**
 * @author zhuweimu
 * @Classname BaseInfoRequest
 * @Description
 * @Date 2020/8/7 14:23
 */
public class BaseInfoRequest {

    private Map<String,Object> callerInfo;

    private Map<String,Object> requestInfo;



    public static class CallerInfo{
        private String ywxt_id;

        public String getYwxt_id() {
            return ywxt_id;
        }

        public void setYwxt_id(String ywxt_id) {
            this.ywxt_id = ywxt_id;
        }
    }

    public Map<String, Object> getCallerInfo() {
        return callerInfo;
    }

    public void setCallerInfo(Map<String, Object> callerInfo) {
        this.callerInfo = callerInfo;
    }

    public Map<String, Object> getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(Map<String, Object> requestInfo) {
        this.requestInfo = requestInfo;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Map<String,Object> callerInfo;
        private Map<String,Object> requestInfo;

        public Builder callerInfo(CallerInfo callerInfo) {
            this.callerInfo = BeanUtil.beanToMap(callerInfo);
            return this;
        }

        public Builder requestInfo(Object requestInfo) {
            this.requestInfo = BeanUtil.beanToMap(requestInfo);
            return this;
        }

        public BaseInfoRequest build() {
            BaseInfoRequest baseInfoRequest = new BaseInfoRequest();
            baseInfoRequest.setCallerInfo(callerInfo);
            baseInfoRequest.setRequestInfo(requestInfo);
            return baseInfoRequest;
        }
    }
}
