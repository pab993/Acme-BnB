<%--
 * header.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<img src="images/logo.png" alt="Acme-BnB Co., Inc." />
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<security:authorize access="hasAnyRole('LESSOR','TENANT')">
			<li><a href="lessor/myPerfil.do"><spring:message	code="master.page.myPerfil" /></a></li>
		</security:authorize>	
				
		<security:authorize access="hasRole('ADMINISTRATOR')">
		
			<li><a class="fNiv"><spring:message
						code="master.page.fee" /></a>
				<ul>
					<li class="arrow"></li>

					<li><a href="fee/administrator/showFee.do"><spring:message
								code="master.page.modifyFee" /></a></li>		
				</ul>
			</li>
			
			<li><a class="fNiv" href="attributeName/list.do"><spring:message code="master.page.attributeName.list" /></a></li>
			<li><a class="fNiv" href="administrator/dashboard.do"><spring:message code="master.page.dashboard" /></a></li>
			<li><a class="fNiv" href="administrator/list.do"><spring:message code="master.page.lessor" /></a></li>
		
			<li><a class="fNiv"><spring:message code="master.page.register" /></a>
					<ul>
						<li class="arrow"></li>
						<li><a href="administrator/administrator/edit.do"><spring:message code="master.page.profile.edit" /><img height="15" width="15" src="images/edit.png" /></a></li>
						<li><a href="auditor/register.do"><spring:message code="master.page.auditor.register" /></a></li>
					</ul>
			</li>
			
			<li>
				<a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
				    (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>					
				</ul>
			</li>
		</security:authorize>
		
		
		<security:authorize access="hasRole('LESSOR')">
			<li>
			<a class="fNiv"> 
				<spring:message code="master.page.profile" /> 
			    (<security:authentication property="principal.username" />)
			</a>
			<ul>
				<li class="arrow"></li>	
				<li><a href="property/lessor/list.do"><spring:message	code="master.page.property.lessor" /></a></li>	
				<li><a href="lessor/lessor/showAmount.do"><spring:message	code="master.page.lessor.amount" /></a></li>			
				<li><a href="lessor/lessor/edit.do"><spring:message code="master.page.profile.edit" /><img height="15" width="15" src="images/edit.png" /></a></li>
			</ul>
		</li>
		</security:authorize>
		
		
		<security:authorize access="hasRole('TENANT')">
			<li><a class="fNiv">
				<spring:message	code="master.page.tenant" />
				(<security:authentication property="principal.username" />)
			</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="tenant/tenant/edit.do"><spring:message code="master.page.profile.edit" /> <img height="15" width="15" src="images/edit.png" /> </a></li>
					<li><a href="finder/tenant.do"><spring:message code="master.page.finder.tenant" /></a></li>
					<li><a href="tenant/tenant/listTenant.do"><spring:message	code="master.page.booking.list.tenant" /></a></li>
				</ul>
			</li>
			
		</security:authorize>
		
		<security:authorize access="hasRole('AUDITOR')">
			<li>
			<a class="fNiv"> 
				<spring:message code="master.page.profile" /> 
			    (<security:authentication property="principal.username" />)
			</a>
			<ul>
				<li class="arrow"></li>	
				<li><a href="auditor/auditor/edit.do"><img height="20" width="20" src="images/edit.png" /> <spring:message code="master.page.profile.edit" /></a></li>
				<li><a href="audit/auditor/myList.do"><spring:message	code="master.page.audit.myList" /></a></li>
				<li><a href="audit/auditor/listDraft.do"><spring:message	code="master.page.audit.listDraft" /></a></li>
				<li><a href="audit/auditor/listNotDraft.do"><spring:message	code="master.page.audit.listNotDraft" /></a></li>
			</ul>
		</li>
		</security:authorize>
		
		<security:authorize access="isAnonymous()">
			<li><a class="fNiv"><spring:message code="master.page.register" /></a>
				<ul>
					<li class="arrow"></li>
						<li><a href="tenant/register.do"><spring:message code="master.page.tenant.register" /></a></li>
						<li><a href="lessor/register.do"><spring:message code="master.page.lessor.register" /></a></li>					
				</ul>
			</li>
			<li><a href="property/list.do"><spring:message	code="master.page.property.list" /></a></li>
			<li><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>
			
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			<li><a href="property/list.do"><spring:message	code="master.page.property.list" /></a></li>
			<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /></a></li>

		</security:authorize>

	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

