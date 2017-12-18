<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<h1><jstl:out value="${lessor.name}"/></h1>

<security:authorize access="hasRole('ADMINISTRATOR')">
		<div>
			<fieldset><legend class="dashboardLegend"><spring:message code="administrator.dashboard.property.audits" /></legend>
			<display:table name="propertiesAudits" id="row" class="displaytag" pagesize="5" requestURI="${requestURI}" >							
				<spring:message code="property.name" var="nameHeader" />
				<display:column property="name" title="${nameHeader}" />
				
				<spring:message code="property.rate" var="rateHeader" />
				<display:column property="rate" title="${rateHeader}" />
				
				<spring:message code="property.description" var="descriptionHeader" />
				<display:column property="description" title="${descriptionHeader}" />
				
				<spring:message code="property.address" var="addressHeader"/>
				<display:column property="address" title="${addressHeader}" />
			</display:table>
			</fieldset>
		</div>
		
		<div>
			<fieldset><legend class="dashboardLegend"><spring:message code="administrator.dashboard.property.bookings" /></legend>
			<display:table name="propertiesBookings" id="row" class="displaytag" pagesize="5" requestURI="${requestURI}" >							
				<spring:message code="property.name" var="nameHeader" />
				<display:column property="name" title="${nameHeader}" />
				
				<spring:message code="property.rate" var="rateHeader" />
				<display:column property="rate" title="${rateHeader}" />
				
				<spring:message code="property.description" var="descriptionHeader" />
				<display:column property="description" title="${descriptionHeader}" />
				
				<spring:message code="property.address" var="addressHeader"/>
				<display:column property="address" title="${addressHeader}" />
			</display:table>
			</fieldset>
		</div>
		
		<div>
			<fieldset><legend class="dashboardLegend"><spring:message code="administrator.dashboard.property.bookings.accepted" /></legend>
			<display:table name="propertiesAcceptedBookings" id="row" class="displaytag" pagesize="5" requestURI="${requestURI}" >							
				<spring:message code="property.name" var="nameHeader" />
				<display:column property="name" title="${nameHeader}" />
				
				<spring:message code="property.rate" var="rateHeader" />
				<display:column property="rate" title="${rateHeader}" />
				
				<spring:message code="property.description" var="descriptionHeader" />
				<display:column property="description" title="${descriptionHeader}" />
				
				<spring:message code="property.address" var="addressHeader"/>
				<display:column property="address" title="${addressHeader}" />
			</display:table>
			</fieldset>
		</div>
		
		<div>
			<fieldset><legend class="dashboardLegend"><spring:message code="administrator.dashboard.property.bookings.pending" /></legend>
			<display:table name="propertiesPendingBookings" id="row" class="displaytag" pagesize="5" requestURI="${requestURI}" >							
				<spring:message code="property.name" var="nameHeader" />
				<display:column property="name" title="${nameHeader}" />
				
				<spring:message code="property.rate" var="rateHeader" />
				<display:column property="rate" title="${rateHeader}" />
				
				<spring:message code="property.description" var="descriptionHeader" />
				<display:column property="description" title="${descriptionHeader}" />
				
				<spring:message code="property.address" var="addressHeader"/>
				<display:column property="address" title="${addressHeader}" />
			</display:table>
			</fieldset>
		</div>
		
		<div>
			<fieldset><legend class="dashboardLegend"><spring:message code="administrator.dashboard.property.bookings.denied" /></legend>
			<display:table name="propertiesDeniedBookings" id="row" class="displaytag" pagesize="5" requestURI="${requestURI}" >							
				<spring:message code="property.name" var="nameHeader" />
				<display:column property="name" title="${nameHeader}" />
				
				<spring:message code="property.rate" var="rateHeader" />
				<display:column property="rate" title="${rateHeader}" />
				
				<spring:message code="property.description" var="descriptionHeader" />
				<display:column property="description" title="${descriptionHeader}" />
				
				<spring:message code="property.address" var="addressHeader"/>
				<display:column property="address" title="${addressHeader}" />
			</display:table>
			</fieldset>
		</div> 
</security:authorize>