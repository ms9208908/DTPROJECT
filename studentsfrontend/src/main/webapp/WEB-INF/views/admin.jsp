 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

  <c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
<spring:url var="images" value="/resources/images"/>

<jsp:include page="./shared/navbar.jsp"></jsp:include>


<!-- Contents --> 

<div class="container">
<div class="rows">
<div class="col-md-4">
<div class="thumbnail" align="center">
<div><a href="getProductPage"><h5>PRODUCT</h5></div>
</div>
</div>
</div>


<div class="col-md-4">
<div class="thumbnail" align="center">
<div><a href="${contextRoot}/admin/getCategoryPage"><h5>CATEGORY</h5></div>
</div>

</div>



<div class="col-md-4">
<div class="thumbnail" align="center">
<div><a href="${contextRoot}/admin/getSupplierPage""><h5>SUPPLIER</h5></div>
</div>
</div>
</div>

</div>
</div>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>


<jsp:include page="./shared/footer.jsp"></jsp:include>


