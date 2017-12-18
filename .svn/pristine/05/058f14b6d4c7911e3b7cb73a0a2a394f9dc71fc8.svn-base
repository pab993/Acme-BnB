<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

		
	<!-- Listing table -->
	
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
		
		<security:authorize access="hasRole('LESSOR')" >
		<display:column>
			<jstl:choose>
				<jstl:when test="${row.status == 'PENDING' }">
					<a href="booking/lessor/editStatus.do?bookingId=${row.id}"><spring:message code="booking.status.change" /></a>
				</jstl:when>
				<jstl:otherwise>
					--
				</jstl:otherwise>
			</jstl:choose>
		</display:column>
		</security:authorize>
		
		<spring:message code="booking.tenant" var="tenantHeader"/>
		<display:column property="tenant.userAccount.username" 
		href="lessor/display.do?customerId=${row.tenant.id }" title="${tenantHeader}"/>
		
		<spring:message code="booking.lessor" var="lessorHeader"/>
		<display:column property="property.lessor.userAccount.username" 
		href="lessor/display.do?customerId=${row.property.lessor.id }" title="${lessorHeader}"/>
		
		<security:authorize access="hasRole('TENANT')" >
		<spring:message code="booking.invoices" var="invoicesHeader"></spring:message>
		 <display:column title="${invoicesHeader }">
					
			<jstl:choose>
			
				<jstl:when test="${empty row.invoice && row.status == 'ACCEPTED' }">
					<a href="invoice/tenant/create.do?bookingId=${row.id }"> <spring:message code="booking.requestInvoice" /> </a>
				
				</jstl:when>
				
				<jstl:when test="${row.status != 'ACCEPTED' }">
					--
				</jstl:when>
				
				<jstl:otherwise>
					<a href="invoice/tenant/display.do?invoiceId=${row.invoice.id }" > <spring:message code="booking.invoice" /> </a>
				</jstl:otherwise>
			
			</jstl:choose> 
		
		</display:column> 
		</security:authorize>

	</display:table>