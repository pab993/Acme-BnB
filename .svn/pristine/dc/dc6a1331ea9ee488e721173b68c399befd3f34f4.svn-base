
package controllers;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.FinderService;
import services.TenantService;
import domain.Finder;
import domain.Property;
import domain.Tenant;

@Controller
@RequestMapping("/finder")
public class FinderController {

	// Services
	// ====================================================================================

	@Autowired
	private FinderService	finderService;

	@Autowired
	private TenantService	tenantService;


	// Listing
	// ====================================================================================

	@RequestMapping(value = "/tenant", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Property> properties;

		Tenant tenant = tenantService.findByPrincipal();
		Finder finder = tenant.getFinder();

		Date f = tenant.getFinder().getSearchMoment();
		Calendar fc = Calendar.getInstance();
		fc.setTime(f);

		long l = 10;
		Date d = new Date(System.currentTimeMillis() - l);
		Calendar c = Calendar.getInstance();
		c.setTime(d);

		if (c.get(Calendar.YEAR) > fc.get(Calendar.YEAR)) {
			finder.setResults(null);
			finder = finderService.save(finder);
		} else if (c.get(Calendar.YEAR) == fc.get(Calendar.YEAR) && c.get(Calendar.MONTH) + 1 > fc.get(Calendar.MONTH) + 1) {
			finder.setResults(null);
			finder = finderService.save(finder);
		} else if (c.get(Calendar.YEAR) == fc.get(Calendar.YEAR) && c.get(Calendar.MONTH) + 1 == fc.get(Calendar.MONTH) + 1 && c.get(Calendar.DAY_OF_MONTH) > fc.get(Calendar.DAY_OF_MONTH)) {
			finder.setResults(null);
			finder = finderService.save(finder);
		} else if (c.get(Calendar.YEAR) == fc.get(Calendar.YEAR) && c.get(Calendar.MONTH) + 1 == fc.get(Calendar.MONTH) + 1 && c.get(Calendar.DAY_OF_MONTH) > fc.get(Calendar.DAY_OF_MONTH) && c.get(Calendar.HOUR_OF_DAY) > fc.get(Calendar.HOUR_OF_DAY)) {
			finder.setResults(null);
			finder = finderService.save(finder);
		}
		properties = tenant.getFinder().getResults();
		result = new ModelAndView("finder/finder");
		result.addObject("finder", finder);
		result.addObject("properties", properties);
		result.addObject("requestURI", "finder/tenant.do");

		return result;
	}
	//Search
	// ====================================================================================

	@RequestMapping(value = "/search", method = RequestMethod.POST, params = "search")
	public ModelAndView search(@Valid Finder finder, BindingResult binding) {
		ModelAndView result;
		Collection<Property> properties;

		if (binding.hasErrors()) {
			result = createEditModelAndView(finder);
		} else {
			try {
				finder = finderService.reconstruct(finder, binding); //Añadir el date aquí
				properties = finderService.search(finder.getDestination(), finder.getMinPrice(), finder.getMaxPrice(), finder.getKeyword());
				finder.setResults(properties);
				finderService.save(finder);
				result = new ModelAndView("finder/finder");
				result.addObject("properties", properties);
				result.addObject("requestURI", "finder/tenant.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(finder, "finder.commit.error");
			}
		}

		return result;
	}

	// Ancillary methods
	// ===============================================================================

	protected ModelAndView createEditModelAndView(Finder finder) {
		ModelAndView result;

		result = createEditModelAndView(finder, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Finder finder, String message) {
		ModelAndView result;
		result = new ModelAndView("finder/finder");
		result.addObject("finder", finder);
		result.addObject("message", message);

		return result;
	}
}
