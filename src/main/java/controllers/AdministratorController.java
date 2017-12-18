/*
 * AdministratorController.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AdministratorService;
import services.AuditorService;
import services.FinderService;
import services.LessorService;
import services.PropertyService;
import services.TenantService;
import domain.Lessor;
import domain.Property;
import domain.Tenant;

@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {

	// Constructors -----------------------------------------------------------

	public AdministratorController() {
		super();
	}


	// Services ========================================================================

	@Autowired
	private LessorService			lessorService;

	@Autowired
	private TenantService			tenantService;

	@Autowired
	private AuditorService			auditorService;

	@Autowired
	private AdministratorService	administratorService;

	@Autowired
	private PropertyService			propertyService;

	@Autowired
	private FinderService			finderService;


	// Action-1 ---------------------------------------------------------------		

	@RequestMapping("/action-1")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-1");

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping("/action-2")
	public ModelAndView action2() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-2");

		return result;
	}

	//List
	// ============================================================================

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listLessor() {
		ModelAndView result;

		Collection<Lessor> lessors = lessorService.findAll();

		result = new ModelAndView("administrator/list");
		result.addObject("lessors", lessors);
		result.addObject("requestURI", "administrator/list.do");

		return result;
	}

	//DashBoard Lessor
	// ============================================================================

	@RequestMapping(value = "/dashboardLessor", method = RequestMethod.GET)
	public ModelAndView dashboard(@RequestParam int lessorId) {

		ModelAndView result;

		Lessor lessor = lessorService.findOne(lessorId);
		Collection<Property> propertiesAudits = new ArrayList<Property>();
		Collection<Property> propertiesBookings = new ArrayList<Property>();
		Collection<Property> propertiesAcceptedBookings = new ArrayList<Property>();
		Collection<Property> propertiesPendingBookings = new ArrayList<Property>();
		Collection<Property> propertiesDeniedBookings = new ArrayList<Property>();

		if (propertyService.findAll().isEmpty()) {
			propertiesAudits = new ArrayList<Property>();
		} else {
			propertiesAudits = propertyService.findPropertyByAudits(lessorId);
		}
		if (propertyService.findAll().isEmpty()) {
			propertiesBookings = new ArrayList<Property>();
		} else {
			propertiesBookings = propertyService.findPropertyByBookings(lessorId);
		}
		if (propertyService.findAll().isEmpty()) {
			propertiesAcceptedBookings = new ArrayList<Property>();
		} else {
			propertiesAcceptedBookings = propertyService.findPropertyByAcceptedBookings(lessorId);
		}
		if (propertyService.findAll().isEmpty()) {
			propertiesPendingBookings = new ArrayList<Property>();
		} else {
			propertiesPendingBookings = propertyService.findPropertyByPendingBookings(lessorId);
		}
		if (propertyService.findAll().isEmpty()) {
			propertiesDeniedBookings = new ArrayList<Property>();
		} else {
			propertiesDeniedBookings = propertyService.findPropertyByDeniedBookings(lessorId);
		}

		result = new ModelAndView("administrator/dashboardLessor");

		result.addObject("lessor", lessor);
		result.addObject("propertiesAudits", propertiesAudits);
		result.addObject("propertiesBookings", propertiesBookings);
		result.addObject("propertiesAcceptedBookings", propertiesAcceptedBookings);
		result.addObject("propertiesPendingBookings", propertiesPendingBookings);
		result.addObject("propertiesDeniedBookings", propertiesDeniedBookings);

		result.addObject("requestURI", "administrator/dashboardLessor.do");

		return result;
	}

	//DashBoard
	// ============================================================================

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView result;
		Double avgRequestAcceptedL = 0.0;
		Double avgRequestDeniedL = 0.0;
		Double avgRequestAcceptedT = 0.0;
		Double avgRequestDeniedT = 0.0;
		Double minAudits = 0.0;
		Double avgAudits = 0.0;
		Double maxAudits = 0.0;
		Double minSocialIdLessor = 0.0;
		Double avgSocialIdLessor = 0.0;
		Double maxSocialIdLessor = 0.0;
		Double minSocialIdTenant = 0.0;
		Double avgSocialIdTenant = 0.0;
		Double maxSocialIdTenant = 0.0;
		Double minSocialIdAuditor = 0.0;
		Double avgSocialIdAuditor = 0.0;
		Double maxSocialIdAuditor = 0.0;
		Double minSocialIdAdministrator = 0.0;
		Double avgSocialIdAdministrator = 0.0;
		Double maxSocialIdAdministrator = 0.0;
		Double avgResultPerFinder = 0.0;
		Integer maxResultPerFinder = 0;
		Integer minResultPerFinder = 0;

		Collection<Lessor> LessorAcceptedMore = new ArrayList<Lessor>();
		Collection<Lessor> LessorDeniedMore = new ArrayList<Lessor>();
		Collection<Lessor> LessorPendingMore = new ArrayList<Lessor>();
		Collection<Tenant> TenantAcceptedMore = new ArrayList<Tenant>();
		Collection<Tenant> TenantDeniedMore = new ArrayList<Tenant>();
		Collection<Tenant> TenantPendingMore = new ArrayList<Tenant>();
		Collection<Lessor> RatioLessorMax = new ArrayList<Lessor>();
		Collection<Lessor> RatioLessorMin = new ArrayList<Lessor>();
		Collection<Tenant> RatioTenantMax = new ArrayList<Tenant>();
		Collection<Tenant> RatioTenantMin = new ArrayList<Tenant>();
		Collection<String> findAttNameOrderByUse = new ArrayList<String>();

		if (lessorService.findAll().isEmpty()) {
			avgRequestAcceptedL = 0.0;
		} else {
			avgRequestAcceptedL = lessorService.avgAcceptedRequestPerLessor();
		}
		if (finderService.findAll().isEmpty()) {
			avgResultPerFinder = 0.0;
		} else {
			avgResultPerFinder = finderService.avgResultPerFinder();
		}
		if (finderService.findAll().isEmpty()) {
			maxResultPerFinder = 0;
		} else {
			maxResultPerFinder = finderService.maxResultPerFinder();
		}
		if (finderService.findAll().isEmpty()) {
			minResultPerFinder = 0;
		} else {
			minResultPerFinder = finderService.minResultPerFinder();
		}
		if (lessorService.findAll().isEmpty()) {
			avgRequestDeniedL = 0.0;
		} else {
			avgRequestDeniedL = lessorService.avgDeniedRequestPerLessor();
		}
		if (tenantService.findAll().isEmpty()) {
			avgRequestAcceptedT = 0.0;
		} else {
			avgRequestAcceptedT = tenantService.avgAcceptedRequestPerTenant();
		}
		if (tenantService.findAll().isEmpty()) {
			avgRequestDeniedT = 0.0;
		} else {
			avgRequestDeniedT = tenantService.avgDeniedRequestPerTenant();
		}
		if (lessorService.findAll().isEmpty()) {
			LessorAcceptedMore = new ArrayList<Lessor>();
		} else {
			LessorAcceptedMore = lessorService.lessorsMoreAcceptedRequest();
		}
		if (lessorService.findAll().isEmpty()) {
			LessorDeniedMore = new ArrayList<Lessor>();
		} else {
			LessorDeniedMore = lessorService.lessorsMoreDeniedRequest();
		}
		if (lessorService.findAll().isEmpty()) {
			LessorPendingMore = new ArrayList<Lessor>();
		} else {
			LessorPendingMore = lessorService.lessorsMorePendingRequest();
		}

		if (tenantService.findAll().isEmpty()) {
			TenantAcceptedMore = new ArrayList<Tenant>();
		} else {
			TenantAcceptedMore = tenantService.tenantMoreAcceptedRequest();
		}
		if (tenantService.findAll().isEmpty()) {
			TenantDeniedMore = new ArrayList<Tenant>();
		} else {
			TenantDeniedMore = tenantService.tenantMoreDeniedRequest();
		}
		if (tenantService.findAll().isEmpty()) {
			TenantPendingMore = new ArrayList<Tenant>();
		} else {
			TenantPendingMore = tenantService.tenantMorePendingRequest();
		}
		if (lessorService.findAll().isEmpty()) {
			RatioLessorMax = new ArrayList<Lessor>();
		} else {
			RatioLessorMax = lessorService.ratioLessorMax();
		}
		if (lessorService.findAll().isEmpty()) {
			RatioLessorMin = new ArrayList<Lessor>();
		} else {
			RatioLessorMin = lessorService.ratioLessorMin();
		}
		if (tenantService.findAll().isEmpty()) {
			RatioTenantMax = new ArrayList<Tenant>();
		} else {
			RatioTenantMax = tenantService.ratioTenantMax();
		}
		if (tenantService.findAll().isEmpty()) {
			RatioTenantMin = new ArrayList<Tenant>();
		} else {
			RatioTenantMin = tenantService.ratioTenantMin();
		}
		if (propertyService.findAll().isEmpty()) {
			minAudits = 0.0;
			avgAudits = 0.0;
			maxAudits = 0.0;
		} else {
			minAudits = propertyService.minAudits();
			avgAudits = propertyService.avgAudits();
			maxAudits = propertyService.maxAudits();
		}
		if (propertyService.findAll().isEmpty()) {
			findAttNameOrderByUse = new ArrayList<String>();
		} else {
			findAttNameOrderByUse = propertyService.findAttNameOrderByUse();
		}
		if (lessorService.findAll().isEmpty()) {
			minSocialIdLessor = 0.0;
			avgSocialIdLessor = 0.0;
			maxSocialIdLessor = 0.0;
		} else {
			minSocialIdLessor = lessorService.minSocialIdLessor();
			avgSocialIdLessor = lessorService.avgSocialIdLessor();
			maxSocialIdLessor = lessorService.maxSocialIdLessor();
		}
		if (tenantService.findAll().isEmpty()) {
			minSocialIdTenant = 0.0;
			avgSocialIdTenant = 0.0;
			maxSocialIdTenant = 0.0;
		} else {
			minSocialIdTenant = tenantService.minSocialIdTenant();
			avgSocialIdTenant = tenantService.avgSocialIdTenant();
			maxSocialIdTenant = tenantService.maxSocialIdTenant();
		}
		if (auditorService.findAll().isEmpty()) {
			minSocialIdAuditor = 0.0;
			avgSocialIdAuditor = 0.0;
			maxSocialIdAuditor = 0.0;
		} else {
			minSocialIdAuditor = auditorService.minSocialIdAuditor();
			avgSocialIdAuditor = auditorService.avgSocialIdAuditor();
			maxSocialIdAuditor = auditorService.maxSocialIdAuditor();
		}
		if (administratorService.findAll().isEmpty()) {
			minSocialIdAdministrator = 0.0;
			avgSocialIdAdministrator = 0.0;
			maxSocialIdAdministrator = 0.0;
		} else {
			minSocialIdAdministrator = administratorService.minSocialIdAdministrator();
			avgSocialIdAdministrator = administratorService.avgSocialIdAdministrator();
			maxSocialIdAdministrator = administratorService.maxSocialIdAdministrator();
		}

		result = new ModelAndView("administrator/dashboard");
		result.addObject("avgRequestAcceptedL", avgRequestAcceptedL);
		result.addObject("avgResultPerFinder", avgResultPerFinder);
		result.addObject("maxResultPerFinder", maxResultPerFinder);
		result.addObject("minResultPerFinder", minResultPerFinder);
		result.addObject("avgRequestDeniedL", avgRequestDeniedL);
		result.addObject("avgRequestAcceptedT", avgRequestAcceptedT);
		result.addObject("avgRequestDeniedT", avgRequestDeniedT);
		result.addObject("LessorAcceptedMore", LessorAcceptedMore);
		result.addObject("LessorDeniedMore", LessorDeniedMore);
		result.addObject("LessorPendingMore", LessorPendingMore);
		result.addObject("TenantAcceptedMore", TenantAcceptedMore);
		result.addObject("TenantDeniedMore", TenantDeniedMore);
		result.addObject("TenantPendingMore", TenantPendingMore);
		result.addObject("RatioLessorMax", RatioLessorMax);
		result.addObject("RatioLessorMin", RatioLessorMin);
		result.addObject("RatioTenantMax", RatioTenantMax);
		result.addObject("RatioTenantMin", RatioTenantMin);
		result.addObject("minAudits", minAudits);
		result.addObject("avgAudits", avgAudits);
		result.addObject("maxAudits", maxAudits);
		result.addObject("findAttNameOrderByUse", findAttNameOrderByUse);
		result.addObject("minSocialIdLessor", minSocialIdLessor);
		result.addObject("avgSocialIdLessor", avgSocialIdLessor);
		result.addObject("maxSocialIdLessor", maxSocialIdLessor);
		result.addObject("minSocialIdTenant", minSocialIdTenant);
		result.addObject("avgSocialIdTenant", avgSocialIdTenant);
		result.addObject("maxSocialIdTenant", maxSocialIdTenant);
		result.addObject("minSocialIdAuditor", minSocialIdAuditor);
		result.addObject("avgSocialIdAuditor", avgSocialIdAuditor);
		result.addObject("maxSocialIdAuditor", maxSocialIdAuditor);
		result.addObject("minSocialIdAdministrator", minSocialIdAdministrator);
		result.addObject("avgSocialIdAdministrator", avgSocialIdAdministrator);
		result.addObject("maxSocialIdAdministrator", maxSocialIdAdministrator);

		result.addObject("requestURI", "administrator/dashboard.do");

		return result;
	}
}
