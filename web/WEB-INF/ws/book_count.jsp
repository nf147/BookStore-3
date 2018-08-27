<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看剩下多少书籍</title>
    <style>
        .book {
            color: red;
            padding: 0 5px;
        }
    </style>
</head>
<body>

<h2>书店现在还剩下<span class="book">${count}</span>本书籍</h2>

<script>
    function countBook() {
        $.ajax({
            method: 'post',
            url: '<c:url value="/ws/bookcount" /> '
        }).done(function (data) {
            $(".book").text(data.count)
        });
    }
    // window.setInterval("countBook()", 1000);


    // Server-Side Event

    let es = new EventSource("<c:url value="/ws/book_es" />");
    es.onmessage = function (e) {
        $(".book").text(e.data)
    };
    es.onerror = function (e) {
        console.error("现在有了错误", e.data);
        es.close();
    };
    es.onopen = function (evt) {
        console.log("我现在连接成功了", evt)
    };
</script>

</body>
</html>
