package com.laibao.userdefinedxmltag.domain;

/**
 * @author laibao wang
 * @date 2018-07-27
 * @version 1.0
 */
public class DataSource {
    private String id;
    private String url;
    private String userName;
    private String passWord;

    public DataSource() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
