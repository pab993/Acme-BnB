
package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.CommentService;
import domain.Comment;
import domain.Customer;

@Controller
@RequestMapping("/comment")
public class CommentController extends AbstractController {

	@Autowired
	private ActorService	actorService;
	@Autowired
	private CommentService	commentService;


	@RequestMapping(value = "/postComment", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam int customerId) {
		ModelAndView result;

		Customer customer = (Customer) actorService.findOne(customerId);

		Comment comment = commentService.create(customer);

		result = new ModelAndView("comment/postComment");
		result.addObject("comment", comment);

		return result;

	}
	@RequestMapping(value = "/postComment", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Comment comment, BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors()) {
			System.out.println("if");
			result = createEditModelAndView(comment);
			
		} else {
			try {
				
				commentService.save(comment);
				result = new ModelAndView("redirect:/lessor/myPerfil.do");

			} catch (Throwable oops) {
				System.out.println("catch");
				result = createEditModelAndView(comment, "comment.commit.error");
			}
		}
		return result;
	}

	protected ModelAndView createEditModelAndView(Comment comment) {
		ModelAndView result;

		result = createEditModelAndView(comment, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Comment comment, String message) {
		ModelAndView result;

		result = new ModelAndView("comment/postComment");

		result.addObject("comment", comment);
		result.addObject("message", message);

		return result;
	}

}
