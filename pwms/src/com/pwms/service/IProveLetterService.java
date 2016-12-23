package com.pwms.service;

import java.io.File;

import com.pwms.pojo.ProveLetter;

//证明信
public interface IProveLetterService {
	//保存证明信对象
	public void save(ProveLetter proveletter);
	//获取对象
	public ProveLetter getProveLetter(int id);
	//导出证明信
	public File exportWord(ProveLetter proveletter);

}
