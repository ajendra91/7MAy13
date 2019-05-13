<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>

        <%= "welcome to index.jsp"%>

        <f:form  modelAttribute="emp">
            <f:input path="id" />
            <f:input path="name" />
            <f:errors path="name" />
            <f:input path="age" />
            <f:errors path="age" />
            <f:button>Submit</f:button>
        </f:form>

    <body>
</html>