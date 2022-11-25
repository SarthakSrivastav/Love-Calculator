<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>welcome</head>

<body>

<h1 align="center">Welcome Lovers</h1>
	<p> Name : ${registerUser.name}</p>
	<p> User Name : ${registerUser.userName}</p>
	<p> Password : ${registerUser.password}</p>
	<p> Country : ${registerUser.country}</p>
	<p> Hobby : 
	
	<c:forEach var="tmp" items="${registerUser.hobby}">
		${tmp}
	</c:forEach>
	</p>
	<p> Gender : ${registerUser.gender}</p>
	<p> Age : ${registerUser.age}</p>
	<p> Email : ${registerUser.communicationInfo.email}</p>
	<p> Phone : ${registerUser.communicationInfo.phoneNo}</p>
	
	

</body>
</html>