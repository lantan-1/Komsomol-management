package com.sjl.domain;

import java.sql.Date;

public class Activity {
    private Integer id;

    private Integer organization;
    private String type;
    private String date;
    private String host;
    private String place;
    private String content;

    public Activity() {
    }

    public Activity(Integer id, Integer organization, String type, String date, String host, String place, String content) {
        this.id = id;
        this.organization = organization;
        this.type = type;
        this.date = date;
        this.host = host;
        this.place = place;
        this.content = content;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return organization
     */
    public Integer getOrganization() {
        return organization;
    }

    /**
     * 设置
     * @param organization
     */
    public void setOrganization(Integer organization) {
        this.organization = organization;
    }

    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 获取
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * 设置
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 获取
     * @return place
     */
    public String getPlace() {
        return place;
    }

    /**
     * 设置
     * @param place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "Activity{id = " + id + ", organization = " + organization + ", type = " + type + ", date = " + date + ", host = " + host + ", place = " + place + ", content = " + content + "}";
    }
}
