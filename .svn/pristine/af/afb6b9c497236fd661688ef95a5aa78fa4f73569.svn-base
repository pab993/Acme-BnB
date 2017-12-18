<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- Display lessor -->





<h3><spring:message code="lessor.name"/></h3>
<jstl:out value="${lessor.getName()}"/>

<h3><spring:message code="lessor.surname"/></h3>
<jstl:out value="${lessor.getSurname()}"/>

<h3><spring:message code="lessor.phone" /></h3>
<jstl:out value="${lessor.getPhone()}"/>

<h3><spring:message code="lessor.email" /></h3>
<jstl:out value="${lessor.getEmail()}"/>

<h3><spring:message code="lessor.picture" /></h3>
<img height="65" width="65" src="${lessor.getPicture()}" />



<c:if test="${canComment}"><h3><a href="comment/postComment.do?customerId=${lessor.id }"> 
	<spring:message code="postComment" />
 </a></h3>
 </c:if>

 <display:table name = "comments" id = "row" requestURI = "${requestURI}" pagesize = "5" class = "displaytag" >
		
		<spring:message code = "comment.title" var = "titleHeader" />
		<display:column property = "title" title = "${titleHeader}" />
		
		<spring:message code = "comment.text" var = "textHeader" />
		<display:column property = "text" title = "${textHeader}" />
	
		<spring:message code="comment.stars" var="starsHeader" />
		<display:column property="stars" title="${starsHeader}" />
		
		<spring:message code="comment.userName" var="userNameHeader" />
		<display:column   href="lessor/display.do?customerId=${row.customer.id }" 
		property="customer.userAccount.username" 
		title="${userNameHeader}" />
		
	
	</display:table>




