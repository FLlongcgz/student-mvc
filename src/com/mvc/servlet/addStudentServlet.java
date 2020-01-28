package com.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;

public class addStudentServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id")); // 
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		
		// ��װ��ʵ����
		
		Student student = new Student(id,name,age,gender) ;
		
		
		StudentService studentService = new StudentService() ;
		
		boolean result = studentService.addStudent(student);
		//设置 响应编码
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if (result) {
			
			out.print("添加成功");
			// 增加成功后返回 查询所有并显示
			resp.sendRedirect("queryAllStudentServlet");
		}else {
			out.print("添加失败");
		}
	}
}

