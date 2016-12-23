package com.wy.entity;

/**
 * Created by Administrator on 2016/8/20 0020.
 * 请求正文
 * 要注意的是斗鱼有3类服务器
 * 1.WEB服务器
 * 2.登录服务器
 * 3.弹幕服务器
 * 首先在web页面可以获取登录服务器的信息，然后向登录服务器发送指定消息，可以获取弹幕服务器信息，
 * 然后再请求弹幕服务器，基本上都可以获取到弹幕信息了
 */
public class RequestBody {
    /**
     * 登录请求正文，发送给登录服务器，
     * @param roomId 房间id
     * @param devid 随机uuid
     * @param rt 时间戳
     * @param vk 一串md5数据
     * @return 返回的消息里面分别包含了username和弹幕服务器地址和端口以及gid和roomId
     */
    public static String firstRequest(int roomId, String devid, String rt, String vk) {
        return String.format("type@=loginreq/username@=/ct@=0/password@=/roomid@=%d/devid@=%s/rt@=%s/vk@=%s/ver@=20150929/", roomId, devid, rt, vk);
    }
    public static String sendDanMuLogin(int roomId, String devid, String rt, String vk){
        return String.format("type@=loginreq/username@=qq_PgelrqUD/ct@=0/password@=/roomid@=%d/devid@=%s/rt@=%s/vk@=%s/ver@=20150929/", roomId, devid, rt, vk);
    }
    public static String sendDanMu(String content){
        return String.format("type@=chatmessage/receiver@=0/content@=%s/scopen@=/col@=0",content);
    }
}
