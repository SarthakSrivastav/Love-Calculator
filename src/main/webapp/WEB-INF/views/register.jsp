<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>register</title>
<script type="text/javascript">
	function validate() {
		var name = document.getElementById("n").value;
		if (name.length < 1 || name == " ") {
			alert("Your Name Should Have At Least One Character!")
			return false;
		} else
			return true;
	}
</script>

<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>

</head>
<body>
	<h1 align="center">Create Registration Form using Form Tag in
		Spring MVC</h1>

	<form:form action="validateRegistration" method="get"
		modelAttribute="registerUser">

		<div align="center">

			<!-- A Simple Input Field -->
			<p>
				<label for="n">Name :</label>
				<form:input id="n" path="name" />
				<form:errors path="name" cssClass="error"/>
			</p>

			<p>
				<label for="yn">User Name :</label>
				<form:input id="yn" path="userName" />
				<form:errors path="userName" cssClass="error"/>
			</p>

			<p>
				<label for="pass">Password :</label>
				<form:password id="pass" path="password"  />
			</p>



			<!-- DropDown Field -->
			<label>Country : </label>
			<form:select path="country" required="true">
				<form:option value="india" label="India"></form:option>
				<form:option value="pak" label="Pakistan"></form:option>
				<form:option value="nepal" label="Nepal"></form:option>
				<form:option value="russia" label="Russia"></form:option>
			</form:select>

			<br />

			<!-- CheckBox Field -->
			<label>Hobby : </label> Java :
			<form:checkbox path="hobby" value="java" checked="checked" />
			Python :
			<form:checkbox path="hobby" value="python" />
			C++ :
			<form:checkbox path="hobby" value="cpp" />
			DSA :
			<form:checkbox path="hobby" value="dsa" />
			Spring :
			<form:checkbox path="hobby" value="spring" />

			<br />

			<!-- RadioButton Field -->
			<label>Gender : </label>
			
			 <label for="m">Male</label>
			 <form:radiobutton path="gender" value="male" checked="checked" id="m"/>
			 
			 <label for="f">Female</label>
			 <form:radiobutton path="gender" value="female" id="f"/>
			<br />
			
			Age :
			<form:input path="age"/>
			<form:errors path="age" cssClass="error"/>		

		</div>

		<div align="center">
		
			<h3>Communication:</h3>
			<p>
			<label for="comm">Email ID :</label>
			<form:input id="comm" path="communicationInfo.email"/><br/>
			<form:errors path="communicationInfo.email" cssClass="error"/>
			<p/>
			<p>
			<label for="phone">Phone Number :</label>
			<form:input path="communicationInfo.phoneNo"/>
			<form:errors path="communicationInfo" cssClass="error"/>
			<p/>
			
		</div>
		
		<!-- Button Field -->
		<div align="center">
			<input type="submit" value="Register">
		</div>

	</form:form>

</body>
</html>




















