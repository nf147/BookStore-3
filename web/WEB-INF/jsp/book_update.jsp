<%@ page import="com.nf.bookstore3.entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍修改表单</title>
</head>
<body>

<form action="/book/update" method="post">
    <div><input type="text" name="name" placeholder="name" value="${requestScope.book.name}"></div>
    <div><input type="number" step="0.01" name="price" placeholder="price" value="<${requestScope.book.price}"></div>
    <div><input type="text" name="author" placeholder="author" value="<${requestScope.book.author}"></div>
    <div><input type="text" name="press" placeholder="press" value="${requestScope.book.press}"></div>
    <div><input type="hidden" name="id" value="${requestScope.book.id}"></div>

    <div><input type="submit" value="提交更新"></div>
</form>

</body>
</html>
