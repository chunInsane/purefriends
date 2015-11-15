package org.nuc.purefriends.service;

import org.nuc.purefriends.dao.MessageMapper;
import org.nuc.purefriends.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangliang on 15/11/12.
 */

@Service
public class MessageService implements IMessageService {

    private MessageMapper messageMapper;

    @Autowired
    public void setMessageMapper(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public MessageMapper getMessageMapper() {

        return messageMapper;
    }

    @Override
    public Message loadByMsgId(Long msgId) {
        return messageMapper.loadByMsgId(msgId);
    }

    @Override
    public Message addMsg(Message message) {
        messageMapper.addMsg(message);
        return message;
    }

    @Override
    public void changeMsgStatus(Long msgId) {
        messageMapper.changeMsgStatus( msgId);
    }

    @Override
    public void updateMsg(Message message) {
        messageMapper.updateMsg( message);
    }

    @Override
    public void deleteMsg(Long msgId) {
        messageMapper.deleteMsg( msgId);
    }

    @Override
    public List<Message> getAllSendMsg(Long userId) {
        return messageMapper.getAllSendMsg(userId);
    }

    @Override
    public List<Message> getAllReceiveMsg(Long userId) {
        return messageMapper.getAllReceiveMsg( userId);
    }

    @Override
    public List<Message> getAllUnReadMsg(Long userId) {
        return messageMapper.getAllUnReadMsg(userId);
    }

    @Override
    public List<Message> getAllReadedMsg(Long userId) {
        return messageMapper.getAllReadedMsg( userId);
    }

    @Override
    public Long getUnReadMsgCount(Long userId) {
        return messageMapper.getUnReadMsgCount(userId);
    }

    @Override
    public Long getAllReceiveMsgCount(Long userId) {
        return messageMapper.getAllReceiveMsgCount( userId);
    }

    @Override
    public Long getAllReadedMsgCount(Long userId) {
        return messageMapper.getAllReadedMsgCount( userId);
    }
}
