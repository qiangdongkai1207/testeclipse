package com.zzzy.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzzy.idao.studentIdao;
import com.zzzy.vo.studentVO;

@Service("studentSer")
public class studentSer {

	@Autowired
	private studentIdao stuIdao;

	public List<studentVO> getInfo(){

		return stuIdao.getstudentInfo();
	}

}
