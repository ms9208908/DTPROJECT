<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
<spring:url var="images" value="/resources/images"/>
 

<!-- navbar -->
<!-- jsp include will include the contents at runtime...will not copy like include directive -->
 <jsp:include page="./shared/navbar.jsp"></jsp:include>

 
	<sec:authorize access="hasAuthority('ADMIN')">
		<jsp:forward page="/admin"/>
	</sec:authorize>


<div class="container" style="margin-top: 20px">
<div class="rows">
<div class="col-md-12">

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/BlackHandbag.jpg" style="height:300px;width:250px">
<h5>Black Handbag</h5>
<p align="left">Rs.1500 (50%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/BrownHandbag.jpg" style="height:300px;width:250px">
<h5>Brown Handbag</h5>
<p align="left">Rs.2000 (20%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/clutch2.jpg" style="height:300px;width:250px">
<h5>Golden Clutch</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images }/JFCBag1.jpg" style="height:300px;width:250px">
<h5>Black Handbag with Pouch</h5>
<p align="left">Rs.980 (50%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>
 </br>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/LaptopBag1.jpg" style="height:300px;width:250px">
<h5>Brown Laptop Bag</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/LaptopBag2.jpg" style="height:300px;width:250px">
<h5>Black Laptop Bag</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>


<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/PinkClutch1.jpg" style="height:300px;width:250px">
<h5>Pink Clutch</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/clutch2.jpg" style="height:300px;width:250px">
<h5>Golden Clutch</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>
</br>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images }/Bag4.jpg" style="height:300px;width:250px">
<h5>Sling Bags</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images }/Bag5.jpg" style="height:300px;width:250px">
<h5>Checked Handbag</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images }/Bag6.jpg" style="height:300px;width:250px">
<h5>White Grey handbag</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/Bag7.jpg" style="height:300px;width:250px">
<h5>Blue Handbag</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>
</div>
</div>
</div>

<jsp:include page="./shared/footer.jsp"></jsp:include>

