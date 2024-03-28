package com.sjl.domain;

public class User {
    private Integer id;
    private Integer organization;
    private String name;
    private String card;
    private String ethnic;
    private String phone;
    private String pwd;

    public User() {
    }

    public User(Integer id, Integer organization, String name, String card, String ethnic, String phone, String pwd) {
        this.id = id;
        this.organization = organization;
        this.name = name;
        this.card = card;
        this.ethnic = ethnic;
        this.phone = phone;
        this.pwd = pwd;
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
     * @return card
     */
    public String getCard() {
        return card;
    }

    /**
     * 设置
     * @param card
     */
    public void setCard(String card) {
        this.card = card;
    }

    /**
     * 获取
     * @return ethnic
     */
    public String getEthnic() {
        return ethnic;
    }

    /**
     * 设置
     * @param ethnic
     */
    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String toString() {
        return "User{id = " + id + ", organization = " + organization + ", name = " + name + ", card = " + card + ", ethnic = " + ethnic + ", phone = " + phone + ", pwd = " + pwd + "}";
    }
}
