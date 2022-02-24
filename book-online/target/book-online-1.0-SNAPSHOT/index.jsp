<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.radical.entity.Book" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
    <style type="text/css">
        .container {
            width: 80%;
            margin: 0 auto;
            background-color: #ddd;
            display: flex;
            padding: 10px 10px 10px 10px;
            flex-wrap: wrap;
        }

        .box {
            flex: 0 0 20%;
            height: 280px;
            margin: 5px 5px 5px 5px;
            /*background-color: #fff;*/
        }

        .box img {
            width: 70%;
            height: 80%;
        }
    </style>
</head>
<body>
<h2>欢迎你</h2>
<%
    String username = (String) session.getAttribute("username");
    if (username != null) {
        pageContext.setAttribute("username", username);
%>
${username}
<%
} else  {
%>
<h3><a href="${pageContext.request.contextPath}/">去登陆</a></h3>
<%
    }
%>
<hr>
<h2>图书信息</h2>
<%
    List<Book> bookList = (List<Book>) request.getAttribute("bookList");
    pageContext.setAttribute("size", bookList.size());
%>
一共${size}本书
<div class="container" >
    <%
        for (Book book : bookList) {
            pageContext.setAttribute("book", book);
    %>
    <div class="box">
        <img src="images/${book.cover}" alt="">
        <p>${book.name}</p>
        <p>${book.author}</p>
    </div>
    <%
        }
    %>
</div>
</body>
</html>