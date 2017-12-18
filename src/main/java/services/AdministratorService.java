
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.AdministratorRepository;
import security.LoginService;
import security.UserAccount;
import domain.Administrator;

@Transactional
@Service
public class AdministratorService {

	// Managed Repository 
	// ====================================================================================

	@Autowired
	private AdministratorRepository	administratorRepository;


	// Constructor methods
	// ====================================================================================

	public AdministratorService() {
		super();
	}

	// Simple CRUDS methods 
	// ====================================================================================

	public Administrator save(Administrator administrator) {
		Assert.notNull(administrator);

		Administrator saved = administratorRepository.save(administrator);

		return saved;
	}

	public Collection<Administrator> findAll() {
		Assert.isInstanceOf(Administrator.class, findByPrincipal());

		Collection<Administrator> result;

		result = administratorRepository.findAll();

		return result;
	}

	// Others bussines methods 
	// ====================================================================================

	public Administrator findByPrincipal() {
		Administrator result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	public Administrator findByUserAccount(UserAccount userAccount) {
		Administrator result;

		result = administratorRepository.findByUserAccountId(userAccount.getId());

		return result;
	}

	public Double minSocialIdAdministrator() {
		Double result;

		result = administratorRepository.minSocialIdAdministrator();
		Assert.notNull(result);

		return result;
	}

	public Double avgSocialIdAdministrator() {
		Double result;

		result = administratorRepository.avgSocialIdAdministrator();
		Assert.notNull(result);

		return result;
	}

	public Double maxSocialIdAdministrator() {
		Double result;

		result = administratorRepository.maxSocialIdAdministrator();
		Assert.notNull(result);

		return result;
	}


	@Autowired
	Validator	validator;


	public Administrator reconstruct(Administrator administrator, BindingResult binding) {
		// TODO Auto-generated method stub
		Administrator resul;

		if (administrator.getId() == 0)
			resul = administrator;
		else {
			resul = administratorRepository.findOne(administrator.getId());

			resul.setName(administrator.getName());
			resul.setSurname(administrator.getSurname());
			resul.setPhone(administrator.getPhone());
			resul.setEmail(administrator.getEmail());
			resul.setPicture(administrator.getPicture());

			validator.validate(resul, binding);
		}

		return resul;
	}
}
