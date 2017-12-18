package controllers.administrator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.AdministratorService;
import services.SocialIdentityService;
import controllers.AbstractController;
import domain.Administrator;
import domain.SocialIdentity;

@Controller
@RequestMapping("/administrator/administrator")
public class AdministratorAdministratorController extends AbstractController {

	@Autowired private AdministratorService administratorService;
	@Autowired private SocialIdentityService identityService;
	
	public AdministratorAdministratorController(){
		super();
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView edit(){
		
		Administrator administrator = administratorService.findByPrincipal();
		
		ModelAndView resul = new ModelAndView("administrator/edit");
		resul.addObject("administrator", administrator);
		resul.addObject("socialIdentities", administrator.getSocialIdentities());
		
		resul.addObject("requestURI", "administrator/administrator/edit.do");
		return resul;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(Administrator administrator, BindingResult binding) {

		ModelAndView resul;
		Collection<SocialIdentity> socialIdentities = identityService.findAllByPrincipal();

		
			try {
				administrator = administratorService.reconstruct(administrator, binding);
				administratorService.save(administrator);
				
				resul = createEditModelAndView(administrator, socialIdentities);
			} catch (Throwable oops) {
				resul = createEditModelAndView(administrator, socialIdentities, "adminisrator.commit.error");
			}


		return resul;
	}

	
	
	private ModelAndView createEditModelAndView(Administrator administrator, Collection<SocialIdentity> socialIdentities) {
		// TODO Auto-generated method stub
		return createEditModelAndView(administrator, socialIdentities, "administrator.commit.save");
	}

	private ModelAndView createEditModelAndView(Administrator administrator, Collection<SocialIdentity> socialIdentities, String message) {
		// TODO Auto-generated method stub
		
		ModelAndView resul = new ModelAndView("administrator/edit");
		resul.addObject("administrator", administrator);
		resul.addObject("socialIdentities", socialIdentities);
		
		resul.addObject("requestURI", "administrator/administrator/edit.do");
		
		resul.addObject("message", message);
		return resul;
	}
}
