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
		<h1>
			<jstl:out value="${row.amount}" />&nbsp;
		</h1>
	</div>
	
	<input type="button" name="modify" 
		value=" <spring:message code="fee.edit" />"
	onclick="javascript: window.location.replace('fee/administrator/edit.do?feeId=${row.id}')" />
	&nbsp;

	<acme:cancel code="fee.cancel" url ="welcome/index.do"/>