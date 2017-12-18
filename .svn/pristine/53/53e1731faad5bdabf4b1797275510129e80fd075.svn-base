<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<form:form action="tenant/register.do" modelAttribute="tenantForm">
	
	<fieldset > 
	<form:checkbox path="check"/>
	<form:label path="check">
		<spring:message code="tenant.accept" />
		<a href="termAndCondition/termAndCondition.do"><spring:message code="tenant.lopd"/></a>
	</form:label>
	
		<legend> <spring:message code="datos.personal" /> </legend>
		
			<acme:textbox code="tenant.name" path="name"/>
			<br />

			<acme:textbox code="tenant.surname" path="surname"/>
			<br />
			
			<acme:textbox code="tenant.phone" path="phone"/>
			<br />
			
			<acme:textbox code="tenant.email" path="email"/>
			<br />
			
			<acme:textbox code="tenant.picture" path="picture"/>
			<br />
			
			<acme:textbox code="tenant.userAccount" path="username"/>
			<br />
			
			<acme:password code="tenant.password" path="password"/>
			<br />
			
			<acme:password code="tenant.repeatPassword" path="repeatPassword"/>
				
	</fieldset>
	<br />
	<br />
	
	
	<div id="botones" > 

		<acme:submit code="tenant.save" name="save"/>
		<acme:cancel code="tenant.cancel" url ="welcome/index.do"/>

	</div> 

</form:form>