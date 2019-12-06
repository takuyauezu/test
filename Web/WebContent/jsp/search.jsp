<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%ArrayList<String> purudaun=new ArrayList<String>();%>
<% purudaun= (ArrayList<String>)request.getAttribute("category"); %>

<body>




<h1>検索</h1>
<form action="http://localhost:8080/Web/login">
<input type="submit" value="検索">


<select name="example">
<% 	for(int i=0; i< purudaun.size();i++){%>
<option value="<%=i %>"><%=purudaun.get(i)%></option>
<% }%>
</select>

<table border="1">
<tr>
<th>商品名</th>
<th>価格</th>
<th>詳細</th>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
</tr>
</table>
</form>
</body>
</html>