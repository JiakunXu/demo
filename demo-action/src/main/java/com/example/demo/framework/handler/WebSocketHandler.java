package com.example.demo.framework.handler;

import com.example.demo.socket.service.impl.WebSocketManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.UUID;

/**
 * @author JiakunXu
 */
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Map<String, Object> attributes = session.getAttributes();

        Object token = attributes.get("token");
        Object appId = attributes.get("appId");

        if (token == null || appId == null) {
            session.close(CloseStatus.BAD_DATA);
            return;
        }

        String tunnelId = UUID.randomUUID().toString();

        session.getAttributes().put("tunnelId", tunnelId);

        WebSocketManager.put(tunnelId, session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session,
                                     TextMessage message) throws Exception {
        if ("ping".equals(message.getPayload())) {
            session.sendMessage(new TextMessage("pong"));
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session,
                                     Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus status) throws Exception {
        if (!CloseStatus.BAD_DATA.equals(status)) {
            String tunnelId = (String) session.getAttributes().get("tunnelId");

            WebSocketManager.remove(tunnelId);
        }
    }

}
