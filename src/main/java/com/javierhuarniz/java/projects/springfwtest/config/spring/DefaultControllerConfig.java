package com.javierhuarniz.java.projects.springfwtest.config.spring;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Created by javier on 21/01/2017.
 */
@Configuration
public class DefaultControllerConfig {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new ErrorPagesCustomizer();
    }

    private static class ErrorPagesCustomizer implements EmbeddedServletContainerCustomizer {
        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
        }
    }
}
