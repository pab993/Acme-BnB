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


<form:form action="attributeName/edit.do" modelAttribute="attributeName">
	
	<form:hidden path="id" />
	<form:hidden path="version" />
	<acme:textarea code="attributeName.name" path="name"/>
	
	<acme:submit name="save" code="attributeName.submit"/>
	<jstl:if test="${attributeName.id != 0}">
		<acme:submit name="delete" code="attributeName.delete" />
	</jstl:if>
	<acme:cancel code="attributeName.cancel" url ="attributeName/list.do"/>
	
</form:form>