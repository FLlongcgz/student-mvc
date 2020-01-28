package com.mvc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;

public class queryAllStudentServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		// 获取前台 输入的 需要查询的学号
		
		StudentService studentService = new StudentService() ;
		
		//查询得到一个学生
		List<Student> students = studentService.queryAllStudent();
		System.out.println(students);
		
		// 把 student集合存到 request域，通过请求转发的方式，因为 重定向会丢失数据
		req.setAttribute("students", students);
		req.getRequestDispatcher("studentList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
