package com.zzzy.contorller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzzy.service.studentSer;
import com.zzzy.vo.studentVO;

@Controller
@RequestMapping("/user/")
public class excelController {

	@Resource(name="studentSer")
	private studentSer stuService;

	@RequestMapping("select")
	public  String login(HttpServletRequest req,HttpServletResponse res) throws IOException{
		List<studentVO> lists=stuService.getInfo();
		req.getSession().setAttribute("stu", lists);
		return "falg";
	}
}
