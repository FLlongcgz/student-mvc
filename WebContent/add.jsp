<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
   
    	
		var id = $("#id").val() ;
		var name = $("#name").val() ;
		var age = $("#age").val() ;
		var gender = $("#gender").val() ;
		 // 表单校验
    	function  check() {
			if(!(id>0 && id <100)){
				return false;
			}
			
			if(!(name.length >2 && name.length <4)){
				alert("名字的长度有误！必须时2-4位") ;
				return false;
			}
			if(!(age >0 && age <110)){
				alert("输入的年龄有误！必须是1-110之间") ;
				return false;
			}
			
			/* if(!(gender=='男' && gender=='女')){
				alert("性别必须为男或者女") ;
				return false;
			} */
			
			return true ;
		}
    	
    	$(document).ready(function() {
    		
    	}) ;
</script> -->
<title>Insert title here</title>
</head>
<body> 
<form action="addStudentServlet" method="post" ">
        学号 : <input type="text" name="id" id="id" /> <br />
        姓名 : <input type="text" name="name" id="name"/> <br />
        年龄 :<input type="text" name="age" id="age"/> <br />
        性别  : <input type="text" name="gender" id="gender"/> <br />
   <input  type="submit" value="添加"/>
</form>

</body>
</html>