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


<form:form action="audit/auditor/edit.do" modelAttribute="audit">
	
	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="draft" />
	<form:hidden path="createMoment" />
	
	
	<form:hidden path="auditor" />
	<form:hidden path="property" />
	
	
	<acme:textbox code="audit.text" path="text"/>
	<br />
	
	<acme:textarea code="audit.attachments" path="attachments"/>
	<br />
	
	<acme:submit name="save" code="audit.submit"/>
	<jstl:if test="${audit.id != 0}">
		<acme:submit name="delete" code="audit.delete"  />
	</jstl:if>
	<acme:cancel code="audit.cancel" url ="audit/auditor/listDraft.do"/>
	
</form:form>