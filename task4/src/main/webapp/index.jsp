<!DOCTYPE html>
<html>
<head>
	<%@ page contentType="text/html;charset=utf-8" %>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
	<title>Login page</title>
  <style><%@include file="/css/index.css"%></style>
</head>

<body>

    <div class="menu">
      <div class="menu-content">
        <!-- checked в зависомости от того с какой вкладки начинается взяимодествие с меню -->
        <!-- свойство name="inset" отвечает за то, чтобы состояние checked могло быть только у 1 меню -->
        <input type="radio" name="inset" id="btn-in">
        <!-- с помощью for связывается label c input по id -->
        <label id = "btn-in" for="btn-in" class="menu-title menu-head">Log in</label>

        <input type="radio" name="inset" id="btn-out">
        <label id = "btn-out" for="btn-out" class="menu-title menu-head">Registration</label>

        <div class="menu-group">
          <div class="menu-in">
            <div class="menu-info">
              <label>
                <span class="menu-info-label">User Login</span>
                <input id = "iLogin" type="text" size="40"><br>
              </label>
            </div>
            <div class="menu-info">
              <label>
                <span class="menu-info-label">Password</span>
                <input id = "iPassword" type="password" size="40"><br>
              </label>
            </div>
            <button class="close" onClick="login()">In</button>
          </div>

           <div  class="menu-out">
            <div class="menu-info">
              <label>
                <span class="menu-info-label">User Login</span>
                <input id = "login" type="text" size="40"><br>
              </label>
            </div>
            <div class="menu-info">
              <label>
                <span class="menu-info-label">Password</span>
                <input id = "password" type="password" size="40"><br>
              </label>
            </div>
            <div class="menu-info">
              <label>
                <span class="menu-info-label">User Name</span>
                <input id = "name" type="text" size="40"><br>
              </label>
            </div>
            <button class="close" onClick="registration()">Registration</button>
          </div>

        </div>
      </div>
    </div>

    <script><%@include file='/js/index.js'%></script>
</div>

</body>
</html>