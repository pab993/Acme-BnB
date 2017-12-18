
package controllers.lessor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.BookingService;
import services.LessorService;
import services.SocialIdentityService;
import controllers.AbstractController;
import domain.Booking;
import domain.Lessor;
import domain.SocialIdentity;

@Controller
@RequestMapping("/lessor/lessor")
public class LessorLessorControler extends AbstractController {

	//Services
	@Autowired
	private LessorService			lessorService;

	@Autowired
	private SocialIdentityService	socialIdentityService;

	@Autowired
	private BookingService			bookingService;


	// Show Amount 
	// ====================================================================================

	@RequestMapping(value = "/showAmount", method = RequestMethod.GET)
	public ModelAndView showAmount() {
		ModelAndView result;
		Lessor lessor;
		Collection<Booking> bookings;
		lessor = lessorService.findPrincipal();

		//amount = lessorService.calculateAmount(lessor);

		bookings = bookingService.findAllAcceptedByLessor(lessor.getId());

		result = new ModelAndView("lessor/lessor/showAmount");
		result.addObject("bookings", bookings);
		result.addObject("amount", lessor.getAmount());

		return result;
	}

	// Edit
	// ====================================================================

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {

		Lessor lessor = lessorService.findPrincipal();
		Double amount;

		amount = lessorService.calculateAmount(lessor);
		Collection<SocialIdentity> socialIdentities = socialIdentityService.findAllByPrincipal();

		String censureNumber = lessorService.censureCreditCard(lessor.getCreditCard().getNumber());
		lessor.getCreditCard().setNumber(censureNumber);

		ModelAndView resul = new ModelAndView("lessor/edit");
		resul.addObject("lessor", lessor);
		resul.addObject("amount", amount);
		resul.addObject("socialIdentities", socialIdentities);

		resul.addObject("requestURI", "lessor/lessor/edit.do");
		return resul;
	}


	@Autowired
	Validator	validator;


	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(Lessor lessor, BindingResult binding) {

		ModelAndView resul;
		Collection<SocialIdentity> socialIdentities = socialIdentityService.findAllByPrincipal();

		if (binding.hasErrors()) {
			resul = createEditModelAndView(lessor);

		} else {
			try {
				lessor = lessorService.reconstruct(lessor, binding);
				lessorService.save(lessor);
				resul = createEditModelAndView(lessor, socialIdentities, "lessor.commit.save");
			} catch (Throwable oops) {
				resul = createEditModelAndView(lessor, socialIdentities, "lessor.commit.error");
			}
		}

		return resul;
	}

	private ModelAndView createEditModelAndView(Lessor lessor, Collection<SocialIdentity> socialIdentities, String message) {
		// TODO Auto-generated method stub

		ModelAndView resul = new ModelAndView("lessor/edit");
		resul.addObject("lessor", lessor);
		resul.addObject("socialIdentities", socialIdentities);

		resul.addObject("requestURI", "lessor/lessor/edit.do");

		resul.addObject("message", message);
		return resul;
	}

	@RequestMapping(value = "/deleteSocialIdentity", method = RequestMethod.GET)
	public ModelAndView deleteSocialIdentity(@RequestParam int idSocialIdentity) {

		SocialIdentity socialIdentity = socialIdentityService.findOneByPrincipal(idSocialIdentity);
		ModelAndView resul;

		try {

			socialIdentityService.delete(socialIdentity);
			resul = edit();

		} catch (Throwable opps) {
			// TODO: handle exception
			resul = createEditModelAndView(lessorService.findPrincipal(), "lessor.commit.error");
		}

		return resul;
	}

	// Others methods
	// ============================================

	private ModelAndView createEditModelAndView(Lessor lessor, String message) {
		// TODO Auto-generated method stub

		ModelAndView resul = new ModelAndView("redirect:/lessor/lessor/edit.do");

		return resul;
	}

	private ModelAndView createEditModelAndView(Lessor lessor) {
		// TODO Auto-generated method stub

		return createEditModelAndView(lessor, null);
	}

}
