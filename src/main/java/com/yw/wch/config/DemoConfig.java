package com.yw.wch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wujiawu on 2017/5/5.
 */
@Component
@ConfigurationProperties(prefix="demo")
public class DemoConfig {
    private List<String> servers = new ArrayList<String>();

    public List<String> getServers() {
        return this.servers;
    }
}
