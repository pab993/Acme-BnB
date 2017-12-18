
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.SocialIdentityRepository;
import security.LoginService;
import security.UserAccount;
import domain.Actor;
import domain.SocialIdentity;

@Service
@Transactional
public class SocialIdentityService {

	@Autowired
	private SocialIdentityRepository	socialIdentityRepository;
	
	@Autowired private ActorService actorService;

	public SocialIdentityService() {
		super();
	}

	// Simple CRUD methods ---------------------------

	public SocialIdentity create() {

		SocialIdentity socialIdentity = new SocialIdentity();
		Actor actor = actorService.findByPrincipal();
		
		socialIdentity.setActor(actor);
		return socialIdentity;
	}


	public SocialIdentity findOneByPrincipal(int id) {

		SocialIdentity socialIdentity = socialIdentityRepository.findOne(id);

		checkPrincipal(socialIdentity);

		return socialIdentity;
	}

	public SocialIdentity save(SocialIdentity socialIdentity) {

		Assert.notNull(socialIdentity);
		checkPrincipal(socialIdentity);

		SocialIdentity saved = socialIdentityRepository.save(socialIdentity);

		return saved;
	}

	public void delete(SocialIdentity socialIdentity) {

		Assert.isTrue(socialIdentityRepository.exists(socialIdentity.getId()), "didn't found");
		checkPrincipal(socialIdentity);

		socialIdentityRepository.delete(socialIdentity.getId());
	}

	// Others business methods -----------------------

	private void checkPrincipal(SocialIdentity socialIdentity) {
		// TODO Auto-generated method stub

		UserAccount principal = LoginService.getPrincipal();

		Assert.isTrue(socialIdentity.getActor().getUserAccount().getId()== principal.getId(), "you haven't authorization");
	}


	@Autowired private Validator validator;
	
	public SocialIdentity reconstruct(SocialIdentity socialIdentity, BindingResult binding) {
		// TODO Auto-generated method stub
		
		SocialIdentity resul;
		
		if(socialIdentity.getId() == 0)
			resul = create();
		
		else
			resul = socialIdentityRepository.findOne(socialIdentity.getId());
		
		resul.setNick(socialIdentity.getNick());
		resul.setNetwork(socialIdentity.getNetwork());
		resul.setUrl(socialIdentity.getUrl());
		
		validator.validate(resul, binding);
		
		return resul;
	}

	public  Collection<SocialIdentity> findAllByPrincipal() {
		// TODO Auto-generated method stub
		
		Actor actor = actorService.findByPrincipal();
		
		Collection<SocialIdentity> socialIdentities = socialIdentityRepository.findAllByPrincipal(actor.getId());
		
		return socialIdentities;
	}
}
