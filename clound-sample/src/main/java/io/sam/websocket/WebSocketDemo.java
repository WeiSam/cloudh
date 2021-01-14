package io.sam.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/websocket/{sid}")
@Component
public class WebSocketDemo {

    private static Logger logger = LoggerFactory.getLogger(WebSocketDemo.class);

    // 静态变量，用来记录当前在线连接数
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    private static Map<String, CopyOnWriteArraySet<WebSocketDemo>> sessionMap = new ConcurrentHashMap<>();
    private static Map<String, String> sessionIdMap = new ConcurrentHashMap<String, String>();

    private Session session;

    // 接收sid
    private String sid;

    @OnOpen
    public void onOpen(Session session, @PathParam(value = "sid") String sid) {
        this.session = session;
        this.sid = sid;
        CopyOnWriteArraySet<WebSocketDemo> WebSocketDemoSet = sessionMap.get(sid);
        if (WebSocketDemoSet == null) {
            WebSocketDemoSet = new CopyOnWriteArraySet<>();
        }
        WebSocketDemoSet.add(this);
        sessionMap.put(sid, WebSocketDemoSet);
        sessionIdMap.put(session.getId(), sid);
        addOnlineCount();
        logger.info("{} 已经连接成功，当前连接数：{}", sid, getOnlineCount());
    }

    @OnClose
    public void onClose() {
        sessionMap.remove(sessionIdMap.get(session.getId()));
        sessionIdMap.remove(session.getId());
        subOnlineCount();
        logger.info("{} 已关闭，当前连接数：{}", sid, getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("收到来自 {} 的消息：{}", sid, message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("连接 {} 发生异常", sid, error);
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public void sendMessage(Object data) throws IOException, EncodeException {
        this.session.getBasicRemote().sendObject(data);
    }

    public static void sendALL(String message) {
        for (CopyOnWriteArraySet<WebSocketDemo> set : sessionMap.values()) {
            for (WebSocketDemo item : set) {
                try {
                    item.sendMessage(message);
                } catch (IOException e) {
                    logger.error("发送消息到 {} 异常", item.sid, e);
                    continue;
                }
            }
        }
    }

    public static void sendALL(Object data) {
        for (CopyOnWriteArraySet<WebSocketDemo> set : sessionMap.values()) {
            for (WebSocketDemo item : set) {
                try {
                    item.sendMessage(data);
                } catch (IOException | EncodeException e) {
                    logger.error("发送消息到 {} 异常", item.sid, e);
                    continue;
                }
            }
        }
    }

    public static void send(String sid, String message) throws IOException {
        CopyOnWriteArraySet<WebSocketDemo> set = sessionMap.get(sid);
        if (!CollectionUtils.isEmpty(set)) {
            for (WebSocketDemo item: set) {
                item.sendMessage(message);
            }
        }
    }

    public static void send(String sid, Object data) throws IOException, EncodeException {
        CopyOnWriteArraySet<WebSocketDemo> set = sessionMap.get(sid);
        if (!CollectionUtils.isEmpty(set)) {
            for (WebSocketDemo item: set) {
                item.sendMessage(data);
            }
        }
    }

    public static int getOnlineCount() {
        return onlineCount.get();
    }

    public static void addOnlineCount() {
        onlineCount.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineCount.decrementAndGet();
    }

}
