package io.sam.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

  @Value("${http.port}")
  private Integer port;

  @Bean
  public ServletWebServerFactory servletContainer() {
    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//    tomcat.addConnectorCustomizers(new GwsTomcatConnectionCustomizer()); // 配置http
    tomcat.addAdditionalTomcatConnectors(createStandardConnector());
    return tomcat;
  }

  private Connector createStandardConnector() {
    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
    connector.setPort(port);
    return connector;
  }

  public class GwsTomcatConnectionCustomizer implements TomcatConnectorCustomizer {

    public GwsTomcatConnectionCustomizer() {
    }

    @Override
    public void customize(Connector connector) {
      connector.setPort(port);
    }
  }

}