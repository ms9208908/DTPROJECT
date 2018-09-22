<!-- navbar -->
<!-- jsp include will include the contents at runtime...will not copy like include directive -->
 <jsp:include page="./shared/navbar.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="springs" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<div class="container">

<div style="color:red">${msg}</div>
<br/>
	<h1>Add Supplier</h1>
	<springs:form action="${contextRoot}/admin/addSupplier" method="post" modelAttribute="supplierObj">
  	<div class="form-group">
    <label for="productName">Supplier Name:</label>
    <springs:input type="text" class="form-control" path="supplierName"/>
  	</div>
    
   <button type="submit" class="btn btn-default">Add Supplier</button>
</springs:form>
</div>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
