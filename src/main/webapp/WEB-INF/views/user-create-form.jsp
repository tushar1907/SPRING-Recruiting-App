<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style>
body {font-family: Arial, Helvetica, sans-serif; background-color: grey;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password], input[type=submit]{
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HR Operations Manager</title>
</head>
<body>
	<h1>User Registration Form</h1>
	<font color="red">${errorMessage}</font>
	<div class="container">
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form action="${contextPath}/user/create-form.htm" method="POST">
		<table>
			<tr>
				<td>User Email:</td>
				<td><input type="text" name="useremail" size="30"
					required="required" /></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" size="30"
					required="required" /></td>
			</tr>
			
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="username" size="30"
					required="required" /></td>
			</tr>
			
			<tr>
		    <td>Role:</td>
		    <td>
		    
		    <select name = "dropdown" required="required">
            	<option value = "hr" selected>HR Manager</option>
            	<option value = "applicant">Applicant</option>
         	</select>
         	
         	</td>
		</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Register" /></td>
			</tr>

		</table>
	</form>
  </div>
	
</body>
</html>