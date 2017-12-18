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


<form:form action="attributeValue/edit.do" modelAttribute="attributeValue">
	
	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="property"/>
	<acme:textarea code="attributeValue.value" path="value"/>
	
	<div>
		<acme:select items="${attributeNames}" itemLabel="name" code="choose" path="attributeName"/>
	</div>
	
	<acme:submit name="save" code="attributeValue.submit"/>
	<jstl:if test="${attributeValue.id != 0}">
		<acme:submit name="delete" code="attributeValue.delete" />
	</jstl:if>
	<acme:cancel code="attributeValue.cancel" url ="attributeValue/list.do?propertyId=${attributeValue.property.id }"/>
	
</form:form>