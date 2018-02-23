package com.somecompany.trading;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		System.out.println("in register");
		registry.addHandler(new TradeEventsHandler(), "/trade");
	}

	class TradeEventsHandler extends TextWebSocketHandler {

		private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

		@Override
		public void afterConnectionEstablished(WebSocketSession session) throws Exception {
			System.out.println("after connection established");
			sessions.add(session);
		}

		protected void handleTextMessage(WebSocketSession session, TextMessage message) {
			for (WebSocketSession s : sessions) {
				CharSequence payload = "trade done";
				try {
					s.sendMessage(new TextMessage(payload));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
