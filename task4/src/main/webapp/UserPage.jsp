<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>UserPage</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
  <style><%@include file="/css/UserPage.css"%></style>
</head>


<body>


    <div id = "header">
        <button id ="exitBtn" onclick="ale()">log out</button>
    </div>

    <div id = "block">
        <div id = "grid">
                <button id ="add" onclick="addRowInTable()" class = "Btn">add order</button>
                <button id ="save" onClick = "saveOrder()" class = "Btn">save order</button>
                <table id="table"></table>
        </div>
    </div>
    
    
    


</body>
    <script><%@include file="/js/UserPage.js"%></script>

</html>