package com.hzihui.cloud.provider.config;

import lombok.Getter;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author HZI.HUI
 * @date 2019/9/11 11:19
 */
@Component
public class IpConfiguration implements ApplicationListener<WebServerInitializedEvent> {

    @Getter
    private int post;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        this.post = webServerInitializedEvent.getWebServer().getPort();
    }
}
