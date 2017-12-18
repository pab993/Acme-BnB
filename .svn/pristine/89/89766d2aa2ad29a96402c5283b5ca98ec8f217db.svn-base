
package controllers.administrator;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.FeeService;
import controllers.AbstractController;
import domain.Fee;

@Controller
@RequestMapping("/fee/administrator")
public class FeeAdministratorController extends AbstractController {

	// Services 
	// ====================================================================================

	@Autowired
	private FeeService	feeService;


	// Show Fee 
	// ====================================================================================

	@RequestMapping(value = "/showFee", method = RequestMethod.GET)
	public ModelAndView showFee() {
		ModelAndView result;
		Fee fee = null;

		Collection<Fee> fees = feeService.findAll();
		for (Fee uniqueFee : fees) {
			fee = uniqueFee;
			break;
		}
		result = new ModelAndView("fee/administrator/showFee");
		result.addObject("row", fee);
		return result;

	}

	// Edit ======================================================================================

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int feeId) {
		ModelAndView result;
		Fee fee;

		fee = feeService.findOne(feeId);
		Assert.notNull(fee);

		result = createEditModelAndView(fee);

		return result;
	}

	// Edit ======================================================================================

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Fee fee, BindingResult bindingResult) {
		ModelAndView result;

		if (bindingResult.hasErrors()) {
			result = createEditModelAndView(fee);
		} else {
			try {
				feeService.save(fee);
				result = new ModelAndView("redirect:showFee.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(fee, "fee.commit.error");
			}
		}
		return result;
	}

	// Ancillary methods =============================================================================

	protected ModelAndView createEditModelAndView(Fee fee) {
		assert fee != null;

		ModelAndView result;

		result = createEditModelAndView(fee, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Fee fee, String message) {
		assert fee != null;

		ModelAndView result;

		result = new ModelAndView("fee/administrator/edit");
		result.addObject("fee", fee);
		result.addObject("message", message);

		return result;
	}

}
