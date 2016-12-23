package com.pwms.service;


import javax.servlet.http.HttpSession;

import com.pwms.pojo.User;
import com.pwms.pojo.Userinfo;
import com.pwms.pojo.UserinfoModify;

public interface IUserService {
    public User getUserById(int userId);
    //注册时，检查是否有这个
    public boolean chkinfo(String identity, String name, String studentid);
    //检查是否有这个用户以及密码是否正确
    public boolean chkpasswd(String loginfo, String password);
    public boolean login(HttpSession session, String loginfo, String password);
    public boolean register(User user, String identity);
    public void logout(HttpSession session);
    public void modifyUserinfo(Userinfo userinfo);
    /**
     * 审核用户修改信息
     * @param auditing 0:待审核，1：审核通过 2 审核不通过 
     * @return 
     */
    public boolean auditUserinfo(UserinfoModify userinfoModify, int auditing);
    
    public int getUseridByStuid(String stuid);
    
    public void updateById(User user);
//    public boolean importXlsToVerify(File file);
}
