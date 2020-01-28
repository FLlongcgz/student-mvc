<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.mvc.entity.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>学生详情信息</h1>

<%
     Student student= (Student) request.getAttribute("student");
%>

<form action="updateStudentServlet">
    学号:<input type="text" name="id" value="<%=student.getId() %>" readonly="readonly" /> <br />
    姓名:<input type="text"  name="name" value="<%=student.getName() %>" /> <br />
    年龄:<input type="text"  name="age" value="<%=student.getAge() %>" /> <br />
    性别:<input type="text" name="gender"  value="<%=student.getGender() %>" /> <br />
   <input type="submit" value="修改">
   <a href="queryAllStudentServlet">返回</a>
   
</form>
<!--  -->
</body>
</html>