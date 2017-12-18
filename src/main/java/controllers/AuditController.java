
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AuditService;
import domain.Audit;

@Controller
@RequestMapping("/audit")
public class AuditController extends AbstractController {

	// Services
	// ====================================================================================

	@Autowired
	private AuditService	auditService;


	// Listing
	// ====================================================================================

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listByProperty(@RequestParam int propertyId) {
		ModelAndView result;
		Collection<Audit> audits;

		audits = auditService.findAllByProperty(propertyId);

		result = new ModelAndView("audit/list");
		result.addObject("audits", audits);
		result.addObject("RequestURI", "audit/list.do");

		return result;
	}

}
