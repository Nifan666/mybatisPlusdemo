package com.example.mybatisplusdemo.common.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "local")
//@Data
public class LocalConfig {
    private String ipAddr;
    private String hostName;
}
