package io.sam.db.domain;

import javax.persistence.*;
import lombok.Data;

/**
 * @description 
 * @date 2021/4/29 14:45
 * @author zhuweimu
 */
@Data
@Table(name = "oauth_access_token")
public class OauthAccessToken {
    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "token")
    private byte[] token;

    @Column(name = "authentication_id")
    private String authenticationId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "authentication")
    private byte[] authentication;

    @Column(name = "refresh_token")
    private String refreshToken;
}