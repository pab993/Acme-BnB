
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.AttributeNameRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.AttributeName;
import domain.AttributeValue;

@Transactional
@Service
public class AttributeNameService {

	// Managed Repository 
	// ====================================================================================

	@Autowired
	private AttributeNameRepository	attributeNameRepository;

	// Supported Services 
	// ====================================================================================

	@Autowired
	private AttributeValueService	attributeValueService;

	@Autowired
	private Validator				validator;


	// Constructor methods
	// ====================================================================================

	public AttributeNameService() {
		super();
	}

	// Simple CRUDS methods 
	// ====================================================================================

	public AttributeName findOne(int attributeNameId) {
		Assert.notNull(attributeNameId);

		AttributeName result;

		result = attributeNameRepository.findOne(attributeNameId);
		Assert.notNull(result);

		return result;
	}

	public AttributeName create() {
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();

		Authority authority = new Authority();
		authority.setAuthority("ADMINISTRATOR");
		Assert.isTrue(userAccount.getAuthorities().contains(authority));

		AttributeName result = new AttributeName();
		return result;
	}

	public AttributeName save(AttributeName attributeName) {
		Assert.notNull(attributeName);

		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();

		Authority authority = new Authority();
		authority.setAuthority("ADMINISTRATOR");
		Assert.isTrue(userAccount.getAuthorities().contains(authority));

		AttributeName saved = attributeNameRepository.save(attributeName);

		return saved;
	}

	public void delete(AttributeName attributeName) {
		Assert.notNull(attributeName);
		Assert.isTrue(attributeNameRepository.exists(attributeName.getId()));

		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();

		Authority authority = new Authority();
		authority.setAuthority("ADMINISTRATOR");
		Assert.isTrue(userAccount.getAuthorities().contains(authority));

		for (AttributeValue av : attributeName.getAttributeValues()) {
			attributeValueService.delete(av);
		}

		attributeNameRepository.delete(attributeName);
	}

	public Collection<AttributeName> findAll() {

		Collection<AttributeName> attributeNames;

		attributeNames = attributeNameRepository.findAll();
		Assert.notNull(attributeNames);

		return attributeNames;
	}

	public AttributeName reconstruct(AttributeName attributeName, BindingResult binding) {
		AttributeName result;

		if (attributeName.getId() == 0) {
			result = attributeName;
		} else {
			result = attributeNameRepository.findOne(attributeName.getId());

			result.setName(attributeName.getName());

			validator.validate(result, binding);
		}
		return result;
	}
}
