<%--
  Created by IntelliJ IDEA.
  User: zhangpeiran
  Date: 2019/7/9
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Book Form</title>
</head>
<body>
<div id="global">
    <!--commandName定义了模型属性的名称，其中包含了一个backing object，其属性将用于填充所生成的表单。如果该属性存在，则必须在返回包含该表单的视图的请求处理方法
中添加相应的模型属性-->
    <form:form commandName="book" action="book_save" method="post">
        <fieldset>
            <legend>Add a book</legend>
            <p>
                <label for="category">Category: </label>
                <!--标签也可以绑定到嵌套对象的属-->
                <!--绑定book.category.id-->
                <!--items指定select的可选值来自model中的categories集合-->
                <!--itemLabel指定集合中对象的某个属性为每个input元素提供label-->
                <!--itemValue指定集合中对象的某个属性为每个input元素提供值-->
                <form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id"/>
            </p>
            <p>
                <!-- path指定输入字段绑定到formbacking object的一个属性-->
                <!--绑定book.title-->
                <label for="title">Title: </label>
                <form:input id="title" path="title"/>
            </p>
            <p>
                <!--绑定book.author-->
                <label for="author">Author: </label>
                <form:input id="author" path="author"/>
            </p>
            <p>
                <!--绑定book.isbn-->
                <label for="isbn">ISBN: </label>
                <form:input id="isbn" path="isbn"/>
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5"
                       value="Add Book">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
