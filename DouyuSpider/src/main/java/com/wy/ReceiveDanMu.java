package com.wy;

import com.wy.entity.*;
import com.wy.handler.MessageHandler;
import com.wy.runnable.KeepLiveThread;
import com.wy.util.Md5Util;

import java.io.*;
import java.net.Socket;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class ReceiveDanMu
{

    public static void main( String[] args ) throws IOException, InterruptedException {
        Room room = new Room("http://www.douyu.com/266055");
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        String vk = Md5Util.Convert2Md5(timestamp + "7oE9nPEG9xXV69phU31FYCLUagKeYtsF" + uuid);
        String messageContent = RequestBody.firstRequest(room.getRoomId(), uuid, timestamp, vk);
        ServerInfo danMuServer = room.getLoginServerList().get(0);
        Socket socket = new Socket(danMuServer.getHost(), danMuServer.getPort());
        MessageHandler smh = new MessageHandler(socket, messageContent);
        smh.sendMessage();
        String response = smh.receiveMessage();
        System.out.println("获取弹幕服务器:" + socket.getInetAddress() + ":" + socket.getPort() + "---" + response);
        socket.close();

        String loginDanMuServer = String.format("type@=loginreq/username@=visitor34807350/password@=1234567890123456/roomid@=%d/", room.getRoomId());
        socket = new Socket("danmu.douyu.com", 12601);
        smh = new MessageHandler(socket, loginDanMuServer);
        smh.sendMessage();
        System.out.println("登录弹幕服务器....");

        String setmsggroup = smh.responseMessage;
        Pattern pattern = Pattern.compile("gid@=[1-9]*");
        Matcher matcher = pattern.matcher(setmsggroup);
        matcher.find();
        String groupId = matcher.group();
        groupId = groupId.replaceAll("gid@=", "");
        System.out.println(groupId);
        String groupContent = String.format("type@=joingroup/rid@=%d/gid@=%s/",room.getRoomId(),groupId);
        smh = new MessageHandler(socket, groupContent);
        smh.sendMessage();
        new Thread(new KeepLiveThread(socket)).start();
        response = smh.receiveMessage();
        System.out.println("加入弹幕服务器group中..");
    }
}
