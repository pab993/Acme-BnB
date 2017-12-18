
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import repositories.AuditorRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Audit;
import domain.Auditor;
import domain.SocialIdentity;
import forms.AuditorForm;

@Transactional
@Service
public class AuditorService {

	// Managed Repository 
	// ====================================================================================

	@Autowired
	private AuditorRepository	auditorRepository;


	// Supported Services 
	// ====================================================================================

	// Constructor methods
	// ====================================================================================

	// Simple CRUDS methods 
	// ====================================================================================

	public Auditor create() {
		UserAccount userAccount;
		Auditor result;
		Authority authority;
		Collection<Authority> authorities;

		authorities = new ArrayList<Authority>();

		userAccount = new UserAccount();
		result = new Auditor();
		authority = new Authority();
		authority.setAuthority("AUDITOR");
		authorities.add(authority);
		userAccount.setAuthorities(authorities);
		result.setUserAccount(userAccount);

		return result;
	}

	public Auditor findOne(int auditorId) {
		Assert.notNull(auditorId);

		Auditor result;

		result = auditorRepository.findOne(auditorId);
		Assert.notNull(result);

		return result;
	}

	public Auditor save(Auditor auditor) {

		Assert.notNull(auditor);
		//		String password = auditor.getUserAccount().getPassword();
		//		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		//		String md5 = encoder.encodePassword(password, null);
		//		auditor.getUserAccount().setPassword(md5);

		Auditor saved = auditorRepository.save(auditor);
		return saved;

	}

	public Collection<Auditor> findAll() {
		Collection<Auditor> auditors;

		auditors = auditorRepository.findAll();
		Assert.notNull(auditors);

		return auditors;
	}

	// Others bussines methods ----------------------------------

	public Auditor findByPrincipal() {
		Auditor result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	public Auditor findByUserAccount(UserAccount userAccount) {
		Auditor result;

		result = auditorRepository.findByUserAccountId(userAccount.getId());

		return result;
	}

	public Auditor reconstruct(AuditorForm auditorForm, BindingResult binding) {
		Auditor auditor;
		Collection<SocialIdentity> socialIdentities;
		Collection<Audit> audits;

		auditor = new Auditor();
		socialIdentities = new ArrayList<SocialIdentity>();
		audits = new ArrayList<Audit>();

		Md5PasswordEncoder encode = new Md5PasswordEncoder();
		String hash = encode.encodePassword(auditorForm.getPassword(), null);

		Authority authority = new Authority();
		UserAccount userAccount = new UserAccount();

		authority.setAuthority("AUDITOR");
		userAccount.addAuthority(authority);
		auditor.setUserAccount(userAccount);
		auditor.getUserAccount().setUsername(auditorForm.getUsername());
		auditor.setName(auditorForm.getName());
		auditor.setSurname(auditorForm.getSurname());
		auditor.setEmail(auditorForm.getEmail());
		auditor.setPhone(auditorForm.getPhone());
		auditor.setPicture(auditorForm.getPicture());
		auditor.setCompany(auditorForm.getCompany());
		auditor.setSocialIdentities(socialIdentities);
		auditor.setAudits(audits);

		if (!auditorForm.getPassword().equals(auditorForm.getRepeatPassword())) {
			ObjectError error = new ObjectError(hash, "Password mismatch");
			binding.addError(error);
		} else {
			auditor.getUserAccount().setPassword(hash);
		}

		return auditor;
	}

	public Auditor findPrincipal() {
		// TODO Auto-generated method stub
		Auditor principal = auditorRepository.findPrincipal(LoginService.getPrincipal().getId());
		Assert.notNull(principal, "principal is not lessor");

		return principal;
	}


	@Autowired
	private Validator	validator;


	public Auditor reconstruct(Auditor auditor, BindingResult binding) {
		// TODO Auto-generated method stub
		Auditor resul;

		if (auditor.getId() == 0)
			resul = auditor;
		else {
			resul = auditorRepository.findOne(auditor.getId());

			resul.setName(auditor.getName());
			resul.setSurname(auditor.getSurname());
			resul.setPhone(auditor.getPhone());
			resul.setEmail(auditor.getEmail());
			resul.setPicture(auditor.getPicture());
			resul.setCompany(auditor.getCompany());

			validator.validate(resul, binding);
		}

		return resul;
	}

	public Double minSocialIdAuditor() {
		Double result;

		result = auditorRepository.minSocialIdAuditor();
		Assert.notNull(result);

		return result;
	}

	public Double avgSocialIdAuditor() {
		Double result;

		result = auditorRepository.avgSocialIdAuditor();
		Assert.notNull(result);

		return result;
	}

	public Double maxSocialIdAuditor() {
		Double result;

		result = auditorRepository.maxSocialIdAuditor();
		Assert.notNull(result);

		return result;
	}

}
