package com.ProjectPracitce.java;

public class User {

    private int id;
    private String findId;
    private String username;
    private String password;
    private String telephone;

    /**
     * id赋值
     * @param id 将其赋予id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * findid赋值
     * @param findId 将其赋予findid
     */
    public void setFindId(String findId) {
        this.findId = findId;
    }

    /**
     * 用户名赋值
     * @param username 将其赋予用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码赋值
     * @param password 将其赋予密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 联系方式赋值
     * @param telephone 将其赋予联系方式
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 返回id
     * @return int
     */
    public int returnId() {
        return id;
    }

    /**
     * 返回findid
     * @return String
     */
    public String returnFindId() {
        return findId;
    }

    /**
     * 返回用户名
     * @return String
     */
    public String returnUsername() {
        return username;
    }

    /**
     * 返回密码
     * @return String
     */
    public String returnPassword() {
        return password;
    }

    /**
     * 返回联系方式
     * @return String
     */
    public String returnTelephone() {
        return telephone;
    }

    /**
     * 输出用户
     */
    public void print() {
        System.out.println(id + "\t" + username + "\t" + telephone);
    }
}
