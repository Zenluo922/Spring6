package com.powernode.spring6.beans;

import java.util.Properties;

public class Properties_jdbc {
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Properties_jdbc{" +
                "properties=" + properties +
                '}';
    }
}
