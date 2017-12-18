<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<form:form action="booking/tenant/edit.do" modelAttribute="booking">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="status" />

	<form:hidden path="tenant" />
	<form:hidden path="property" />

	<security:authorize access="hasRole('TENANT')">
		<fieldset>
			<legend>
				<spring:message code="datos.booking" />
			</legend>

			<acme:textbox code="booking.checkIn" path="checkIn" />
			<br />

			<acme:textbox code="booking.checkOut" path="checkOut" />
			<br />

			<acme:textbox code="booking.smoker" path="smoker" />
			<br />

		</fieldset>

		<br />
		<br />

		<fieldset>

			<legend>
				<spring:message code="datos.creditCard" />
			</legend>

			<acme:textbox code="creditCard.holderName"
				path="creditCard.holderName" />
			<br />

			<acme:textbox code="creditCard.brandName" path="creditCard.brandName" />
			<br />

			<acme:textbox code="creditCard.number" path="creditCard.number" />
			<br />

			<acme:textbox code="creditCard.expirationMonth"
				path="creditCard.expirationMonth" />
			<br />

			<acme:textbox code="creditCard.expirationYear"
				path="creditCard.expirationYear" />
			<br />

			<acme:textbox code="creditCard.cvv" path="creditCard.CVV" />

		</fieldset>
	</security:authorize>

	<security:authorize access="hasRole('LESSOR')">
		<div>
			<acme:textbox code="booking.status" path="status"/>
		</div>
	</security:authorize>
		
	<br />
	<br />

	<div id="botones">

		<acme:submit code="booking.submit" name="save" />
		<acme:cancel code="booking.cancel" url="welcome/index.do" />

	</div>

</form:form>