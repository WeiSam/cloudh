package io.sam.db.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @description 
 * @date 2021/4/29 14:45
 * @author zhuweimu
 */
@Data
@Table(name = "oauth_code")
public class OauthCode {
    @Column(name = "code")
    private String code;

    @Column(name = "authentication")
    private byte[] authentication;
}