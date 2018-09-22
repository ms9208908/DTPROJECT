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
<h1>Address List</h1>
<table class="table table-condensed">
    <thead>
      <tr>
        <th>House Number</th>
        <th>Locality</th>
       	<th>City</th>
       	<th>State</th>
       	<th>Pincode</th>
       	
      </tr>
    </thead>
   <tbody>
 <c:forEach items="${addressList}" var="addressObj">
 		
  		<tr>
  			<td>${addressObj.houseNumber}</td>
  			<td>${addressObj.locality}</td>
  			<td>${addressObj.city}</td>
  			<td>${addressObj.state}</td>
  			<td>${addressObj.pinCode}</td>
  			
  		</tr>
  		
  </c:forEach>
  		<tr>
  			<td></td>
  			<td><a href="${contextRoot}/addToCart/placeOrder" class="btn btn-primary">Place Order</a></td>
  		</tr>
  </tbody>
</table>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
