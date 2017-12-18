<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

		
	<!-- Listing table -->

	<div>
		<h2>
			<jstl:out value="${amount}" />&nbsp;
		</h2>
	</div>
	
	<fieldset > 
	<legend> <b> <spring:message code="bookings.accepted" /> </b> </legend>
		
		<display:table name = "bookings" id = "row" requestURI = "${requestURI}" pagesize = "5" class = "displaytag" >
			
			<spring:message code = "booking.checkIn" var = "checkInHeader" />
			<display:column property = "checkIn" title = "${checkInHeader}" 
				format="{0,date,dd/MM/yyyy HH:mm}"/>
			
			<spring:message code = "booking.checkOut" var = "checkOutHeader" />
			<display:column property = "checkOut" title = "${checkOutHeader}" 
				format="{0,date,dd/MM/yyyy HH:mm}"/>
			
			<spring:message code = "booking.smoker" var = "smokerHeader" />
			<display:column property = "smoker" title = "${smokerHeader}" />
		
			<spring:message code="booking.status" var="statusHeader" />
			<display:column property="status" title="${statusHeader}" />
			
		</display:table>
	
	</fieldset>
	
	<br />
	
	<acme:cancel code="lessor.cancel" url ="welcome/index.do"/>