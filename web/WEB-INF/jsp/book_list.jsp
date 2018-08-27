<%@ page import="util.WebUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>图书列表</title>
</head>
<body>

<%= WebUtil.popSessionMsg(request) %>

<form id="myForm" action="<c:url value="/book/del" />" method="post">
    <table class="table table-striped">
        <tr>
            <th><input type="checkbox" onclick="toggle_check_all(this)"></th>
            <th>id</th>
            <th>书名</th>
            <th>价格</th>
            <th>作者</th>
            <th>出版社</th>
            <th>其他</th>
        </tr>

        <c:forEach var="book" items="${books}" varStatus="st">
            <tr>
                <%--
                <c:if test="${st.count % 2 == 0}">
                    <tr style="color:blue">
                </c:if>
                <c:if test="${st.count % 2 != 0}">
                    <tr style="color:red">
                </c:if>
                --%>
                <td><input name="id" value=${book.id} type="checkbox"></td>
                <td>${book.id}</td>
                <td><a href="<c:url value="/book/detail?id=${book.id}" />">${book.name}</a></td>
                <td><f:formatNumber value="${book.price}" type="CURRENCY" currencySymbol="$"/></td>
                <td>${book.author}</td>
                <td>${book.press}</td>
                <td>
                    <c:url var="link" value='/book/del'>
                        <c:param name="id" value="${book.id}" />
                        <c:param name="other" value="2323"/>
                    </c:url>
                    <a href="${link}">删除</a>
                    <a href="#myModal" data-toggle="modal" data-id="${book.id}">更新</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div style="margin-top: 2em;">
        <input type="submit" value="删除" class="btn btn-success">
        <a class="btn btn-primary" href="<c:url value="/book/add" />">增加新的书籍</a>
    </div>
</form>

<%--弹出来的修改页面--%>
<%@ include file="book_update_modal.jsp" %>

<script>
    function toggle_check_all(e) {
        var checkboxs = document.getElementsByName("id");
        for (var i = 0; i < checkboxs.length; i++) {
            checkboxs[i].checked = e.checked;
        }
    }

    document.querySelector("#booklist").classList.add("active");
</script>

</body>
</html>
