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
	
	<display:table name = "attributeNames" id = "row" requestURI = "${requestURI}" pagesize = "5" class = "displaytag" >
		
		<spring:message code = "attributeName.name" var = "nameHeader" />
		<display:column property = "name" title = "${nameHeader}" />
		
		<security:authorize access="hasRole('ADMINISTRATOR')">
			<display:column>
				<a href="attributeName/edit.do?attributeNameId=${row.id }">
					<spring:message code="attributeName.edit" />
				</a>
			</display:column>
		</security:authorize>

	</display:table>
	
	<!-- Action Links -->
	
	<security:authorize access="hasRole('ADMINISTRATOR')">
		<div>
			<a href="attributeName/create.do"><spring:message code="attributeName.create"/></a>
		</div>
	</security:authorize>