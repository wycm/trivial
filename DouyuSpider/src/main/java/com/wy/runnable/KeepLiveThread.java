package com.wy.runnable;

import com.wy.handler.MessageHandler;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Brucezz on 2016/01/04.
 * DouyuCrawler
 */
public class KeepLiveThread implements Runnable {
    private Socket s;

    public KeepLiveThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (s != null && s.isConnected()) {
            try {
                Thread.sleep(20000);
                String tick = String.valueOf(System.currentTimeMillis() / 1000);
                String msgContent = String.format("type@=keeplive/tick@=%s/", tick);
                new MessageHandler(s, msgContent).sendMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}