package com.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;

public class updateStudentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 响应编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		// 获取前台 输入的 需要修改的学号
		int id = Integer.parseInt(req.getParameter("id"));
		
		// 修改后的内容
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		
		// 将修改后的内容封装到 实体类
		Student student = new Student(name, age, gender) ;
		// 调用 业务逻辑层
		StudentService studentService = new StudentService() ;
		
		boolean result = studentService.updateStudentById(id, student);
		
		if (result) {
//			resp.getWriter().print("修改成功");
			// 修改完成后，跳转到 查询所有的页面
			resp.sendRedirect("queryAllStudentServlet");
		}else {
			resp.getWriter().print("修改失败");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
