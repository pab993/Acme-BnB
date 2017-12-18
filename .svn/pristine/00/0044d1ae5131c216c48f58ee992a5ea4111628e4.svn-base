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
	
	<display:table name = "properties" id = "row" requestURI = "${requestURI}" pagesize = "3" class = "displaytag" >
		
		<spring:message code = "property.name" var = "nameHeader" />
		<display:column property = "name" title = "${nameHeader}" />
		
		<spring:message code = "property.rate" var = "rateHeader" />
		<display:column property = "rate" title = "${rateHeader}" />
	
		<spring:message code="property.description" var="descriptionHeader" />
		<display:column property="description" title="${descriptionHeader}" />
	
		<spring:message code="property.address" var="addressHeader" />
		<display:column property="address" title="${addressHeader}" />
		
		<spring:message code="property.lessor" var="lessorHeader"/>
		<display:column>
			<a href="lessor/display.do?customerId=${row.lessor.id}">
				<spring:message code="property.lessor" />
			</a>
		</display:column>
		
		<security:authorize access="hasRole('LESSOR')">
			<display:column>
				<jstl:if test="${row.lessor == lessor }">
					<a href="property/edit.do?propertyId=${row.id }">
						<spring:message code="property.edit" />
					</a>
				</jstl:if>
			</display:column>
		</security:authorize>
		
		<security:authorize access="hasRole('LESSOR')">
			<jstl:choose>
				<jstl:when test="${owner}">
					<display:column>
						<a href="booking/lessor/list.do?propertyId=${row.id}">
							<spring:message code="property.listBookings" />
						</a>
					</display:column>
				</jstl:when>
			</jstl:choose>
		</security:authorize>
		
		<security:authorize access="isAuthenticated()" >
			<display:column>
				<a href="audit/list.do?propertyId=${row.id}">
					<spring:message code="property.listAudits" />
				</a>
			</display:column>
		</security:authorize>
				
		<security:authorize access="hasRole('AUDITOR')" >
			<display:column>
				<a href="audit/auditor/create.do?propertyId=${row.id}">
					<spring:message code="property.newAudit" />
				</a>
			</display:column>
		</security:authorize>
		
		<security:authorize access="hasRole('TENANT')" >
			<display:column>
				<a href="booking/tenant/create.do?propertyId=${row.id}">
					<spring:message code="property.newBooking" />
				</a>
			</display:column>
		</security:authorize>

		<security:authorize access="hasRole('LESSOR')">
		<jstl:if test="${row.lessor == lessor }">
			<display:column>
					<a href="attributeValue/list.do?propertyId=${row.id }">
						<spring:message code="property.attributeValue.list" />
					</a>
			</display:column>
		</jstl:if>
		</security:authorize>
		
		<spring:message code = "property.bookCount" var = "countHeader" />
		<display:column property = "bookCount" title = "${countHeader}" sortable="true"/>	
			
	
	</display:table>
	
	
	<security:authorize access="hasRole('LESSOR')">
		<div>
			<a href="property/create.do"><spring:message code="property.create"/></a>
		</div>
	</security:authorize>
	<acme:cancel code="property.cancel" url ="welcome/index.do"/>