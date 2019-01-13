package com.segmentfault.springbootlessonxiiii.websocket;


import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: spring-boot-lesson
 * @description: 聊天室
 * @author: qiankeqin
 * @create: 2019-01-12 22:01
 **/
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {

    private static Map<String,Session> sessionMap = new ConcurrentHashMap<>();

    /**
     * 打开Session时
     * @param username
     * @param session
     */
    @OnOpen
    public void openSession(@PathParam("username") String username, Session session){
        //存储链接进来的用户
        String sessionId = session.getId();
        sessionMap.put(sessionId,session);

//        sendText("欢迎用户【"+username+"】登陆聊天室！",session);
        sendAllText("欢迎用户【"+username+"】登陆聊天室！");
    }

    /**
     * 用户发送消息
     * @param username
     * @param session
     * @param message
     */
    @OnMessage
    public void onMessage(@PathParam("username") String username, Session session, String message){
//        sendText("用户【"+username+"】:"+message,session);
        sendAllText("用户【"+username+"】:"+message);
    }

    /**
     * 关闭session时
     * @param username
     * @param session
     */
    @OnClose
    public void closeSession(@PathParam("username") String username,Session session){
        sessionMap.remove(session.getId());
        //sendText("用户【"+username+"】退出聊天室，欢迎再来！",session);
        //通知其他人session移除
        sendAllText("用户【"+username+"】退出聊天室！");
    }

    private void sendAllText(String message){
        sessionMap.forEach((sessionId,session)->{
            sendText(message,session);
        });
    }

    private void sendText(String message, Session session){
        RemoteEndpoint.Basic basicRemote = session.getBasicRemote();
        try {
            basicRemote.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
