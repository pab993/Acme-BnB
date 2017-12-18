<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<form:form action="finder/search.do" modelAttribute="finder">
	
	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="searchMoment"/>
	<form:hidden path="tenant"/>
	<form:hidden path="results"/>
	
	<acme:textbox code="finder.destination" path="destination"/>
	<br />
	
	<acme:textbox code="finder.minPrice" path="minPrice"/>
	<br />
	
	<acme:textbox code="finder.maxPrice" path="maxPrice"/>
	<br />
	
	<acme:textbox code="finder.keyword" path="keyword"/>
	<br />
	
	<acme:submit code="finder.search" name="search"/>

</form:form>

	<br />

	<display:table name = "properties" id = "row" requestURI = "${requestURI}" pagesize = "5" class = "displaytag" >
		
		<spring:message code = "property.name" var = "nameHeader" />
		<display:column property = "name" title = "${nameHeader}" />
		
		<spring:message code = "property.rate" var = "rateHeader" />
		<display:column property = "rate" title = "${rateHeader}" />
	
		<spring:message code="property.description" var="descriptionHeader" />
		<display:column property="description" title="${descriptionHeader}" />
	
		<spring:message code="property.address" var="addressHeader" />
		<display:column property="address" title="${addressHeader}" />
		
		<spring:message code="property.bookCount" var="bookCountHeader" />
		<display:column property="bookCount" title="${bookCountHeader}" sortable="true"/>
		
		<security:authorize access="hasRole('TENANT')" >
			<display:column>
				<a href="booking/tenant/create.do?propertyId=${row.id}">
					<spring:message code="property.newBooking" />
				</a>
			</display:column>
		</security:authorize>

	</display:table>