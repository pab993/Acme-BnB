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
	
	<display:table name = "attributeValues" id = "row" requestURI = "${requestURI}" pagesize = "5" class = "displaytag" >
		
		<spring:message code = "attributeValue.name" var = "nameHeader" />
		<display:column property = "attributeName.name" title = "${nameHeader}" />
		
		<spring:message code = "attributeValue.value" var = "valueHeader" />
		<display:column property = "value" title = "${valueHeader}" />
		
		<security:authorize access="hasRole('LESSOR')">
			<display:column>
				<jstl:if test="${row.property.lessor == lessor }">
					<a href="attributeValue/edit.do?attributeValueId=${row.id }">
						<spring:message code="attributeValue.edit" />
					</a>
				</jstl:if>
			</display:column>
		</security:authorize>

	</display:table>
	
	<!-- Action Links -->
	
	<security:authorize access="hasRole('LESSOR')">
		<div>
			<a href="attributeValue/create.do?propertyId=${propertyId }"><spring:message code="attributeValue.create"/></a>
		</div>
	</security:authorize>