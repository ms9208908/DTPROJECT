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
<h1>Cart</h1>
<table class="table table-condensed">
    <thead>
      <tr>
        <th>Item Name</th>
        <th>Price</th>
       	<th>Quantity</th>
       	<th>Image</th>
       	
      </tr>
    </thead>
   <tbody>
 <c:forEach items="${itemsList}" var="itemObj">
 		
  		<tr>
  			<td>${itemObj.product.productName}</td>
  			<td>${itemObj.price}</td>
  			<td>${itemObj.quantity}</td>
  			<td><img src="${images}/${itemObj.product.imgname}" style="height:200px;width:200px"/></td>
  		
  		</tr>
  		
  </c:forEach>
  		<tr>
  			<td></td>
  			<td>Grand Total : </td>
  			<td>${totalAmountToPay}</td>
  		</tr>
  		<tr>
  			<td></td>
  			<td></td>
  			<td><a href="${contextRoot}/addToCart/makePayment" class="btn btn-primary">Go To Cart</a></td>
  			<td><a href="${contextRoot}/addToCart/confirmOrder" class="btn btn-primary">Confirm Order</a></td>
  		</tr>
  </tbody>
</table>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
