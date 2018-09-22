<!-- navbar -->
<!-- jsp include will include the contents at runtime...will not copy like include directive -->
 <jsp:include page="./shared/navbar.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="images" value="/resources/images"/>

 <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<div class="container">

<br/>



<h1 style="color:green">${msg}</h1>
<h1>List Of  Suppliers</h1>
<table class="table table-condensed">
    <thead>
      <tr>
        <th>Supplier Name</th>
        <th>Actions</th>
       <!--  <th>Image</th> -->
      </tr>
    </thead>
   <tbody>
 <c:forEach items="${supplierList}" var="supplierObj">
 		
  		<tr>
  			<td>${supplierObj.supplierName}</td>
  			<td><a href="#">Delete</a></td>
  			<td><a href="#">Update</a></td> 
  		</tr>
  </c:forEach>
  </tbody>
</table>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
