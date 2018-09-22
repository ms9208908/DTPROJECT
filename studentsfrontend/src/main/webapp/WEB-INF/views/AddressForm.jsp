<!-- navbar -->
<!-- jsp include will include the contents at runtime...will not copy like include directive -->
 <jsp:include page="./shared/navbar.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="springs" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<div class="container">

<div style="color:red">${msg}</div>
<br/>
	<h1>Address Form</h1>
	<springs:form action="${contextRoot}/addToCart/addAddress" method="post" modelAttribute="addressObj">
  	<div class="form-group">
    <label for="houseNumber">House Number:</label>
    <springs:input type="text" class="form-control" path="houseNumber"/>
  	</div>
    <div class="form-group">
    <label for="locality">Locality:</label>
    <springs:input type="text" class="form-control" path="locality"/>
  	</div>
  	<div class="form-group">
    <label for="city">City:</label>
    <springs:input type="text" class="form-control" path="city"/>
  	</div>
  	<div class="form-group">
    <label for="state">State:</label>
    <springs:input type="text" class="form-control" path="state"/>
  	</div>
  	<div class="form-group">
    <label for="pinCode">Pincode:</label>
    <springs:input type="text" class="form-control" path="pinCode"/>
  	</div>
   <button type="submit" class="btn btn-default">Add Address</button>
</springs:form>
</div>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
