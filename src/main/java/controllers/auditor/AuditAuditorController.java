
package controllers.auditor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AuditService;
import services.AuditorService;
import services.PropertyService;
import controllers.AbstractController;
import domain.Audit;
import domain.Auditor;
import domain.Property;

@Controller
@RequestMapping("/audit/auditor")
public class AuditAuditorController extends AbstractController {

	// Services
	// ====================================================================================

	@Autowired
	private AuditService	auditService;

	@Autowired
	private PropertyService	propertyService;

	@Autowired
	private AuditorService	auditorService;


	// Listing
	// ====================================================================================

	@RequestMapping(value = "/myList", method = RequestMethod.GET)
	public ModelAndView listAuditsByAuditor() {
		ModelAndView result;
		Collection<Audit> audits;
		Auditor auditor;

		auditor = auditorService.findByPrincipal();
		audits = auditService.findAllByAuditor(auditor.getId());

		result = new ModelAndView("audit/list");
		result.addObject("audits", audits);
		result.addObject("RequestURI", "audit/auditor/myList.do");

		return result;
	}

	@RequestMapping(value = "/listDraft", method = RequestMethod.GET)
	public ModelAndView listDraft() {
		ModelAndView result;
		Collection<Audit> audits;
		Auditor auditor;
		boolean owner;
		int draft = 1;

		owner = true;
		auditor = auditorService.findByPrincipal();
		audits = auditService.findAllDraft(auditor.getId());

		result = new ModelAndView("audit/list");
		result.addObject("audits", audits);
		result.addObject("owner", owner);
		result.addObject("draft", draft);
		result.addObject("RequestURI", "audit/auditor/listDraft.do");

		return result;
	}

	@RequestMapping(value = "/listNotDraft", method = RequestMethod.GET)
	public ModelAndView listNotDraft() {
		ModelAndView result;
		Collection<Audit> audits;
		Auditor auditor;

		auditor = auditorService.findByPrincipal();
		audits = auditService.findAllNotDraft(auditor.getId());

		result = new ModelAndView("audit/list");
		result.addObject("audits", audits);
		result.addObject("RequestURI", "audit/auditor/listNotDraft.do");

		return result;
	}

	@RequestMapping(value = "/draft", method = RequestMethod.GET)
	public ModelAndView register(@RequestParam int auditId) {
		ModelAndView result;

		try {
			auditService.draft(auditId);
			result = listNotDraft();
		} catch (Throwable oops) {
			result = listNotDraft();
		}

		return result;
	}

	@RequestMapping(value = "/notDraft", method = RequestMethod.GET)
	public ModelAndView unregister(@RequestParam int auditId) {
		ModelAndView result;

		try {
			auditService.notDraft(auditId);
			result = listDraft();
		} catch (Throwable oops) {
			result = listDraft();
		}

		return result;
	}

	// Creation 
	// ====================================================================================

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam int propertyId) {
		ModelAndView result;
		Audit audit;
		Property property;

		try {
			property = propertyService.findOne(propertyId);
			Assert.isTrue(auditService.countAuditByAuditorForProperty(auditorService.findByPrincipal().getId(), propertyId) == 0);
			audit = auditService.create(property);

			result = createEditModelAndView(audit);

		} catch (Throwable e) {
			result = listAuditsByAuditor();
			result.addObject("message", "audit.commit.error");
		}
		return result;
	}

	// Editing 
	// ====================================================================================

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int auditId) {
		ModelAndView result;
		Audit audit;

		audit = auditService.findOne(auditId);
		Assert.notNull(audit);
		result = createEditModelAndView(audit);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(Audit audit, BindingResult binding) {
		ModelAndView result;

		audit = auditService.reconstruct(audit, binding);
		if (binding.hasErrors()) {
			result = createEditModelAndView(audit);
		} else {
			try {

				auditService.save(audit);
				result = new ModelAndView("redirect:/audit/auditor/listDraft.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(audit, "audit.commit.error");
			}
		}
		return result;
	}

	//Deleting
	// ====================================================================================

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(Audit audit, BindingResult binding) {
		ModelAndView result;

		try {
			auditService.delete(audit);
			result = new ModelAndView("redirect:/audit/auditor/listDraft.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(audit, "audit.commit.error");
		}
		return result;
	}

	// The ancillary methods 
	// ====================================================================================

	protected ModelAndView createEditModelAndView(Audit audit) {
		ModelAndView result;

		result = createEditModelAndView(audit, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Audit audit, String message) {
		ModelAndView result;

		result = new ModelAndView("audit/edit");

		result.addObject("audit", audit);
		result.addObject("message", message);

		return result;
	}
}
