<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>home-page</title>
<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>


<script type="text/javascript">
	function validate() {
		var name = document.getElementById("yn").value;
		if (name.length < 3) {
			alert("Your Name Should Have At Least 3 Character!")
			return false;
		}
		if (name.length > 15) {
			alert("Your Name Should Have At Most 15 Character!")
			return false;
		}
		if (document.getElementById("sign").value == false) {
			alert("Please Select The Check Box!")
			return false;
		}
		return true;
	}
</script>
</head>
<body style="background: pink;">

	<h1 align="center">Love Calculator</h1>
	<hr />

	<form:form action="process-homepage" method="post"
		modelAttribute="userInfo">
		<div align="Center">
			<p>
				<label for="yn" >Your Name:</label>
				<form:input id="yn" path="userName" />
				<form:errors path="userName" cssClass="error" />
			</p>

			<p>
				<label for="cn">Crush Name:</label>
				<form:input id="cn" path="crushName" />
			</p>

			<p>
			<p>
				<form:checkbox id="sign" path="signAgreement" />
				<label for="sign">I am agreeing that this is for fun.</label>
				<form:errors path="signAgreement" cssClass="error" />
			</p>
			<input type="submit" id="calculate"/>
			</p>
		</div>
	</form:form>
</body>
</html>