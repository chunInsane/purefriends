package org.nuc.purefriends.model;

import java.sql.Timestamp;

/**
 * Created by zhangliang on 15/11/12.
 */
public class Message {

    private Long id;

    private Long fromUserId;

    private String fromUserName;

    private Long toUserId;

    private String toUserName;

    private String title;

    private String content;

    private int isRead;

    private Timestamp createTime;

    public Message() {
        this.isRead = 0;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Long getId() {

        return id;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getIsRead() {
        return isRead;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", fromUserId=" + fromUserId +
                ", fromUserName='" + fromUserName + '\'' +
                ", toUserId=" + toUserId +
                ", toUserName='" + toUserName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isRead=" + isRead +
                ", createTime=" + createTime +
                '}';
    }
}
