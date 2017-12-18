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


<form:form action="booking/lessor/editStatus.do" modelAttribute="booking">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="checkIn" />
	<form:hidden path="checkOut" />
	<form:hidden path="smoker" />
	
	<form:hidden path="invoice" />
	<form:hidden path="tenant" />
	<form:hidden path="property" />

	<security:authorize access="hasRole('LESSOR')">
		<div>
			<%-- <acme:textbox code="choose" path="status"/> --%>
			<form:select path="status" itemLabel="status" code="choose">
				<option value="PENDING">PENDING</option>
				<option value="ACCEPTED">ACCEPTED</option>
				<option value="DENIED">DENIED</option>
			</form:select>
		</div>
	</security:authorize>	
		
	<br />
	<br />

	<div id="botones">

		<acme:submit code="booking.submit" name="save" />
		<acme:cancel code="booking.cancel" url="welcome/index.do" />

	</div>

</form:form>