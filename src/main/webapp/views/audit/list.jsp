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
	
	<display:table name = "audits" id = "row" requestURI = "${requestURI}" pagesize = "5" class = "displaytag" >
		
		<spring:message code = "audit.createMoment" var = "createMomentHeader" />
		<display:column property = "createMoment" title = "${createMomentHeader}" 
			format="{0,date,dd/MM/yyyy HH:mm}"/>
		
		<spring:message code = "audit.text" var = "textHeader" />
		<display:column property = "text" title = "${textHeader}" />
	
		<spring:message code="audit.attachments" var="attachmentsHeader" />
		<display:column property="attachments" title="${attachmentsHeader}" />
		
		<spring:message code="audit.property" var="propertyHeader" />
		<display:column property="property.name" title="${propertyHeader}" />

		<security:authorize access="hasRole('AUDITOR')" >
			<jstl:choose>
				<jstl:when test="${owner}">
					<display:column>
						<a href="audit/auditor/edit.do?auditId=${row.id}">
							<spring:message code="audit.edit" />
						</a>
					</display:column>
				</jstl:when>
			</jstl:choose>
			
			<jstl:if test="${draft == 1}">	
				<display:column>
						<a href="audit/auditor/notDraft.do?auditId=${row.id}" 
						onclick="return confirm('<spring:message code = "audit.confirm.notDraft"/>')">
							<spring:message code="audit.notDraft" />
						</a>
				</display:column>
			</jstl:if>
		</security:authorize>
		
	</display:table>
	
	<acme:cancel code="audit.cancel" url ="welcome/index.do"/>