<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
<spring:url var="images" value="/resources/images"/>

<body>
<jsp:include page="./shared/navbar.jsp"></jsp:include>			
   <div class="container">
   
   
   <c:if test="${not empty message}"> 
   	 <div class="row">
     
     <div class="col-md-offset-3 col-md-6">
   		<div class="alert alert-danger">
   			${message}
   		</div>
   	</div>
   	</div>
    </c:if> 
    <div class="row">
     
     <div class="col-md-offset-3 col-md-6">
      
      <div class="panel panel-primary">
       
       <div class="panel-heading">
        <h4>Login</h4>
       </div>
       
       
       <div class="panel-body">
       
        <form action="login" method="POST" class="form-horizontal" id="loginForm">
        
        
         <div class="form-group">
          <label for="username" class="col-md-4 control-label">Email: </label>
          <div class="col-md-8">  
           <input type="text" name="username" id="username" class="form-control" required="required"/>
          </div>
          </div>
         <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <input type="password" name="password" id="password" class="form-control" required="required"/>
          </div>
         </div>
          <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
      	   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
          <input type="submit" value="Login" class="btn btn-primary"/>
          </div>
          </div>-
        </form>
       
       </div>
       
      </div> 
    
 	     </div>
     
    </div>    
   
   </div>

<jsp:include page="./shared/footer.jsp"></jsp:include>
</body>

</html>