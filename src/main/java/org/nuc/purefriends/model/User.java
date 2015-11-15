package org.nuc.purefriends.model;

import java.sql.Timestamp;

/**
 * Created by zhangliang on 15/11/12.
 *
 */
public class User {

    private Long id;

    private String email;

    private String password;

    //0代表女性，1代表男性
    private int gender;

    //山西|太原|尖草坪
    private String area;

    //0表示未婚，1表示已婚
    private int marriage;

    //身高，单位厘米
    private int height;

    //教育水平
    private String education;

    //薪资水平，单位软妹币
    private int wage;

    private String phone;

    private String nickname;

    //个人简介
    private String info;

    //爱好
    private String hobby;

    private Timestamp createTime;

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setMarriage(int marriage) {
        this.marriage = marriage;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Timestamp getCreateTime() {

        return createTime;
    }

    public Long getId() {

        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getGender() {
        return gender;
    }

    public String getArea() {
        return area;
    }

    public int getMarriage() {
        return marriage;
    }

    public int getHeight() {
        return height;
    }

    public String getEducation() {
        return education;
    }

    public int getWage() {
        return wage;
    }

    public String getPhone() {
        return phone;
    }

    public String getNickname() {
        return nickname;
    }

    public String getInfo() {
        return info;
    }

    public String getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", area='" + area + '\'' +
                ", marriage=" + marriage +
                ", height=" + height +
                ", education='" + education + '\'' +
                ", wage=" + wage +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", info='" + info + '\'' +
                ", hobby='" + hobby + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
