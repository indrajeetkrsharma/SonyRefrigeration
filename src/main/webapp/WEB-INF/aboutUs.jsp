<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored = "false" %>
<%@ page session="false"%>
<jsp:include page="header.jsp" />
<div class="footer-container">

<div id="htmlcontent_top" class="container">
<ul class="htmlcontent-home clearfix row">
<form:form id="tmsearchbox"  modelAttribute="userForm" method="post" action="submitContactUsFormPage.html">
<li class="htmlcontent-item-1 col-xs-6 col-md-6 col-lg-4">
<p>Sony Refrigeration founded in 1985 in Bokaro steel City. We are primarily providing air condition repair service and maintenance to help you beat the heat in India during
 months of summer. Our mission is provide best Air Conditioning services in Bokaro Steel City Jharkhand. 
 </p>
<p>We are providing the following repairing, maintenance services in Bokaro Steel City Jharkhand for below mentioned product keywords : 
AC , Air Condition, Air Conditioner, Deep Freezer, Central AC, Freez, Cooler, Washing Machine, Fan, Ovan, Compressor, Invertor.
Brand Names : LG, Samsung, Daikin, Voltas, Blue Star, Ken Star, Bajaj, Hitachi, Onida, Kelvinator, Symphony. 
</p>

</li>
<li class="htmlcontent-item-2 col-xs-6 col-md-6 col-lg-4">
	
<h3 class="item-title">Address</h3>
<p>
Sony Refrigeration
<br/>
Kurmidih Market, Bokaro Steel city-10
<br/>
Opposite Ajit Medical Hall.
<br/>
District : Bokaro
<br/>
State : Jharkhand
<br/>
Pin code : 827010
<br/>
Contact Number : 9234398714
</p>
</li>


</ul>
<br/>
<br/>
</form:form>

</div>

<div id="homegooglemap" class="clearfix">
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script><div style="overflow:hidden;height:500px;width:1350px;"><div id="gmap_canvas" style="height:500px;width:1350px;"><style>#gmap_canvas img{max-width:none!important;background:none!important}</style><a class="google-map-code" href="http://wordpress-themes.org" id="get-map-data">wordpress themes</a></div></div><script type="text/javascript"> function init_map(){var myOptions = {zoom:12,center:new google.maps.LatLng(23.66310242555798,86.07901690388871),mapTypeId: google.maps.MapTypeId.ROADMAP};map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(23.66310242555798, 86.07901690388871)});infowindow = new google.maps.InfoWindow({content:"<b>Sony Refrigeration</b><br/>Kurmidih market, Bokaro Steel City-10, Jharkhand. Mobile : 9234398714, PinCode : <br/>827010 " });google.maps.event.addListener(marker, "click", function(){infowindow.open(map,marker);});infowindow.open(map,marker);}google.maps.event.addDomListener(window, 'load', init_map);</script>
</div><div class="bottom-footer container">
<div class="row">
<div class="col-xs-12">
<div>

</div>
</div>
</div>
</div></div> 
<jsp:include page="footer.jsp" />