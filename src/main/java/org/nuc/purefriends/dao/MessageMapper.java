package org.nuc.purefriends.dao;

import org.nuc.purefriends.model.Message;

import java.util.List;

/**
 * Created by zhangliang on 15/11/12.
 */
public interface MessageMapper {

    public Message loadByMsgId(Long msgId);

    public List<Message> getAllSendMsg(Long userId);

    public List<Message> getAllReceiveMsg(Long userId);

    public List<Message> getAllUnReadMsg(Long userId);

    public List<Message> getAllReadedMsg(Long userId);

    public void changeMsgStatus(Long msgId);

    public void updateMsg(Message message);

    public void deleteMsg(Long msgId);

    public Long addMsg(Message message);

    public Long getUnReadMsgCount(Long userId);

    public Long getAllReceiveMsgCount(Long userId);

    public Long getAllReadedMsgCount(Long userId);
}
