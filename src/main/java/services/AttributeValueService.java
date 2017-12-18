
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.AttributeValueRepository;
import domain.AttributeValue;

@Transactional
@Service
public class AttributeValueService {

	// Managed Repository 
	// ====================================================================================

	@Autowired
	private AttributeValueRepository	attributeValueRepository;

	@Autowired
	private Validator					validator;


	// Constructor methods
	// ====================================================================================

	public AttributeValueService() {
		super();
	}

	// Simple CRUDS methods 
	// ====================================================================================

	public AttributeValue findOne(int attributeValueId) {

		AttributeValue result;
		Assert.notNull(attributeValueId);

		result = attributeValueRepository.findOne(attributeValueId);
		Assert.notNull(result);

		return result;
	}

	public AttributeValue create() {

		AttributeValue result;

		result = new AttributeValue();

		return result;
	}

	public AttributeValue save(AttributeValue attributeValue) {
		Assert.notNull(attributeValue);

		Collection<AttributeValue> attributeValues;

		attributeValues = attributeValueRepository.findAllByPropertyId(attributeValue.getProperty().getId());

		for (AttributeValue attrv : attributeValues) {
			if (attrv.getId() == attributeValue.getId()) {

			} else {
				Assert.isTrue(attrv.getAttributeName() != attributeValue.getAttributeName());
			}
		}
		AttributeValue result = attributeValueRepository.save(attributeValue);

		return result;
	}

	public void delete(AttributeValue attributeValue) {
		Assert.notNull(attributeValue);
		Assert.isTrue(attributeValueRepository.exists(attributeValue.getId()));

		attributeValueRepository.delete(attributeValue);
	}

	public Collection<AttributeValue> findAll() {

		Collection<AttributeValue> attributeValues;

		attributeValues = attributeValueRepository.findAll();
		Assert.notNull(attributeValues);

		return attributeValues;
	}

	public Collection<AttributeValue> findAllByPropertyId(int propertyId) {
		Collection<AttributeValue> attributeValues;

		attributeValues = attributeValueRepository.findAllByPropertyId(propertyId);
		Assert.notNull(attributeValues);

		return attributeValues;
	}

	public AttributeValue reconstruct(AttributeValue attributeValue, BindingResult binding) {
		AttributeValue result;

		if (attributeValue.getId() == 0) {
			result = attributeValue;
			result.setAttributeName(attributeValue.getAttributeName());
			result.setValue(attributeValue.getValue());
			result.setProperty(attributeValue.getProperty());

			validator.validate(result, binding);
		} else {
			result = attributeValueRepository.findOne(attributeValue.getId());

			result.setValue(attributeValue.getValue());
			result.setAttributeName(attributeValue.getAttributeName());

			validator.validate(result, binding);
		}
		return result;
	}
}
