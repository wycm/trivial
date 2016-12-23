package com.wy.runnable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public class ReceiveMsg implements Runnable{
    private static final int BUFFER_SIZE = 4096;
    private InputStream socketInputStream;
    private Socket socket;
    public ReceiveMsg(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        InputStream is = null;
//        try {
//            is = socket.getInputStream();
//            byte[] bytes = new byte[BUFFER_SIZE];
//            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//            int count  = -1;
//            while (socket.isConnected() && (count = is.read(bytes)) != -1){
//                System.out.println(count);
//                outStream.write(bytes, 0, count);
//                String s = new String(bytes, "utf-8");
//                System.out.println("length:" + s.length() + "---" + s);
//            }
//            System.out.println(new String(outStream.toByteArray(),"utf-8"));
//            while (socket.isConnected() && is.read(bytes) != -1) {
//                System.out.println(is.available());
//                System.out.println(new String(bytes, "utf-8"));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        }
    }
}
