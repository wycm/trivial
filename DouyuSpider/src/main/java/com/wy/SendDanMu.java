package com.wy;

import com.wy.entity.RequestBody;
import com.wy.entity.Room;
import com.wy.entity.ServerInfo;
import com.wy.handler.MessageHandler;
import com.wy.runnable.KeepLiveThread;
import com.wy.util.Md5Util;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class SendDanMu
{

    public static void main( String[] args ) throws IOException, InterruptedException {
        Room room = new Room("http://www.douyu.com/266055");
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        String devid = "0EDF87332639797CDBDA3232FF56B31E";
        String vk = Md5Util.Convert2Md5(timestamp + "7oE9nPEG9xXV69phU31FYCLUagKeYtsF" + uuid);
        String messageContent = RequestBody.sendDanMuLogin(room.getRoomId(), uuid, timestamp, vk) +
                "aver@=2016081801/ltkid@=27600677/biz@=1/stk@=3d1cb0aa4c0c1f9e/";
        ServerInfo danMuServer = room.getLoginServerList().get(2);
        Socket socket = new Socket(danMuServer.getHost(), danMuServer.getPort());
//        Socket socket = new Socket("119.90.49.101", 8002);
        MessageHandler smh = new MessageHandler(socket, messageContent);
        smh.sendMessage();
        String response = smh.receiveMessage();
//        new  MessageHandler(socket, "type@=qrl/rid@=" + room.getRoomId() + "/et@=0/").sendMessage();
//        new  MessageHandler(socket, "type@=qtlnq/").sendMessage();
//        new  MessageHandler(socket, "type@=qtlq/").sendMessage();
//        new  MessageHandler(socket, "type@=reqog/uid@=1116690/").sendMessage();
        //发送弹幕
        String sendMessage = String.format("type@=chatmessage/receiver@=0/content@=%s/sopen@=/col@=0/", "666666666666");
        MessageHandler sendMsgHandler = new MessageHandler(socket, sendMessage);
        sendMsgHandler.sendMessage();
        new Thread(new KeepLiveThread(socket)).start();
        response = sendMsgHandler.receiveMessage();
    }
}
