package com.wy.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/8/19 0019.
 * 斗鱼房间
 */
public class Room {
    private int roomId;//房间id
    private String title;//房间标题
    private List<ServerInfo> loginServerList;
    private Page page;
    private boolean isLive;
    private int number;//房间人数
    {
        loginServerList = new ArrayList<ServerInfo>();
    }
    public Room(String url){
        this.page = MyHttpClient.getInstance().getWebPage(url);
        parseDanMuServer();
        parseRoomId();
    }

    /**
     * 解析弹幕服务器
     * @throws Exception
     */
    private void parseDanMuServer(){
        Pattern pattern = Pattern.compile("ROOM\\.args.*;");
        Matcher m = pattern.matcher(page.getHtml());
        m.find();
        String json = m.group(0);
        json = json.substring(json.indexOf("{"),json.lastIndexOf("}") + 1);
        JSONObject jsonObject = new JSONObject(json);
        String severConfigArray = jsonObject.get("server_config").toString();
        try {
            severConfigArray = URLDecoder.decode(severConfigArray, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray(severConfigArray);
        for(int i = 0; i < jsonArray.length(); i++){
            ServerInfo dms = new ServerInfo();
            JSONObject hostAndPort = new JSONObject(jsonArray.get(i).toString());
            dms.setHost(hostAndPort.getString("ip").toString());
            dms.setPort(Integer.valueOf(hostAndPort.get("port").toString()));
            System.out.println(dms.getHost() + "----" + dms.getPort());
            loginServerList.add(dms);
        }
    }
    private void parseRoomId(){
        String s = page.getHtml();
        Pattern pattern = Pattern.compile("room_id=[0-9]*");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        String roomId = matcher.group();
        roomId = roomId.substring(8);
        this.roomId = Integer.valueOf(roomId);
        System.out.println(roomId);
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<ServerInfo> getLoginServerList() {
        return loginServerList;
    }

    public void setLoginServerList(List<ServerInfo> loginServerList) {
        this.loginServerList = loginServerList;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
