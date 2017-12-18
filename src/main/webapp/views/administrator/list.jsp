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
	
	<display:table name = "lessors" id = "row" requestURI = "${requestURI}" pagesize = "5" class = "displaytag" >
				
		<spring:message code = "lessor.name" var = "lessorHeader" />
		<display:column property = "name" title = "${lessorHeader}" />

		<display:column>
			<a href="administrator/dashboardLessor.do?lessorId=${row.id}">
				<spring:message code="lessor.dashboard" />
			</a>
		</display:column>

	</display:table>