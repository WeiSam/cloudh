package io.sam.dto;

/**
 * @author zhuweimu
 * @classname YanTaiLoginResp
 * @description
 * @date 2020/9/10 16:54
 */
public class YanTaiLoginResp extends YanTaiBaseResp{

    /**
     * 登陆session信息
     */
    private String session_id;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }
}
