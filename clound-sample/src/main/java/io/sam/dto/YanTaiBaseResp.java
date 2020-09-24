package io.sam.dto;

/**
 * @author zhuweimu
 * @classname YanTaiResponse
 * @description
 * @date 2020/9/10 10:41
 */
public class YanTaiBaseResp {

    /**
     * 返回值
     */
    private Integer rtn;

    /**
     * 描述信息
     */
    private String message;

    public Integer getRtn() {
        return rtn;
    }

    public void setRtn(Integer rtn) {
        this.rtn = rtn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
