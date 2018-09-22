<!-- navbar -->
<!-- jsp include will include the contents at runtime...will not copy like include directive -->
 <jsp:include page="./shared/navbar.jsp"/>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<div class="container">

<div style="color:red">${msg}</div>
<br/>
	<h1>Add Product</h1>
	<form:form action="addProduct" method="post"
	 enctype="multipart/form-data" modelAttribute="productObj">
  	<div class="form-group">
    <label for="productName">Product Name:</label>
    <form:input type="text" class="form-control" path="productName"/>
  	</div>
  <div class="form-group">
    <label for="description">Description:</label>
    <form:input type="text" class="form-control" path="description"/>
  </div>
  <div class="form-group">
    <label for="price">Price:</label>
    <form:input type="text" class="form-control" path="price"/>
  </div>
  <div class="form-group">
    <label for="quantity">Quantity:</label>
    <form:input type="text" class="form-control" path="quantity"/>
  </div>

  <div class="form-group">
  	<label for="category">Category:</label>
  	<form:select name="category" class="form-control" path="categoryId">
  		<form:option value="0">---------Select Category-----------------</form:option>
  		<c:forEach items="${categoryList}" var="categoryObj">
  		<form:option value="${categoryObj.categoryId}">${categoryObj.categoryName}</form:option>
  		</c:forEach>
  	</form:select>
  </div>
  
    <div class="form-group">
  	<label for="supplier">Supplier:</label>
  	<form:select name="supplier" class="form-control" path="supplierId">
  		<option value="0">---------Select Supplier-----------------</option>
  		<c:forEach items="${supplierList}" var="supplierObj">
  		<option value="${supplierObj.supplierId}">${supplierObj.supplierName}</option>
  		</c:forEach>
  	</form:select>
  </div>
  
  	 <div class="form-group">
			<label  for="pimage">Upload New Image :  </label>
			<form:input  type="file"
			 class="form-control" 
			 id="file" placeholder="Upload Product Image" path="pimage"/>
	</div>	
  
  
   <button type="submit" class="btn btn-default">Add Product</button>
</form:form>
</div>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
