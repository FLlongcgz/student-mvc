package com.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.service.StudentService;

public class deleteStudentServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		// 获取前台 输入的 需要删除的学号
		int id = Integer.parseInt(req.getParameter("id"));
		
		// 调用 业务逻辑层
		StudentService studentService = new StudentService() ;
		
		boolean result = studentService.delteStudentById(id);
		
		PrintWriter out = resp.getWriter();
		if (result) {
			out.print("删除成功");
		//删除成功后，再跳回显示页面
			// 成功删除一个人，再重新查询所有
			resp.sendRedirect("queryAllStudentServlet");
		}else {
			out.print("删除失败");
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
