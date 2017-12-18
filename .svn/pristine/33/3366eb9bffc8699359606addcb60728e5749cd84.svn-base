
package controllers.tenant;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.BookingService;
import services.PropertyService;
import controllers.AbstractController;
import domain.Booking;
import domain.Property;

@Controller
@RequestMapping("/booking/tenant")
public class BookingTenantController extends AbstractController {

	//Services

	@Autowired
	private BookingService	bookingService;

	@Autowired
	private PropertyService	propertyService;


	//Creation 
	// ====================================================================================

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam int propertyId) {
		ModelAndView result;
		Booking booking;
		Property property;

		property = propertyService.findOne(propertyId);
		booking = bookingService.create(property);

		result = createEditModelAndView(booking);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Booking booking, BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(booking);
		} else {
			try {

				bookingService.save(booking);
				result = new ModelAndView("redirect:/tenant/tenant/listTenant.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(booking, "booking.commit.error");
			}
		}
		return result;
	}

	// The ancillary methods 
	// ====================================================================================

	protected ModelAndView createEditModelAndView(Booking booking) {
		ModelAndView result;

		result = createEditModelAndView(booking, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Booking booking, String message) {
		ModelAndView result;

		result = new ModelAndView("booking/edit");

		result.addObject("booking", booking);
		result.addObject("message", message);

		return result;
	}
}
