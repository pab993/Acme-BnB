
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AttributeNameService;
import services.AttributeValueService;
import services.LessorService;
import services.PropertyService;
import domain.AttributeName;
import domain.AttributeValue;
import domain.Lessor;
import domain.Property;

@Controller
@RequestMapping("/attributeValue")
public class AttributeValueController {

	// Services
	// ====================================================================================

	@Autowired
	private AttributeValueService	attributeValueService;

	@Autowired
	private LessorService			lessorService;

	@Autowired
	private AttributeNameService	attributeNameService;

	@Autowired
	private PropertyService			propertyService;


	// Listing
	// ====================================================================================

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam int propertyId) {
		ModelAndView result;
		Collection<AttributeValue> attributeValues;

		Lessor lessor = lessorService.findPrincipal();
		attributeValues = attributeValueService.findAllByPropertyId(propertyId);

		result = new ModelAndView("attributeValue/list");
		result.addObject("attributeValues", attributeValues);
		result.addObject("lessor", lessor);
		result.addObject("propertyId", propertyId);
		result.addObject("requestURI", "attributeValue/list.do");

		return result;
	}

	// Create
	// =====================================================================================

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam int propertyId) {
		ModelAndView result;
		AttributeValue attributeValue;
		Property property;

		attributeValue = attributeValueService.create();
		property = propertyService.findOne(propertyId);
		attributeValue.setProperty(property);
		result = createEditModelAndView(attributeValue);

		return result;
	}

	// Edit
	// ====================================================================================

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int attributeValueId) {
		ModelAndView result;
		AttributeValue attributeValue;

		attributeValue = attributeValueService.findOne(attributeValueId);
		Assert.notNull(attributeValue);
		result = createEditModelAndView(attributeValue);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(AttributeValue attributeValue, BindingResult binding) {
		ModelAndView result;

		attributeValue = attributeValueService.reconstruct(attributeValue, binding);
		if (binding.hasErrors()) {
			result = createEditModelAndView(attributeValue);
		} else {
			try {
				attributeValueService.save(attributeValue);
				result = new ModelAndView("redirect:list.do?propertyId=" + attributeValue.getProperty().getId());
			} catch (Throwable oops) {
				result = createEditModelAndView(attributeValue, "attributeValue.commit.error.2");
			}
		}
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(AttributeValue attributeValue, BindingResult binding) {
		ModelAndView result;

		attributeValue = attributeValueService.reconstruct(attributeValue, binding);
		try {
			attributeValueService.delete(attributeValue);
			result = new ModelAndView("redirect:list.do?propertyId=" + attributeValue.getProperty().getId());
		} catch (Throwable oops) {
			result = createEditModelAndView(attributeValue, "attributeValue.commit.error");

		}
		return result;
	}

	// Ancillary Methods
	// ===============================================================================

	protected ModelAndView createEditModelAndView(AttributeValue attributeValue) {
		ModelAndView result;

		result = createEditModelAndView(attributeValue, null);
		return result;
	}

	protected ModelAndView createEditModelAndView(AttributeValue attributeValue, String message) {
		ModelAndView result;

		Collection<AttributeName> attributeNames = attributeNameService.findAll();
		result = new ModelAndView("attributeValue/edit");
		result.addObject("attributeNames", attributeNames);
		result.addObject("attributeValue", attributeValue);
		result.addObject("message", message);

		return result;
	}
}
