package com.gdms.vo;

import com.gdms.pojo.User;
/**
 * 
 * @author wy
 *
 */
public class UserVO extends User{
	/**
	 * 老师是否选择该学生
	 * 0 未选
	 * 1已选
	 */
	private Integer tCSFlag;

	public Integer gettCSFlag() {
		return tCSFlag;
	}

	public void settCSFlag(Integer tCSFlag) {
		this.tCSFlag = tCSFlag;
	}
	
}
