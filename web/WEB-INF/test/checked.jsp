<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>checkbox test</title>
    <script src="<c:url value="/assets/js/jquery1.12.4.js" />"></script>
</head>
<body>

<div id="hello">
    <div><input type="checkbox" value="苹果" name="fruit"> 苹果</div>
    <div><input type="checkbox" value="桃子" name="fruit"> 桃子</div>
    <div><input type="checkbox" value="香蕉" name="fruit"> 香蕉</div>
    <button onclick="checkFourLines2()">判断是否被选中</button>
</div>

<div id="world" style="margin-top: 3em;">
    <div><input type="checkbox" value="Java" name="fruit"> 苹果</div>
    <div><input type="checkbox" value=".net" name="fruit"> 桃子</div>
    <div><input type="checkbox" value="CSS" name="fruit"> 香蕉</div>
</div>

<script>
    function checkIt() {
        // 获取数据
        var cb = $("#hello input[type=checkbox]");

        // 过滤数据
        var checkList = [];
        $.each(cb, function (index, obj) {
            if ($(obj).prop("checked")) {
                checkList.push($(obj).val());
            }
        });

        // 渲染数据
        if (checkList.length === 0) {
            console.log("没有选中任何数据");
        } else {
            console.log("你选中了:", checkList.join(";"));
        }
    }

    function checkFourLinesJQueryVersion() {
        var result = [];
        $("#hello input").each(function (index, ele) {
            if (ele.checked) result.push(ele.value);
        });
        console.log(result.length === 0 ? "没有选中" : result.join("/"));
    }

    function checkFourLines() {
        let result = [];
        document.querySelectorAll("#hello input").forEach((e) => {
            if (e.checked) result.push(e.value)
        });
        console.log(result.length === 0 ? "没有选中" : result.join("/"));
    }

    function checkFourLines2() {
        let result = [];
        document.querySelectorAll("#hello :checked").forEach((e) => {
            result.push(e.value)
        });
        console.log(result.length === 0 ? "没有选中" : result.join("/"));
    }

    $("#world input[type=checkbox]").click(function (e) {
        // 将所有选中的 checkbox 取消选中状态
        $("#world input:checked").prop("checked", false);
        // 选中当前点击的条目
        $(this).prop("checked", true);
    })

</script>
</body>
</html>
