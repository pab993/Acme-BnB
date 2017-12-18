
package controllers.tenant;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.BookingService;
import services.SocialIdentityService;
import services.TenantService;
import controllers.AbstractController;
import domain.Booking;
import domain.SocialIdentity;
import domain.Tenant;

@Controller
@RequestMapping("/tenant/tenant")
public class TenantTenantController extends AbstractController {

	//Services
	@Autowired
	private TenantService	tenantService;

	@Autowired
	private BookingService	bookingService;

	@Autowired
	private SocialIdentityService socialIdentityService;

	// Edit
	// ====================================================================

	@RequestMapping(value = "/listTenant", method = RequestMethod.GET)
	public ModelAndView listByTenant() {
		ModelAndView result;
		Collection<Booking> bookings;
		Tenant tenant;

		tenant = tenantService.findByPrincipal();
		bookings = bookingService.findAllByTenant(tenant);

		result = new ModelAndView("booking/list");
		result.addObject("bookings", bookings);
		result.addObject("RequestURI", "booking/tenant/listTenant.do");

		return result;
	}

	// Edit
	// ====================================================================

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {

		Tenant tenant = tenantService.findPrincipal();

		Collection<SocialIdentity> socialIdentities = tenant.getSocialIdentities();

		ModelAndView resul = new ModelAndView("tenant/edit");
		resul.addObject("tenant", tenant);

		resul.addObject("socialIdentities", socialIdentities);

		resul.addObject("requestURI", "tenant/tenant/edit.do");

		return resul;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(Tenant tenant, BindingResult binding) {

		ModelAndView resul;
		Collection<SocialIdentity> socialIdentities = socialIdentityService.findAllByPrincipal();

		
			try {
				tenant = tenantService.reconstruct(tenant, binding);
				tenantService.save(tenant);
				resul = createEditModelAndView(tenant, socialIdentities, "lessor.commit.save");
			} catch (Throwable oops) {
				resul = createEditModelAndView(tenant, socialIdentities, "lessor.commit.error");
			}


		return resul;
	}

	// Others methods
	// ============================================

	private ModelAndView createEditModelAndView(Tenant tenant,Collection<SocialIdentity> socialIdentities, String message) {
		// TODO Auto-generated method stub

		ModelAndView resul = new ModelAndView("tenant/edit");
		resul.addObject("tenant", tenant);

		resul.addObject("socialIdentities", socialIdentities);

		resul.addObject("requestURI", "tenant/tenant/edit.do");

		resul.addObject("message", message);
		return resul;
	}



}
