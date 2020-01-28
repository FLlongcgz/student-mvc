package com.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;

public class queryStudentServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		// 获取前台 输入的 需要查询的学号
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentService studentService = new StudentService() ;
		
		//查询得到一个学生
		Student student = studentService.queryStudentById(id);
		
		// 将查询到的学生信息放到 request域中
		req.setAttribute("student", student);
		// 打印到控制台
		System.out.println(student.toString());
		
		// 显示到 jsp 页面studentInfo
		// request域没有数据，则使用重定向； resp.sendRedirect()
		//有则 使用请求转发  req.getRequestDispatcher().forward()
		req.getRequestDispatcher("studentInfo.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
