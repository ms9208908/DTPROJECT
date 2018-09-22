<!-- navbar -->
<!-- jsp include will include the contents at runtime...will not copy like include directive -->
 <jsp:include page="./shared/navbar.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="springs" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<div class="container">

<div style="color:red">${msg}</div>
<br/>
	<h1>Add Category</h1>
	<springs:form action="${contextRoot}/admin/addCategory" method="post" modelAttribute="categoryObj">
  	<div class="form-group">
    <label for="productName">Category Name:</label>
    <springs:input type="text" class="form-control" path="categoryName"/>
  	</div>
    
   <button type="submit" class="btn btn-default">Add Category</button>
</springs:form>
</div>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
