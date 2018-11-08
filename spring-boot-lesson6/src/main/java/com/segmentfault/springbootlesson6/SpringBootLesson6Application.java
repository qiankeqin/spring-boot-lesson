package com.segmentfault.springbootlesson6;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11Nio2Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootLesson6Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLesson6Application.class, args);
	}


	@Bean
	public static EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				if(container instanceof TomcatEmbeddedServletContainerFactory){
					TomcatEmbeddedServletContainerFactory factory = TomcatEmbeddedServletContainerFactory.class.cast(container);
					factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
						@Override
						public void customize(Connector connector) {
							connector.setPort(8888);
							connector.setProtocol(Http11Nio2Protocol.class.getName());
						}
					});

					factory.addContextCustomizers(new TomcatContextCustomizer() {
						@Override
						public void customize(Context context) {
							context.setPath("/spring-test");
						}
					});
				}
			}
		};
	}
}
