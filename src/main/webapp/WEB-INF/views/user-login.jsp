<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>HR Operations Manager</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	
	<style>@import "bourbon";

body {
	background: #eee !important;	
}

.wrapper {	
	margin-top: 80px;
  margin-bottom: 80px;
  size: 70px
}

.form-signin {
  max-width: 380px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);  

  .form-signin-heading,
	.checkbox {
	  margin-bottom: 30px;
	}

	.checkbox {
	  font-weight: normal;
	}

	.form-control {
	  position: relative;
	  font-size: 16px;
	  height: auto;
	  padding: 10px;
		@include box-sizing(border-box);

		&:focus {
		  z-index: 2;
		}
	}

	input[type="text"] {
	  margin-bottom: -1px;
	  border-bottom-left-radius: 0;
	  border-bottom-right-radius: 0;
	}

	input[type="password"] {
	  margin-bottom: 20px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
}
	</style>
	
	<!--  
<style>
body {font-family: Arial, Helvetica, sans-serif; background-color: grey;}
form {border: 3px solid #f1f1f1;}



input[type=text], input[type=password]{
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
input.invalid, textarea.invalid{
	border: 2px solid red;
}

input.valid, textarea.valid{
	border: 2px solid green;
}

form label {
  display: inline-block;
  width: 100px;
}

form div {
  margin-bottom: 10px;
}

.error {
  color: red;
  margin-left: 5px;
}

label.error {
  display: inline;
}
</style

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
$(document).ready(function() {

	  $('#first_form').submit(function(e) {
	    e.preventDefault();
	    var first_name = $('#username').val();
	    var last_name = $('#password').val();	    

	    $(".error").remove();

	    if (first_name.length < 1) {
	      $('#first_name').after('<span class="error">This field is required</span>');
	    }
	    if (last_name.length < 1) {
	      $('#last_name').after('<span class="error">This field is required</span>');
	    }
	    
	  });


	});</script>>	
-->

</head>
<body>	
 <div class="wrapper">
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <form class="form-signin" action="${contextPath}/user/login.htm" method="POST">       
      <h2 class="form-signin-heading">User Login Form</h2>
      <input type="text" class="form-control" name="useremail" id="username" size="30" required="required" placeholder="Email Address" autofocus="" />
      <input type="password" class="form-control" name="password" placeholder="Password" required="required"/>
      <select name = "dropdown" required="required">
            	<option value = "hr" selected>HR Manager</option>
            	<option value = "applicant">Applicant</option>
      </select>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>   
      <a href="${contextPath}/user/create.htm" style="color: black;">Register User</a>
    </form>
  </div>
  	
</body>
</html>
