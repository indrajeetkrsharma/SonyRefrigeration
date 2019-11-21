<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored = "false" %>
<%@ page session="false"%>
<jsp:include page="header.jsp" />
<div class="footer-container">
<div id="htmlcontent_top" class="container">
<h3 class="item-title">We are providing following trainings :</h3>
<ul class="htmlcontent-home clearfix row">
<form:form id="tmsearchbox"  modelAttribute="userForm" method="post" action="submitContactUsFormPage.html">

<li class="htmlcontent-item-1 col-xs-6 col-md-6 col-lg-4">

<ul style="list-style-type:disc">
  <li>Central AC</li>
  <li>Split AC</li>
  <li>Window AC</li>
  <li>Ice Cream Factory Refrigeration</li>
  <li>Single door Refrigerator</li>
  <li>Double door Refrigerator</li>

  
</ul>

</li>
<li class="htmlcontent-item-2 col-xs-6 col-md-6 col-lg-4">
<ul style="list-style-type:disc">

  <li>Bottel Cooler</li>
  <li>Air Cooler</li>
  <li>Washing Machine</li>
  <li>Fan</li>
	<li>Mixy</li>
	</ul>
</li>


</ul>
<br/>
<br/>
</form:form>

</div>
</div>
<!-- 
<div style="width: 1349px; margin-left: -675px; left: 50.05%;" data-type-media="image" class="parallax_section" id="tmhtmlcontent_topColumn1">
<div class="container parallax_content">
<ul class="tmhtmlcontent-topColumn clearfix row">
<li class="tmhtmlcontent-item-1 col-xs-6">
<br/>
<br/>
<br/>
<h3 class="item-title">We are providing following training :</h3>
<div class="item-html">
<ul style="list-style-type:disc">
  <li>Central AC</li>
  <li>Split AC</li>
  <li>Window AC</li>
  <li>Ice Cream Factory Refrigeration</li>
  <li>Single door Refrigerator</li>
  <li>Double door Refrigerator</li>
  <li>Bottel Cooler</li>
  <li>Air Cooler</li>
  <li>Washing Machine</li>
  <li>Fan</li>
  <li>Mixy</li>
</ul>
<button class="btn btn-default">CONTACT US</button>
</div>
</li>
<li class="tmhtmlcontent-item-1 col-xs-6">
<br/>
<br/>
<br/>


</li>
</ul>
</div><div style="height: 1183.5px;" class="parallax_inner">

</div></div>
 -->
<jsp:include page="footer.jsp" />