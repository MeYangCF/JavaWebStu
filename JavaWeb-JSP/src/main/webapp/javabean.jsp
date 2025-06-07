<%@ page import="com.kuang.pojo.People" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<%
//    People people = new People();
//    people.setAddress();
//    people.setId();
//    people.setAge();
//    people.setName();
%>

<jsp:useBean id="people" class="com.kuang.pojo.People" scope="page"/>

<jsp:setProperty name="people" property="address" value="西安"/>
<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="age" value="3"/>
<jsp:setProperty name="people" property="name" value="小狂神呀"/>


<%--<%=people.getAddress()%>--%>

姓名：<jsp:getProperty name="people" property="name"/>
id：<jsp:getProperty name="people" property="id"/>
年龄：<jsp:getProperty name="people" property="age"/>
地址：<jsp:getProperty name="people" property="address"/>


</body>
</html>
