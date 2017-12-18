package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import security.Authority;
import security.LoginService;
import security.UserAccount;
import services.AdministratorService;
import services.AuditorService;
import services.LessorService;
import services.SocialIdentityService;
import services.TenantService;
import controllers.administrator.AdministratorAdministratorController;
import controllers.auditor.AuditorAuditorController;
import controllers.lessor.LessorLessorControler;
import controllers.tenant.TenantTenantController;
import domain.Administrator;
import domain.Auditor;
import domain.Lessor;
import domain.SocialIdentity;
import domain.Tenant;

@Controller
@RequestMapping("/socialIdentity")
public class SocialIdentityControler {
	
	@Autowired LessorLessorControler lessorControler = new LessorLessorControler();
	@Autowired TenantTenantController tenantController = new TenantTenantController();
	@Autowired AdministratorAdministratorController administratorController = new AdministratorAdministratorController();
	@Autowired AuditorAuditorController auditorController = new AuditorAuditorController();
	
	@Autowired private SocialIdentityService socialService;
	@Autowired private LessorService lessorService;
	@Autowired private TenantService tenantService;
	@Autowired private AdministratorService administratorService;
	@Autowired private AuditorService auditorService;
	
	public SocialIdentityControler(){
		super();
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView resul = new ModelAndView("socialIdentity/edit");
		SocialIdentity socialIdentity = socialService.create();
		
		resul.addObject("socialIdentity", socialIdentity);
		
		return resul;
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int idSocialIdentity){
		
		SocialIdentity socialIdentity = socialService.findOneByPrincipal(idSocialIdentity);
		
		ModelAndView resul = new ModelAndView("socialIdentity/edit");
		resul.addObject("socialIdentity", socialIdentity);
		
		return resul;
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST, params="save")
	public ModelAndView save(SocialIdentity socialIdentity, BindingResult binding){
		
		ModelAndView resul;
		
		
		
		try {
			
			socialIdentity = socialService.reconstruct(socialIdentity, binding);

			socialService.save(socialIdentity);
			
			Authority a1 = new Authority();
			a1.setAuthority("LESSOR");
			Authority a2 = new Authority();
			a2.setAuthority("TENANT");
			Authority a3 = new Authority();
			a3.setAuthority("ADMINISTRATOR");
			Authority a4 = new Authority();
			a4.setAuthority("AUDITOR");
			
			UserAccount principal = LoginService.getPrincipal();
			
			if(principal.getAuthorities().iterator().next().getAuthority().equals("LESSOR"))
				resul = new ModelAndView("redirect:/lessor/lessor/edit.do");
			else if(principal.getAuthorities().iterator().next().getAuthority().equals("TENANT")){
				resul = new ModelAndView("redirect:/tenant/tenant/edit.do");
			}
			else if(principal.getAuthorities().iterator().next().getAuthority().equals("ADMINISTRATOR")){
				
				resul = new ModelAndView("redirect:/administrator/administrator/edit.do");
			}
			else{
				resul = new ModelAndView("redirect:/auditor/auditor/edit.do");
			}
			
			
		} catch (Throwable oops) {
			// TODO: handle exception
			resul = createEditModelAndView(
				socialIdentity, "socialIdentity.commit.error");
		
		
		}
		
		
		return resul;
	}

	private ModelAndView createEditModelAndView(SocialIdentity socialIdentity, String message) {
		// TODO Auto-generated method stub
		
		ModelAndView resul = new ModelAndView("socialIdentity/edit");
		
		resul.addObject("socialIdentity", socialIdentity);
		
		resul.addObject("message", message);
		return resul;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam int idSocialIdentity){
		
		
		
		SocialIdentity socialIdentity = socialService.findOneByPrincipal(idSocialIdentity);
		ModelAndView resul;
		
		//
		
		UserAccount principal = LoginService.getPrincipal();
		Authority authority = principal.getAuthorities().iterator().next();
		
		//
		
		try {
			
			socialService.delete(socialIdentity);
			
			if(authority.getAuthority().equals("LESSOR"))
				resul = new ModelAndView("redirect:/lessor/lessor/edit.do");
			else if(authority.getAuthority().equals("TENANT"))
				resul = new ModelAndView("redirect:/tenant/tenant/edit.do");
			else if(authority.getAuthority().equals("ADMINISTRATOR"))
				resul = new ModelAndView("redirect:/administrator/administrator/edit.do");
			else
				resul = new ModelAndView("redirect:/auditor/auditor/edit.do");
			
		} catch (Throwable opps) {
			// TODO: handle exception
			
			if(authority.getAuthority().equals("LESSOR"))
				resul = createLessorEditModelAndView(
					lessorService.findPrincipal(), "lessor.commit.error");
			else if(authority.getAuthority().equals("TENANT"))
				resul = createTenantEditModelAndView(
					tenantService.findByPrincipal(), "lessor.commit.error");
			else if(authority.getAuthority().equals("ADMINISTRATOR"))
				resul = createAdministratorEditModelAndView(
					administratorService.findByPrincipal(), "lessor.commit.error");
			else	
				resul = createAuditorEditModelAndView(
					auditorService.findByPrincipal(), "lessor.commit.error");
		}
		
		return resul;
	}
	
	
	
	// ARCILLARY METHODS
	
	private ModelAndView createAuditorEditModelAndView(Auditor auditor, String message) {
		// TODO Auto-generated method stub
		ModelAndView resul;
		
		resul = auditorController.edit();
		resul.addObject("auditor", auditor);
		
		resul.addObject("message", message);
		return resul;
	}

	private ModelAndView createAdministratorEditModelAndView(Administrator administrator, String message) {
		// TODO Auto-generated method stub
		ModelAndView resul;
		
		resul = administratorController.edit();
		resul.addObject("administrator", administrator);
		
		resul.addObject("message", message);
		return resul;
	}

	private ModelAndView createLessorEditModelAndView(Lessor lessor, String message) {
		// TODO Auto-generated method stub
		
		ModelAndView resul;
		
		resul = lessorControler.edit();
		resul.addObject("lessor", lessor);
		
		resul.addObject("message", message);
		return resul;
	}
	
	private ModelAndView createTenantEditModelAndView(Tenant tenant, String message) {
		// TODO Auto-generated method stub
		
		ModelAndView resul;
		
		resul = tenantController.edit();
		resul.addObject("tenant", tenant);
		
		resul.addObject("message", message);
		return resul;
	}
	
}
