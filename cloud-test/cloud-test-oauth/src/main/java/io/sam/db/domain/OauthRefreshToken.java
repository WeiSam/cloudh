package io.sam.db.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @description 
 * @date 2021/4/29 14:45
 * @author zhuweimu
 */
@Data
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken {
    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "token")
    private byte[] token;

    @Column(name = "authentication")
    private byte[] authentication;
}