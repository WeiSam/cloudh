package io.sam.dto;

/**
 * @author zhuweimu
 * @classname YanTaiLoginReq
 * @description
 * @date 2020/9/11 14:10
 */
public class YanTaiLoginReq {
    /**
     * 接口调用账号-三方提供
     */
    private String name;
    /**
     * 接口调用密码-三方提供
     */
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
