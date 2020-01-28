<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.mvc.entity.Student,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 隔行变色  -->
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
		$("tr:odd").css("background-color","lightblue") ;
	}) ;
</script>
<title>Insert title here</title>

</head>
<body>
	<table border="1">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>操作</th>
		</tr>
		
		<%
		// 获取request域的students 数据
		List<Student>  students= (List<Student>) request.getAttribute("students");
		
		for(Student student :students){
			
		
		%>
		<tr>
		   <td><a href="queryStudentServlet?id=<%=student.getId() %>"><%=student.getId() %></a></td>
		   <td><%=student.getName() %></td>
		   <td><%=student.getAge() %></td>
		   <td><%=student.getGender() %></td>
		   <td><a href="deleteStudentServlet?id=<%=student.getId() %>">删除</a></td>
		</tr>
		
		<%
		   }
		%>
	</table>
	
	<a href="add.jsp">新增</a>
</body>
</html>