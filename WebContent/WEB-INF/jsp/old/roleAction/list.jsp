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
<h1>list</h1>
<%-- 
<s:iterator value="#roleList">
		<s:property value="id"/>,
		<s:property value="name"/>,
		<s:property value="description"/>,
		<s:a action="role_editUI.action?id=%{id}">编辑</s:a>
		<s:a action="role_delete.action?id=%{id}"  onclick="return confirm ('确定要删除吗？')">删除</s:a><br>
	
</s:iterator>
--%>

<s:iterator value="#roleList">
		${id },..
		${name },
		${description },
		<s:a action="role_editUI.action?id=%{id}">编辑</s:a>
		<s:a action="role_delete.action?id=%{id}"  onclick="return confirm ('确定要删除吗？')">删除</s:a><br>
	
</s:iterator>
<a href="role_addUI.action">添加</a>
</body>
</html>