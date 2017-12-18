
package controllers.lessor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.LessorService;
import services.PropertyService;
import controllers.AbstractController;
import domain.Lessor;
import domain.Property;

@Controller
@RequestMapping("/property/lessor")
public class PropertyLessorController extends AbstractController {

	// Services
	// ====================================================================================

	@Autowired
	private PropertyService	propertyService;

	@Autowired
	private LessorService	lessorService;


	// Listing
	// ====================================================================================

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listByLessor() {
		ModelAndView result;
		Collection<Property> properties;
		Lessor lessor;
		boolean owner;

		owner = true;
		lessor = lessorService.findPrincipal();
		properties = propertyService.findAllByLessor(lessor);

		result = new ModelAndView("property/list");
		result.addObject("properties", properties);
		result.addObject("owner", owner);
		result.addObject("lessor", lessor);
		result.addObject("RequestURI", "property/lessor/list.do");

		return result;
	}

}
