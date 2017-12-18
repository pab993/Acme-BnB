<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<form:form action="auditor/register.do" modelAttribute="auditorForm">
	
	<fieldset > 
	
		<legend> <spring:message code="datos.personal" /> </legend>
		
			<acme:textbox code="auditor.name" path="name"/>
			<br />
			
			<acme:textbox code="auditor.surname" path="surname"/>
			<br />
			
			<acme:textbox code="auditor.phone" path="phone"/>
			<br />
			
			<acme:textbox code="auditor.email" path="email"/>
			<br />
			
			<acme:textbox code="auditor.picture" path="picture"/>
			<br />
			
			<acme:textbox code="auditor.company" path="company"/>
			<br />
			
			<acme:textbox code="auditor.userAccount" path="username"/>
			<br />
			
			<acme:password code="auditor.password" path="password"/>
			<br />
			
			<acme:password code="auditor.repeatPassword" path="repeatPassword"/>
		
	</fieldset>
	
	<br />
	
	<div id="botones" > 

		<acme:submit code="auditor.save" name="save"/>
		<acme:cancel code="auditor.cancel" url ="welcome/index.do"/>

	</div> 

</form:form>