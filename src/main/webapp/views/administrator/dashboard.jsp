<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<security:authorize access="hasRole('ADMINISTRATOR')">
		<div>
			<display:table name="avgRequestAcceptedL" id="avgRequestAcceptedL" pagesize="5" requestURI="${requestURI}" class="displaytag">
				<spring:message code="dashboard.avg.request.lessor.accepted" var="dash1" />
				<display:column title="${dash1}">
					<jstl:out value="${avgRequestAcceptedL}"/>
				</display:column>
			</display:table>
		</div>
		<div>
			<display:table name="avgRequestDeniedL" id="avgRequestDeniedL" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.avg.request.lessor.denied" var="dash2" />
				<display:column title="${dash2}">
					<jstl:out value="${avgRequestDeniedL}"/>
				</display:column>
				
			</display:table>
		</div>
		<div>
			<display:table name="avgRequestAcceptedT" id="avgRequestAcceptedT" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.avg.request.tenant.accepted" var="dash3" />
				<display:column title="${dash3}">
					<jstl:out value="${avgRequestAcceptedT}"/>
				</display:column>
				
			</display:table>
		</div>
		
		<div>
			<display:table name="avgRequestDeniedT" id="avgRequestDeniedT" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.avg.request.tenant.denied" var="dash9" />
				<display:column title="${dash9}">
					<jstl:out value="${avgRequestDeniedT}"/>
				</display:column>
				
			</display:table>
		</div>
		
		<div>
			<display:table name="LessorAcceptedMore" id="LessorAcceptedMore" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.request.lessor.accepted" var="dash10" />
				<display:column title="${dash10}">
					<jstl:out value="${LessorAcceptedMore.userAccount.username}"/>
				</display:column>
				
			</display:table>
		</div>
		
		<div>
			<display:table name="LessorDeniedMore" id="LessorDeniedMore" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.request.lessor.denied" var="dash11" />
				<display:column title="${dash11}">
					<jstl:out value="${LessorDeniedMore.userAccount.username}"/>
				</display:column>
				
			</display:table>
		</div>
		
		<div>
			<display:table name="LessorPendingMore" id="LessorPendingMore" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.request.lessor.pending" var="dash12" />
				<display:column title="${dash12}">
					<jstl:out value="${LessorPendingMore.userAccount.username}"/>
				</display:column>
				
			</display:table>
		</div>
		
		<div>
			<display:table name="TenantAcceptedMore" id="TenantAcceptedMore" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.request.tenant.accepted" var="dash4" />
				<display:column title="${dash4}">
					<jstl:out value="${TenantAcceptedMore.userAccount.username}"/>
				</display:column>
				
			</display:table>
		</div>
		<div>
			<display:table name="TenantDeniedMore" id="TenantDeniedMore" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.request.tenant.denied" var="dash5" />
				<display:column title="${dash5}">
					<jstl:out value="${TenantDeniedMore.userAccount.username}"/>
				</display:column>
				
			</display:table>
		</div>
		<div>
			<display:table name="TenantPendingMore" id="TenantPendingMore" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.request.tenant.pending" var="dash6" />
				<display:column title="${dash6}">
					<jstl:out value="${TenantPendingMore.userAccount.username}"/>
				</display:column>
				
			</display:table>
		</div>
		
		<div>
			<display:table name="RatioLessorMax" id="RatioLessorMax" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.lessor.max" var="dash13" />
				<display:column title="${dash13}">
					<jstl:out value="${RatioLessorMax.userAccount.username}"/>
				</display:column>
				
			</display:table>
		</div>
		<div>
			<display:table name="RatioLessorMin" id="RatioLessorMin" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.lessor.min" var="dash14" />
				<display:column title="${dash14}">
					<jstl:out value="${RatioLessorMin.userAccount.username}"/>
				</display:column>
				
			</display:table>
		</div>
		<div>
			<display:table name="RatioTenantMax" id="RatioTenantMax" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.tenant.max" var="dash7" />
				<display:column title="${dash7}">
					<jstl:out value="${RatioTenantMax.userAccount.username}"/>
				</display:column>
				
			</display:table>
		</div>
		<div>
			<display:table name="RatioTenantMin" id="RatioTenantMin" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.tenant.min" var="dash8" />
				<display:column title="${dash8}">
					<jstl:out value="${RatioTenantMin.userAccount.username}"/>
				</display:column>
				
			</display:table>
		</div>
		<div>
			<display:table name="minAudits" id="minAudits" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.audits" var="dash9" />
				<display:column title="${dash9}">
					<jstl:out value="${minAudits}"/>
				</display:column>
				
			</display:table>
			<display:table name="avgAudits" id="avgAudits" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.audits" var="dash9" />
				<display:column title="${dash9}">
					<jstl:out value="${avgAudits}"/>
				</display:column>
				
			</display:table>
			<display:table name="maxAudits" id="maxAudits" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.audits" var="dash9" />
				<display:column title="${dash9}">
					<jstl:out value="${maxAudits}"/>
				</display:column>
				
			</display:table>
		</div>
		<div>
			<display:table name="findAttNameOrderByUse" id="findAttNameOrderByUse" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.attname.uses" var="dash10" />
				<display:column title="${dash10}">
					<jstl:out value="${findAttNameOrderByUse}"/>
				</display:column>
				
			</display:table>
		</div>
		<div>
			<display:table name="minSocialIdLessor" id="minSocialIdLessor" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.lessor" var="dash11" />
				<display:column title="${dash11}">
					<jstl:out value="${minSocialIdLessor}"/>
				</display:column>
				
			</display:table>
			<display:table name="avgSocialIdLessor" id="avgSocialIdLessor" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.lessor" var="dash11" />
				<display:column title="${dash11}">
					<jstl:out value="${avgSocialIdLessor}"/>
				</display:column>
				
			</display:table>
			<display:table name="maxSocialIdLessor" id="maxSocialIdLessor" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.lessor" var="dash11" />
				<display:column title="${dash11}">
					<jstl:out value="${maxSocialIdLessor}"/>
				</display:column>
				
			</display:table>
		</div>	
		<div>
			<display:table name="minSocialIdTenant" id="minSocialIdTenant" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.tenant" var="dash12" />
				<display:column title="${dash12}">
					<jstl:out value="${minSocialIdTenant}"/>
				</display:column>
				
			</display:table>
			<display:table name="avgSocialIdTenant" id="avgSocialIdTenant" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.tenant" var="dash12" />
				<display:column title="${dash12}">
					<jstl:out value="${avgSocialIdTenant}"/>
				</display:column>
				
			</display:table>
			<display:table name="maxSocialIdTenant" id="maxSocialIdTenant" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.tenant" var="dash12" />
				<display:column title="${dash12}">
					<jstl:out value="${maxSocialIdTenant}"/>
				</display:column>
				
			</display:table>
		</div>	
		<div>
			<display:table name="minSocialIdAuditor" id="minSocialIdAuditor" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.auditor" var="dash13" />
				<display:column title="${dash13}">
					<jstl:out value="${minSocialIdAuditor}"/>
				</display:column>
				
			</display:table>
			<display:table name="avgSocialIdAuditor" id="avgSocialIdAuditor" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.auditor" var="dash13" />
				<display:column title="${dash13}">
					<jstl:out value="${avgSocialIdAuditor}"/>
				</display:column>
				
			</display:table>
			<display:table name="maxSocialIdAuditor" id="maxSocialIdAuditor" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.auditor" var="dash13" />
				<display:column title="${dash13}">
					<jstl:out value="${maxSocialIdAuditor}"/>
				</display:column>
				
			</display:table>
		</div>	
		<div>
			<display:table name="minSocialIdAdministrator" id="minSocialIdAdministrator" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.administrator" var="dash14" />
				<display:column title="${dash14}">
					<jstl:out value="${minSocialIdAdministrator}"/>
				</display:column>
				
			</display:table>
			<display:table name="avgSocialIdAdministrator" id="avgSocialIdAdministrator" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.administrator" var="dash14" />
				<display:column title="${dash14}">
					<jstl:out value="${avgSocialIdAdministrator}"/>
				</display:column>
				
			</display:table>
			<display:table name="maxSocialIdAdministrator" id="maxSocialIdAdministrator" pagesize="5" requestURI="${requestURI}" class="displaytag">
				
				<spring:message code="dashboard.ratio.social.administrator" var="dash14" />
				<display:column title="${dash14}">
					<jstl:out value="${maxSocialIdAdministrator}"/>
				</display:column>
				
			</display:table>
		</div>		
		<div>
			<display:table name="avgResultPerFinder" id="avgResultPerFinder" pagesize="5" requestURI="${requestURI}" class="displaytag">
				<spring:message code="dashboard.avg.result.per.finder" var="dash15" />
				<display:column title="${dash15}">
					<jstl:out value="${avgResultPerFinder}"/>
				</display:column>
			</display:table>
		</div>
		<div>
			<display:table name="maxResultPerFinder" id="maxResultPerFinder" pagesize="5" requestURI="${requestURI}" class="displaytag">
				<spring:message code="dashboard.max.result.per.finder" var="dash16" />
				<display:column title="${dash16}">
					<jstl:out value="${maxResultPerFinder}"/>
				</display:column>
			</display:table>
		</div>
		<div>
			<display:table name="minResultPerFinder" id="minResultPerFinder" pagesize="5" requestURI="${requestURI}" class="displaytag">
				<spring:message code="dashboard.min.result.per.finder" var="dash17" />
				<display:column title="${dash17}">
					<jstl:out value="${minResultPerFinder}"/>
				</display:column>
			</display:table>
		</div>
		
</security:authorize>