package controllers.auditor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.AuditorService;
import services.SocialIdentityService;
import controllers.AbstractController;
import domain.Auditor;
import domain.SocialIdentity;


@Controller
@RequestMapping("/auditor/auditor")
public class AuditorAuditorController extends AbstractController {

	//Services
	@Autowired private AuditorService auditorService;
	@Autowired private SocialIdentityService identityService;
	
	// Edit
	// ====================================================================
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(){
		
		Auditor auditor = auditorService.findPrincipal();
		
		Collection<SocialIdentity> socialIdentities = auditor.getSocialIdentities();
		
		ModelAndView resul = new ModelAndView("auditor/edit");
		resul.addObject("auditor", auditor);
		resul.addObject("socialIdentities", socialIdentities);
		
		return resul;
	}
	
	@Autowired
	Validator validator;
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params="save")
	public ModelAndView save(Auditor auditor, BindingResult binding){
		
		ModelAndView resul;
		Collection<SocialIdentity> socialIdentities = identityService.findAllByPrincipal();
		

				try {
					auditor = auditorService.reconstruct(auditor, binding);
					auditorService.save(auditor);
					resul = createEditModelAndView(auditor, socialIdentities, "auditor.commit.save");
				} catch (Throwable oops) {
					resul = createEditModelAndView(auditor, socialIdentities, "auditor.commit.error");
				}
			
		
		return resul;
	}

	
	// Others methods
	// ============================================
	
	private ModelAndView createEditModelAndView(Auditor auditor,Collection<SocialIdentity> socialIdentities, String message) {
		// TODO Auto-generated method stub
		
		ModelAndView resul;
		
		resul = new ModelAndView("auditor/edit");
		resul.addObject("auditor", auditor);
		resul.addObject("socialIdentities", socialIdentities);
		resul.addObject("requestURI", "auditor/auditor/edit.do");
		
		resul.addObject("message", message);
		return resul;
	}


	
}
