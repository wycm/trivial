package com.wy.handler;

import com.wy.entity.Message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public class MessageHandler implements Runnable{
    private static final int BUFFER_SIZE = 4096;
    public static String responseMessage = "";
    private Socket socket;
    private Message message;
    public boolean isFinshReceive = false;
    public MessageHandler(Socket socket, String content){
        this.socket = socket;
        this.message = new Message(content);
        System.out.println(content);
    }
    public void sendMessage(){
        OutputStream os = null;
        try {
            os = socket.getOutputStream();
            os.write(message.getByte());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String receiveMessage(){
        InputStream is = null;
        try {
            is = socket.getInputStream();
            byte[] bytes = new byte[BUFFER_SIZE];
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            int count  = -1;
            int i = 0;
            while (socket.isConnected() && (count = is.read(bytes)) != -1){
                outStream.write(bytes, 0, count);
                String s = new String(Arrays.copyOf(bytes, count), "utf-8");
                responseMessage = responseMessage + s;
                System.out.println("响应消息:");
                System.out.println("length:" + s.length() + "---" + s);
                if(s.contains("setmsggroup")){
                    break;
                }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseMessage;
    }
    @Override
    public void run() {
        sendMessage();
    }
}
