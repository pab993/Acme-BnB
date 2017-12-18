
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import security.Authority;
import services.ActorService;
import services.CommentService;
import services.LessorService;
import domain.Actor;
import domain.Customer;
import domain.Lessor;
import forms.LessorForm;

@Controller
@RequestMapping("/lessor")
public class LessorController {

	// Services
	// ====================================================================================

	@Autowired
	private LessorService	lessorService;

	@Autowired
	private ActorService	actorService;

	@Autowired
	private CommentService	commentService;


	// Listing
	// ====================================================================================

	//Display
	// ====================================================================================
	@RequestMapping(value = "/myPerfil", method = RequestMethod.GET)
	public ModelAndView myPerfil() {

		Customer lessor = (Customer) actorService.findByPrincipal();
		ModelAndView resul = new ModelAndView("lessor/display");
		resul.addObject("canComment", true);
		resul.addObject("lessor", lessor);
		resul.addObject("comments", lessor.getComments());
		resul.addObject("requestURI", "lessor/myPerfil.do");

		return resul;
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView display(@RequestParam int customerId) {
		ModelAndView resul = new ModelAndView("lessor/display");
		Actor actor = actorService.findByPrincipal();
		Authority authorityAdmin = new Authority();
		authorityAdmin.setAuthority("ADMINISTRATOR");
		Authority authorityAuditor = new Authority();
		authorityAuditor.setAuthority("AUDITOR");

		if (actor == null) {
			Customer lessor = (Customer) actorService.findOne(customerId);
			resul.addObject("lessor", lessor);
			resul.addObject("comments", lessor.getComments());
			resul.addObject("requestURI", "lessor/display.do");
			return resul;
		}

		else if (actor.getUserAccount().getAuthorities().contains(authorityAdmin) || actor.getUserAccount().getAuthorities().contains(authorityAuditor)) {
			Customer lessor = (Customer) actorService.findOne(customerId);
			resul.addObject("lessor", lessor);
			resul.addObject("comments", lessor.getComments());
			resul.addObject("requestURI", "lessor/display.do");
			return resul;
		} else {
			Customer lessor = (Customer) actorService.findOne(customerId);
			Boolean canComment = commentService.canComment(lessor);
			resul.addObject("lessor", lessor);
			resul.addObject("comments", lessor.getComments());
			resul.addObject("canComment", canComment);
			resul.addObject("requestURI", "lessor/display.do");
			return resul;
		}
	}

	//Register
	// =============================================================================

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView create() {

		ModelAndView result;
		LessorForm lessorForm = new LessorForm();

		result = createEditModelAndView(lessorForm);

		return result;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(LessorForm lessorForm, BindingResult binding) {
		ModelAndView result;
		Lessor lessor;

		lessor = lessorService.reconstruct(lessorForm, binding);
		if (binding.hasErrors()) {
			result = createEditModelAndView(lessorForm);
		} else {
			try {
				int[] n = lessorService.stringToArray(lessor.getCreditCard().getNumber());
				Assert.isTrue(lessorForm.getCheck());
				Assert.isTrue(lessorService.verificacionLuhn(n));
				Assert.isTrue(lessorService.sieteDias(lessorForm.getCreditCard().getExpirationMonth(), lessorForm.getCreditCard().getExpirationYear()));
				lessorService.save(lessor);
				result = new ModelAndView("redirect:/welcome/index.jsp");
			} catch (Throwable oops) {
				result = createEditModelAndView(lessorForm, "lessor.commit.error");
			}
		}

		return result;
	}

	// Ancillary methods
	// ===============================================================================

	protected ModelAndView createEditModelAndView(LessorForm lessorForm) {
		ModelAndView result;

		result = createEditModelAndView(lessorForm, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(LessorForm lessorForm, String message) {
		ModelAndView result;
		result = new ModelAndView("lessor/register");
		result.addObject("lessorForm", lessorForm);
		result.addObject("message", message);

		return result;
	}

}
