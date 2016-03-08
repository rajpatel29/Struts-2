<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@  taglib prefix = "s" uri = "/struts-tags" %>     
    
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	<form action="tutorials/getTutorial.action" method="post">
		<input type="text" name="language"  placeholder="Language"> 
		<input type="submit" value="submit">
	</form>
 -->
 
 
 <s:form  action="tutorials/getTutorial">
 	<s:textfield label="Enter Language you wnat to search for " key = "language" />
 	<s:submit />
 </s:form>
 
 
 	
</body>
</html>