<!-- navbar -->
<!-- jsp include will include the contents at runtime...will not copy like include directive -->
 <jsp:include page="./shared/navbar.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="springs" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<div class="container">

<div style="color:red">${msg}</div>
<br/>
	<h1>Sign Up Form</h1>
	<springs:form action="${contextRoot}/addUser" method="post" modelAttribute="userObj">
  	<div class="form-group">
    <label for="UserName">User Name:</label>
    <springs:input type="text" class="form-control" path="name"/>
  	</div>
  	
  	<div class="form-group">
    <label for="email">Email:</label>
    <springs:input type="email" class="form-control" path="email"/>
  	</div>
  	
  	<div class="form-group">
    <label for="password">Password:</label>
    <springs:input type="password" class="form-control" path="password"/>
  	</div>
  	
  	<div class="form-group">
    <label for="password2">Confirm Password :</label>
    <springs:input type="text" class="form-control" path="password2"/>
  	</div>
    
    <div class="form-group">
    <label for="phone">Contact Number:</label>
    <springs:input type="mobile" class="form-control" path="phone"/>
  	</div>
  	

  	
  	
  	
   <button type="submit" class="btn btn-default">Register</button>
</springs:form>
</div>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
