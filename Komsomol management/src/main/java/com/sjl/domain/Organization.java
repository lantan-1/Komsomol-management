package com.sjl.domain;

public class Organization {
    private Integer id;
    private String name;
    private User user;


    public Organization() {
    }

    public Organization(Integer id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return "Organization{id = " + id + ", name = " + name + ", user = " + user + "}";
    }
}
