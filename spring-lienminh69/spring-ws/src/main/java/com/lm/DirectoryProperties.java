package com.lm;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by: ntthuat
 * $Date: 2018/04/03$
 * $Log: DirectoryProperties.java,v $
 */
@Component
@ConfigurationProperties("dir") // prefix dir, find dir.* property values
public class DirectoryProperties {
    private String root;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }
}
