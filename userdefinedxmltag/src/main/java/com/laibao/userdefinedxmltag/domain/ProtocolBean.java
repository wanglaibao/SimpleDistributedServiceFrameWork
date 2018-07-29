package com.laibao.userdefinedxmltag.domain;

/**
 * @author laibao wang
 * @date 2018-07-28
 * @version 1.0
 */
public class ProtocolBean {
    private String id;
    private String name;
    private String port;
    private String host;

    public ProtocolBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
