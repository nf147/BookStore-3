<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li id="booklist"><a href="<c:url value="/book/index"/>">书籍列表</a></li>
        <li id="booklist_ajax"><a href="<c:url value="/book/index?ajax=1"/>">书籍列表(Ajax版)</a></li>
        <li id="bookadd"><a href="<c:url value="/book/add"/>">新增书籍</a></li>
        <li><a href="#">作者管理</a></li>
        <li><a href="#">导出数据</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li><a href="<c:url value="/ws/bookcount"/>">WebSocket|SSE</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li><a href="">订单管理</a></li>
        <li><a href="">库存管理</a></li>
        <li><a href="">用户管理</a></li>
        <li><a href="">系统设置</a></li>
    </ul>
</div>