package com.zzzy.contorller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzzy.ex.ExcelUtil;
import com.zzzy.service.studentSer;
import com.zzzy.vo.studentVO;

@Controller
@RequestMapping("/user/")
public class studentController {

	@Resource(name="studentSer")
	private studentSer stuService;

	@RequestMapping("excel")
	public  String login(HttpServletRequest req,HttpServletResponse res) throws IOException{
		List<studentVO> ls=stuService.getInfo();
		List<HashMap<String, Object>> lists =new ArrayList<HashMap<String, Object>>();
		for(int i = 0 ; i<ls.size();i++){
			HashMap<String, Object> list = new HashMap<String, Object>();
			int Id=ls.get(i).getId();
			String username=ls.get(i).getUsername();
			String password =ls.get(i).getPassword();
			list.put("Id", Id);
			list.put("username", username);
			list.put("password", password);
			lists.add(list);
		}
		String path =req.getSession().getServletContext().getRealPath("") +"student.xls";
		System.out.println(path);
		try {
			ExcelUtil.exporData(lists, path);
			System.out.println("excel导出成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "MyJsp";
	}
}
