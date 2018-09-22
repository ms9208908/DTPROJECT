<!-- navbar -->
<!-- jsp include will include the contents at runtime...will not copy like include directive -->
 <jsp:include page="./shared/navbar.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="springs" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<div class="container">

<div style="color:red">${msg}</div>
<br/>
	<h1>Payment Page</h1>
	<springs:form action="${contextRoot}/addToCart/processOrder" method="post" modelAttribute="orderObj">
  	
  	<div class="form-group">
    <label for="cardNumber">cardNumber:</label>
    <springs:input type="text" class="form-control" path="cardNumber"/>
  	</div>
    
    <div>
    <label for="nameOnCard">cardNumber:</label>
    <springs:input type="text" class="form-control" path="nameOnCard"/>
  	</div>
  	
  	<div>
  	<label for="expiryDate">Expiry Date:</label>
    <springs:input type="text"  path="month" class="form-control input-sm"/>
    <springs:input type="text"  path="year" class="form-control input-sm"/>
  	</div>
  	
  	<div>
  		<label for="cvv">cvv:</label>
    	<springs:input type="text" class="form-control" path="cvv"/>
    </div>
    
    <div>
  		<label for="totalPrice">totalPrice:</label>
    	<springs:input type="text" class="form-control" path="totalPrice"/>
    </div>
   <button type="submit" class="btn btn-default">Add Supplier</button>
</springs:form>
</div>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
