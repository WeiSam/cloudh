package io.sam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author zhuweimu
 * @classname TestController
 * @description
 * @date 2020/9/9 16:45
 */
@RestController
@RequestMapping
public class TestController {

    @RequestMapping({"/oauth2/authorize"})
    public void login(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String redirect_uri = request.getParameter("redirect_uri");
        redirect_uri = URLDecoder.decode(redirect_uri);
        response.sendRedirect(redirect_uri + "?" + "id_token=672367263");
    }
}
