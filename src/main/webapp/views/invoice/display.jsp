<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<b><spring:message code="invoice.vatNumber"/></b><jstl:out value="~${invoice.vatNumber }"/>
<br/>
<b><spring:message code="invoice.createMoment"/></b><jstl:out value="~${invoice.createMoment }"/>
<br/>
<b><spring:message code="invoice.information"/></b><jstl:out value="~${invoice.information }"/>
<br/>
<b><spring:message code="invoice.details"/></b><jstl:out value="~${invoice.details }"/>
<br/>
<b><spring:message code="invoice.amount"/></b><jstl:out value="~${invoice.amount }"/>