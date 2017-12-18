
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.TenantService;
import domain.Tenant;
import forms.TenantForm;

@Controller
@RequestMapping("/tenant")
public class TenantController extends AbstractController {

	// Services
	// ====================================================================================

	@Autowired
	private TenantService	tenantService;


	// Listing
	// ====================================================================================

	//Register
	// =============================================================================

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView create() {

		ModelAndView result;
		TenantForm tenantForm = new TenantForm();

		result = createEditModelAndView(tenantForm);

		return result;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(TenantForm tenantForm, BindingResult binding) {
		ModelAndView result;
		Tenant tenant;

		tenant = tenantService.reconstruct(tenantForm, binding);
		if (binding.hasErrors()) {
			result = createEditModelAndView(tenantForm);
		} else {
			try {
				Assert.isTrue(tenantForm.getCheck());
				tenantService.save(tenant);
				result = new ModelAndView("redirect:/welcome/index.jsp");
			} catch (Throwable oops) {
				result = createEditModelAndView(tenantForm, "tenant.commit.error");
			}
		}

		return result;
	}

	// Ancillary methods ----------------------------------------------------------------

	protected ModelAndView createEditModelAndView(TenantForm tenantForm) {
		ModelAndView result;

		result = createEditModelAndView(tenantForm, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(TenantForm tenantForm, String message) {
		ModelAndView result;
		result = new ModelAndView("tenant/register");
		result.addObject("tenantForm", tenantForm);
		result.addObject("message", message);

		return result;
	}

}
