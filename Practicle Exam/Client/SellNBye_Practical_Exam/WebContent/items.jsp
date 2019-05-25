<%@page import="com.main.models.Item"%>
<%@page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	Item item =new Item();
	String itemsGrid = "";
	String rudFeedback ="";
	
	if(request.getParameter("hideMode")!=null && request.getParameter("hidMode").equalsIgnoreCase("getItems"))
	{
		rudFeedback =item.getItems(request.getParameter("txtItemName"));
	}

	itemsGrid=item.getItems();
	
	


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src=Controllers/jQuery.js></script>
<script type="text/javascript" src=Controllers/controllersMain.js></script>
</head>
<body>
	<form id="formItems" action="items.jsp" method="post">
		<input id="hidMode" name="hidmode" type="hidden" value="save">
		<input id="hidID" name="hidID" type="hidden" value="0">
		ItemName: <input id=txtItemName type="text" name="txtItemName"><br>
		<input id ="GetItems" type="button" name="GetItems" value="GetItems"><br><br>
		<div id="divStsMsgItem"><%out.println(rudFeedback); %></div>
		<%out.println(itemsGrid);%>
	</form><br>
</body>
</html>