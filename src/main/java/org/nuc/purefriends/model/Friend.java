package org.nuc.purefriends.model;

/**
 * Created by zhangliang on 15/11/13.
 */
public class Friend {

    private Long id;

    private Long user1Id;

    private Long user2Id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser1Id(Long user1Id) {
        this.user1Id = user1Id;
    }

    public void setUser2Id(Long user2Id) {
        this.user2Id = user2Id;
    }

    public Long getId() {

        return id;
    }

    public Long getUser1Id() {
        return user1Id;
    }

    public Long getUser2Id() {
        return user2Id;
    }
}
