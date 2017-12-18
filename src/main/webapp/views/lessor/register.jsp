<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<form:form action="lessor/register.do" modelAttribute="lessorForm">
	
	<fieldset > 
	
		<legend> <spring:message code="datos.personal" /> </legend>
			
			<form:checkbox path="check"/>
	<form:label path="check">
		<spring:message code="lessor.accept" />
		<a href="termAndCondition/termAndCondition.do"><spring:message code="lessor.lopd"/></a>
	</form:label>
			
			<acme:textbox code="lessor.name" path="name"/>
			<br />
			
			<acme:textbox code="lessor.surname" path="surname"/>
			<br />
			
			<acme:textbox code="lessor.phone" path="phone"/>
			<br />
			
			<acme:textbox code="lessor.email" path="email"/>
			<br />
			
			<acme:textbox code="lessor.picture" path="picture"/>
			<br />
		
			<acme:textbox code="lessor.userAccount" path="username"/>
			<br />
		
			<acme:password code="lessor.password" path="password"/>
			<br />
		
			<acme:password code="lessor.repeatPassword" path="repeatPassword"/>
		
	</fieldset>
	
	<br />
	<br />
	
	<fieldset> 
	
		<legend> <spring:message code="datos.creditCard" /> </legend>
	
			<acme:textbox code="lessor.creditCard.holderName" path="creditCard.holderName"/>
			<br />
			
			<acme:textbox code="lessor.creditCard.brandName" path="creditCard.brandName"/>
			<br />
			
			<acme:textbox code="lessor.creditCard.number" path="creditCard.number"/>
			<br />
			
			<acme:textbox code="lessor.creditCard.expirationMonth" path="creditCard.expirationMonth"/>
			<br />
			
			<acme:textbox code="lessor.creditCard.expirationYear" path="creditCard.expirationYear"/>
			<br />
			
			<acme:textbox code="lessor.creditCard.cvv" path="creditCard.CVV"/>
	
	</fieldset>
	
	<br />
	<br />
	
	<div id="botones" > 

		<acme:submit code="lessor.submit" name="save"/>
		<acme:cancel code="lessor.cancel" url ="welcome/index.do"/>

	</div> 

</form:form>