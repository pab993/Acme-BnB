
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
import domain.AttributeName;

@Controller
@RequestMapping("/attributeName")
public class AttributeNameController {

	// Services
	// ====================================================================================

	@Autowired
	private AttributeNameService	attributeNameService;


	// Listing
	// ====================================================================================

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<AttributeName> attributeNames;

		attributeNames = attributeNameService.findAll();

		result = new ModelAndView("attributeName/list");
		result.addObject("attributeNames", attributeNames);
		result.addObject("requestURI", "attributeName/list.do");

		return result;
	}

	// Create
	// =====================================================================================

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		AttributeName attributeName;

		attributeName = attributeNameService.create();
		result = createEditModelAndView(attributeName);

		return result;
	}

	// Edit
	// ====================================================================================

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int attributeNameId) {
		ModelAndView result;
		AttributeName attributeName;

		attributeName = attributeNameService.findOne(attributeNameId);
		Assert.notNull(attributeName);
		result = createEditModelAndView(attributeName);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(AttributeName attributeName, BindingResult binding) {
		ModelAndView result;

		attributeName = attributeNameService.reconstruct(attributeName, binding);
		if (binding.hasErrors()) {
			result = createEditModelAndView(attributeName);
		} else {
			try {
				attributeNameService.save(attributeName);
				result = new ModelAndView("redirect:list.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(attributeName, "attributeName.commit.error");
			}
		}
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(AttributeName attributeName, BindingResult binding) {
		ModelAndView result;

		attributeName = attributeNameService.reconstruct(attributeName, binding);
		try {
			attributeNameService.delete(attributeName);
			result = new ModelAndView("redirect:list.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(attributeName, "attributeName.commit.error");

		}
		return result;
	}

	// Ancillary Methods
	// ===============================================================================

	protected ModelAndView createEditModelAndView(AttributeName attributeName) {
		ModelAndView result;

		result = createEditModelAndView(attributeName, null);
		return result;
	}

	protected ModelAndView createEditModelAndView(AttributeName attributeName, String message) {
		ModelAndView result;

		result = new ModelAndView("attributeName/edit");
		result.addObject("attributeName", attributeName);
		result.addObject("message", message);

		return result;
	}
}
