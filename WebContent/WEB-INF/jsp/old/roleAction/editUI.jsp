<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>editUI</h1>
<s:form action="role_edit.action"  method="post">
		<s:hidden name="id"></s:hidden>
		<s:text name="职位名称："></s:text>
		<s:textfield name="name"></s:textfield><br>
		<s:text name="职位描述："></s:text>
		<s:textarea name="description"></s:textarea><br>
		<s:submit value="提交"></s:submit>
</s:form>
</body>
</html>