package com.gdms.vo;

import com.gdms.pojo.User;
/**
 * 
 * @author wy
 *
 */
public class UserVO extends User{
	/**
	 * ��ʦ�Ƿ�ѡ���ѧ��
	 * 0 δѡ
	 * 1��ѡ
	 */
	private Integer tCSFlag;

	public Integer gettCSFlag() {
		return tCSFlag;
	}

	public void settCSFlag(Integer tCSFlag) {
		this.tCSFlag = tCSFlag;
	}
	
}
