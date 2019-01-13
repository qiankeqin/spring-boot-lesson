package com.segmentfault.springbootlessonxiiii;

import com.segmentfault.springbootlessonxiiii.websocket.ChatRoomServerEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@EnableWebSocket
public class SpringBootLessonxiiiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLessonxiiiiApplication.class, args);
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter(){
		return new ServerEndpointExporter();
	}

	@Bean
    public ChatRoomServerEndpoint chatRoomServerEndpoint(){
	    return new ChatRoomServerEndpoint();
    }

}

