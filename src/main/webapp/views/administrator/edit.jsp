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

<!-- Edit lessor -->

<form:form action="administrator/administrator/edit.do" modelAttribute="administrator">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<fieldset >
		<legend> <b> <spring:message code="datos.personal" /></b> </legend>

		<acme:textbox code="administrator.name" path="name"/>
		<br />
		
		<acme:textbox code="administrator.surname" path="surname"/>
		<br />
		
		<acme:textbox code="administrator.phone" path="phone"/>
		<br />
	
		<acme:textbox code="administrator.email" path="email"/>
		<br />
		
		<acme:textbox code="administrator.picture" path="picture"/>

	</fieldset>

	<br />
	
	<acme:submit name="save" code="administrator.submit"/>
	<acme:cancel url="welcome/index.do" code="administrator.cancel"/>
	
</form:form>

<fieldset > 
		<legend> <b> <spring:message code="datos.socialIdentity" /> </b> </legend>
		
		<display:table name = "socialIdentities" id = "row" requestURI = "${requestURI}" pagesize = "5" class = "displaytag" >
		
			<spring:message code="socialIdentity.nick" var="nickHeader" />
			<display:column title="${nickHeader }" property="nick" />
		
			<spring:message code="socialIdentity.network" var="netowrkHeader" />
			<display:column title="${netowrkHeader }" property="network" />
		
			<spring:message code="socialIdentity.url" var="urlHeader" />
			<display:column title="${urlHeader }" property="url" />
		
			<display:column>
				<a href="socialIdentity/delete.do?idSocialIdentity=${row.id }"> <img height="20" width="20" src="images/delete.png" /> </a>
			</display:column>
			<display:column>
				<a href="socialIdentity/edit.do?idSocialIdentity=${row.id }"> <img height="20" width="20" src="images/edit.png" /> </a>
				
			</display:column>
		
		</display:table>
		
		<a href="socialIdentity/create.do"> <img height="30" width="30" src="images/add.png" /></a>
		
</fieldset>