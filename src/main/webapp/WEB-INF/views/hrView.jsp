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
	display: block;
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
<script type="text/javascript">
function validate() {
    var Name = document.getElementById('jobdesc').value;
    var Tel = document.getElementById('Tel').value;
    var FaxNo = document.getElementById('FaxNo').value;

    if (Name == "") //wanted to check for alphabets only.
        alert("Job Desc connot be blank");    
}

</script>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<ul>
		<li><h1 style="color: white">HR Portal</h1></li>
		<li></li>
	</ul>
	<p>
		<b><u>Create Jobs</u></b>
	</p>

	<form action="${contextPath}/user/create-job.htm" method="POST">
		<table id="customers">
			<tr>
				<td>Job Description</td>
				<td><input id="jobdesc" type="text" name="jobdesc" size="30"
					required="required" /></td>
				<td colspan="2"><input type="submit" value="Create Job" onclick="validate();"/></td>
			</tr>
		</table>
	</form>


	<p>
		<b><u>Here are all the listed jobs</u></b>
	</p>
	<p>
	<table id="customers">
		<tr>
			<th>Job Description</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${requestScope.job_list}" var="job">

			<tr>
				<td>${job.jobDesc}</td>
				<td>${job.status}</td>
			</tr>

		</c:forEach>
	</table id="customers">
	</p>
	<p>
		<b><u>Applications Recieved</u></b>
	</p>
	
	<p>
	<form action="${contextPath}/user/decision.htm" method="POST">
	<table id="customers">
		<tr>
			<th>Job Desc</th>
			<th>User Email</th>
			<th>Application Status</th>
			<th>Select Application</th>
		</tr>
		<c:forEach items="${requestScope.applicationList}" var="application">

			<tr>
				<td>${application.job.jobDesc}</td>
				<td>${application.user.userEmail}</td>
				<td>${application.job.status}</td>
				<td><input type="checkbox" name="application_id"
					value="${application.application_id}"></td>
			</tr>

		</c:forEach>
	</table>
			
		<input id="logoutButton" type="submit" name='action' value="Accept">
		<input id="logoutButton" type="submit" name='action' value="Reject"> 		
	</form>
	
	
	</p>
	<form action="${contextPath}/user/logout.htm">
		<!-- // URL '/logout' -->
		<input id="logoutButton" type="submit" value="LOGOUT">
	</form>
</body>
</html>