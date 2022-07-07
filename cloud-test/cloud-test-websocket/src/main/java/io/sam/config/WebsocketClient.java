package io.sam.config;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
@Component
public class WebsocketClient {
    
    private static String WS = "ws://192.168.78.146:19800/nonsense/position/change";
    boolean isConnect = false;
    boolean isMessage = false;

    @Bean
    public WebSocketClient getWebSocketClient() {
        try {
            WebSocketClient webSocketClient = new WebSocketClient(new URI(WS),
                    new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    log.info("[websocket] 连接成功--------------------------------------");
                    isConnect = true;
                }

                @Override
                public void onMessage(String message) {
                    //如果是文本类型的消息处理逻辑
                    log.info("[websocket] 收到消息={}", message);
                }

                @Override
                public void onMessage(ByteBuffer buffer) {
                    //该站为byte流需要转换成文本，这里可加入消息处理逻辑
                    String message = ByteUtils.getString(buffer);
                    log.info("[websocket] 收到消息={}", message);
                }


                @Override
                public void onClose(int code, String reason, boolean remote) {
                    log.info("[websocket] 退出连接");
                    isConnect = false;
                    isMessage = false;
                }

                @Override
                public void onError(Exception ex) {
                    log.info("[websocket] 连接错误={}", ex.getMessage(),ex);
                    isConnect = false;
                    isMessage = false;
                }
            };

            //如果断线，则重连并重新发送验证信息
            Timer t = new Timer();
/*            t.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (!isConnect && !isMessage) {
                        isMessage = true;
                        log.info("------websocket连接执行了");
                        WebSocketClient client = getWebSocketClient();
                        client.connect();
                        while (client.getReadyState().toString().equals("NOT_YET_CONNECTED")) {
                            try {
                                //2秒循环一次
                                Thread.sleep(2 * 1000);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            log.info("连接中···请稍后");
                        }
                        //发送内容可根据具体业务处理，此处为byte流
                        ByteBuffer byteBuffer = ByteBuffer.allocate(0);
                        client.send(byteBuffer);
                        log.info("[websocket] 再次发送请求");
                    }
                }
            }, 3000, 60000);*/
            webSocketClient.connect();
            return webSocketClient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
