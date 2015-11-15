package org.nuc.purefriends.model;

import java.sql.Timestamp;

/**
 * Created by zhangliang on 15/11/12.
 */
public class Notification {

    private Long id;

    private Long toId;

    private Long fromId;

    private Integer type;

    private String title;

    private String content;

    private Timestamp createTime;

    private Integer isRead;

    public Notification() {
        this.isRead = 0;
    }

    public void generateAddRequestNotification(User fromUser, User toUser) {
        this.setType(1);
        this.setToId(toUser.getId());
        this.setFromId(fromUser.getId());
        this.setTitle( "系统：添加好友请求");
        this.setContent( fromUser.getNickname() + "[" + fromUser.getEmail() + "]" + " 请求添加您为好友!");
    }

    public void generateRefuseRequestNotification(User fromUser, User toUser) {
        this.setType(2);
        this.setToId(toUser.getId());
        this.setFromId(fromUser.getId());
        this.setTitle( "系统：好友添加失败");
        this.setContent( fromUser.getNickname() + "[" + fromUser.getEmail() + "]" + " 拒绝了您的好友添加请求!");
    }

    public void generateAddSuccessNotification(User fromUser, User toUser) {
        this.setType(3);
        this.setToId( toUser.getId());
        this.setFromId( fromUser.getId());
        this.setTitle( "系统：添加好友成功");
        this.setContent( fromUser.getNickname() + "[" + fromUser.getEmail() + "]" + " 接收了您的好友添加请求，你们已经是好友了!");
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getCreateTime() {

        return createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Long getId() {

        return id;
    }

    public Long getToId() {
        return toId;
    }

    public Long getFromId() {
        return fromId;
    }

    public Integer getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getIsRead() {
        return isRead;
    }
}
