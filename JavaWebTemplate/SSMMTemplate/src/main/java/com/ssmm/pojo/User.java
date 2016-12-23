package com.ssmm.pojo;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private String stuOrJobid;
    private String password;
    private Date registerTime;
    public Integer getId() {
		return id;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getStuOrJobid() {
		return stuOrJobid;
	}

	public void setStuOrJobid(String stuOrJobid) {
		this.stuOrJobid = stuOrJobid;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	private Integer processId;
    public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}
	private Integer type;
   /**
    * 验证是否有支部权限
    * @return
    */
	public boolean haveBranchPermission()
	{
		if((type&4) == 4)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	  /**
	    * 验证是否有支部权限
	    * @return
	    */
		public boolean haveHeadPermission()
		{
			if((type&8) == 8)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", StuOrJobid="
				+ stuOrJobid + ", password=" + password + ", registerTime="
				+ registerTime + ", processId=" + processId + ", type=" + type
				+ "]";
	}
		
}