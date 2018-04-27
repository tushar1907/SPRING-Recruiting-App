<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

input[type=button], input[type=submit], input[type=reset] {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 16px 32px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #4CAF50;
	color: white;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: center;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

/* Change the link color to #111 (black) on hover */
li a:hover {
	background-color: #111;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HR Operations Manager</title>
</head>
<body>
	<ul>
		<li><h1 style="color: white">Applicant Portal</h1></li>
		<li></li>
	</ul>

	<p>
		<b><u>Here are all the listed jobs</u></b>
	</p>
	<p>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form action="${contextPath}/user/apply.htm" method="POST">
		<table id="customers">
		<tr>
			<th>Job Description</th>
			<th>Status</th>
			<th>Apply</th>
		</tr>
		<c:forEach items="${requestScope.job_list}" var="job">
			<tr>
				<td>${job.jobDesc}</td>
				<td>${job.status}</td>
				<td><input type="checkbox" name="job_id" value="${job.job_id}"></td>
			</tr>
		</c:forEach>		
	</table>
	<input type="submit" value="Apply" />
	
	</form>
	</p>
	<p>
		<b><u>Jobs Applied</u></b>
	</p>
	<table id="customers">
		<tr>
			<th>Job Description</th>			
			<th>Application ID</th>
			<th>Application Status</th>
		</tr>
		<c:forEach items="${requestScope.applicationList}" var="application">
		
			<tr>
				
				<td>${application.job.jobDesc}</td>					
				<td>${application.application_id}</td>
				<td>${application.job.status}</td>	
							
			</tr>
			
		</c:forEach>
	</table>
	<form action="${contextPath}/user/logout.htm">  <!-- // URL '/logout' -->            
            <input id="logoutButton" type="submit" value="LOGOUT">
    </form>
</body>
</html>