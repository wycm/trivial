package com.wy.entity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by yangwang on 16-8-19.
 * 消息实体
 * 由以下4部分组成
 * 1.len(4个字节)  后面3部分消息长度总和
 * 2.repeatLen(4个字节) 和len相等
 * 3.code 固定发送0xb1,0x02,0x00,0x00  接收为0xb2,0x02,0x00,0x00
 * 4.content消息内容
 */
public class Message {
    private int[] len;
    private int[] repeatLen;
    private int[] code;
    private String content;
    private int[] end;
    public Message(String content){
        this.content = content;
        code = new int[]{0xb1,0x02,0x00,0x00};
        int dataLen = content.getBytes().length + 4 + 4 + 1;
        len = new int[]{dataLen, 0, 0, 0};
        repeatLen = len;
        end = new int[]{0};
    }
    public byte[] getByte() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        for(int t : len){
            dos.write(t);
        }
        for(int t : repeatLen){
            dos.write(t);
        }
        for(int t : code){
            dos.write(t);
        }
        dos.write(content.getBytes());
        for(int t : end){
            dos.write(t);
        }
        byte[] bytes = bos.toByteArray();
        System.out.println("请求消息:" + new String(bytes, "utf-8"));
        return bytes;
    }
}
