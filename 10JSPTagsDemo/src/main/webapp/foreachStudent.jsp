<%@ page import="java.util.* , com.tags.Student" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
List<Student> students=new ArrayList<>();
	students.add(new Student("Mary","Jones",true));
	students.add(new Student("Max","Jones",false));
	students.add(new Student("Eric","Jones",true));
	students.add(new Student("Miller","Jones",false));
	pageContext.setAttribute("mystudents",students);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Above 90</th>
		</tr>
		<c:forEach var="student" items="${mystudents}">
		<tr>
			
				<td>${student.fname }</td>
				<td>${student.lname }</td>
				<td>
					<c:if test="${student.above90 }">
						${student.above90 }
					</c:if>
					<c:if test="${not student.above90 }">
						NA
					</c:if>
				</td>
			
		</tr>
		</c:forEach>
	</table>
</body>
</html>