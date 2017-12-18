
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.AuditorService;
import domain.Auditor;
import forms.AuditorForm;

@Controller
@RequestMapping("/auditor")
public class AuditorController {

	// Services
	// ====================================================================================

	@Autowired
	private AuditorService	auditorService;


	// Listing
	// ====================================================================================

	//Register
	// =============================================================================

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView create() {

		ModelAndView result;
		AuditorForm auditorForm = new AuditorForm();

		result = createEditModelAndView(auditorForm);

		return result;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(AuditorForm auditorForm, BindingResult binding) {
		ModelAndView result;
		Auditor auditor;

		auditor = auditorService.reconstruct(auditorForm, binding);
		if (binding.hasErrors()) {
			result = createEditModelAndView(auditorForm);
		} else {
			try {
				auditorService.save(auditor);
				result = new ModelAndView("redirect:/welcome/index.jsp");
			} catch (Throwable oops) {
				result = createEditModelAndView(auditorForm, "auditor.commit.error");
			}
		}

		return result;
	}

	// Ancillary methods
	// ===============================================================================

	protected ModelAndView createEditModelAndView(AuditorForm auditorForm) {
		ModelAndView result;

		result = createEditModelAndView(auditorForm, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(AuditorForm auditorForm, String message) {
		ModelAndView result;
		result = new ModelAndView("auditor/register");
		result.addObject("auditorForm", auditorForm);
		result.addObject("message", message);

		return result;
	}
}
