package org.nuc.purefriends.model;

import java.sql.Timestamp;

/**
 * Created by zhangliang on 15/11/13.
 */
public class TempUser {

    private Long id;

    private String email;

    private String password;

    private String key;

    private Timestamp createTime;

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TempUser{" +
                "createTime=" + createTime +
                ", key='" + key + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

    public Timestamp getCreateTime() {

        return createTime;
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

    public void setKey(String key) {
        this.key = key;
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

    public String getKey() {
        return key;
    }
}
