package com.kexie.acloud.util;

import com.kexie.acloud.domain.User;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by zojian on 2017/6/5.
 */
public class SendPushMsgRunnable implements Runnable {
    //Jedis conn,String msgType, int id, String info,List<User> recipients
    private Jedis conn;

    private String msgType;

    private int id;

    private String info;

    private List<User> recipients;

    public SendPushMsgRunnable(Jedis conn, String msgType, int id, String info, List<User> recipients) {
        this.conn = conn;
        this.msgType = msgType;
        this.id = id;
        this.info = info;
        this.recipients = recipients;
    }

    @Override
    public void run() {
        RedisUtil.sendPushMsg(conn,msgType,id,info,recipients);
    }


    public Jedis getConn() {
        return conn;
    }

    public void setConn(Jedis conn) {
        this.conn = conn;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<User> recipients) {
        this.recipients = recipients;
    }
}
