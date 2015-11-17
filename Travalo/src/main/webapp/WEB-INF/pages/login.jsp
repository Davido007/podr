<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
    <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
    </head>
<body>
  <%@ include file="header.jsp" %>
  <section class="container">
    <div class="login">
      <h1>Login to Web App</h1>
      <form method="post" id="loginForm" action="login">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <label class="label label-primary" path="login">Login</label>
        <input type="text" class="form-control" name="login" path="login" />
        <p><label class="label label-primary" path="password">Password</label></p>
        <p><input type="password" class="form-control" name="password" path="password" /></p>

            <input type="submit" id="submitLogin" class="btn btn-primary btn-lg" value="Login" />

          </form>
    </div>

    <div class="login-help">
      <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
    </div>
  </section>
<%@ include file="footer.jsp" %>
</body>
</html>
