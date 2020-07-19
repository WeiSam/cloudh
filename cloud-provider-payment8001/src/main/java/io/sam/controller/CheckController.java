package io.sam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zhuweimu
 * @Date: 2020/3/28 12:05
 * @Description:
 */
@RestController
public class CheckController {

    @GetMapping("check")
    public String check(){

//        ServerSocketChannel serverSocketChannel = new ServerSocketChannelImpl();
//        SocketChannel socketChannel = serverSocketChannel.accept();
//        socketChannel.configureBlocking(false);
        return "success";
    }
}
