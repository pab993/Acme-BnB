
package services;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.PropertyRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.AttributeValue;
import domain.Booking;
import domain.Lessor;
import domain.Property;

@Transactional
@Service
public class PropertyService {

	//Repository ------------------------------------------------

	@Autowired
	private PropertyRepository		propertyRepository;

	// Services -------------------------------------------------

	@Autowired
	private LessorService			lessorService;

	@Autowired
	private AttributeValueService	attributeValueService;

	@Autowired
	private BookingService			bookingService;

	@Autowired
	private Validator				validator;


	public PropertyService() {
		super();
	}

	// Simple CRUDS methods -------------------------

	public Property create() {

		UserAccount userAccount = LoginService.getPrincipal();
		Authority au = new Authority();
		au.setAuthority("LESSOR");
		Assert.isTrue(userAccount.getAuthorities().contains(au));
		Lessor lessor = lessorService.findPrincipal();
		Property property = new Property();
		property.setLessor(lessor);
		return property;
	}

	public Property findOne(int id) {

		Assert.isTrue(propertyRepository.exists(id));

		return propertyRepository.findOne(id);
	}

	public Collection<Property> findAll() {

		Collection<Property> properties;

		properties = propertyRepository.findAll();

		return properties;
	}

	public Property save(Property property) {

		Assert.notNull(property);

		Property saved = propertyRepository.save(property);

		return saved;

	}

	public void delete(Property property) { //Falta añadir los servicios AttributeValue y AttributeName para poder borrarlo

		Assert.notNull(property, "Property null");
		Assert.isTrue(propertyRepository.exists(property.getId()), "didn't found");
		long l = 10;									//Descomentar cuando se cree el servicio delete del Booking
		Boolean valor = false;
		Date d = new Date(System.currentTimeMillis() - l);
		for (Booking b : property.getBookings()) {
			if (b.getStatus() == "ACCEPTED" && b.getCheckOut().after(d)) {
				valor = true;
				break;
			}
		}
		if (valor != true) {
			for (Booking b : property.getBookings()) {
				bookingService.delete(b);
			}
		}
		for (AttributeValue av : property.getAttributeValues()) {
			attributeValueService.delete(av);
		}
		propertyRepository.delete(property);
	}

	// Others bussines methods

	public Lessor findLessorByProperty(int id) {

		Assert.notNull(id);

		Lessor lessor = propertyRepository.findLessorByProperty(id);
		Assert.notNull(lessor, "lessor not found");

		return lessor;
	}

	public Collection<Property> findAllByPrincipal() {

		Lessor principal = lessorService.findPrincipal();

		Collection<Property> properties = propertyRepository.findAllByPrincipal(principal.getId());
		Assert.notNull(properties, "no one property found");

		return properties;
	}

	public Collection<Property> findAllByLessor(Lessor lessor) {

		Collection<Property> properties;

		properties = propertyRepository.findAllByPrincipal(lessor.getId());

		return properties;
	}

	public int numBookingsAccepted(Property property) {
		int result;

		result = propertyRepository.countBooking(property.getId());

		return result;
	}

	public Double minAudits() {

		Double minAudits;

		minAudits = propertyRepository.minAudits();

		return minAudits;
	}

	public Double avgAudits() {

		Double avgAudits;

		avgAudits = propertyRepository.avgAudits();

		return avgAudits;
	}

	public Double maxAudits() {

		Double maxAudits;

		maxAudits = propertyRepository.maxAudits();

		return maxAudits;
	}

	public Collection<String> findAttNameOrderByUse() {

		Collection<String> findAttNameOrderByUse;

		findAttNameOrderByUse = propertyRepository.findAttNameOrderByUse();

		return findAttNameOrderByUse;
	}

	public Collection<Property> findPropertyByAudits(int lessorId) {

		Collection<Property> findPropertyByAudits;

		findPropertyByAudits = propertyRepository.findPropertyByAudits(lessorId);

		return findPropertyByAudits;
	}

	public Collection<Property> findPropertyByBookings(int lessorId) {

		Collection<Property> findPropertyByBookings;

		findPropertyByBookings = propertyRepository.findPropertyByBookings(lessorId);

		return findPropertyByBookings;
	}

	public Collection<Property> findPropertyByAcceptedBookings(int lessorId) {

		Collection<Property> findPropertyByAcceptedBookings;

		findPropertyByAcceptedBookings = propertyRepository.findPropertyByAcceptedBookings(lessorId);

		return findPropertyByAcceptedBookings;
	}

	public Collection<Property> findPropertyByDeniedBookings(int lessorId) {

		Collection<Property> findPropertyByDeniedBookings;

		findPropertyByDeniedBookings = propertyRepository.findPropertyByDeniedBookings(lessorId);

		return findPropertyByDeniedBookings;
	}

	public Collection<Property> findPropertyByPendingBookings(int lessorId) {

		Collection<Property> findPropertyByPendingBookings;

		findPropertyByPendingBookings = propertyRepository.findPropertyByPendingBookings(lessorId);

		return findPropertyByPendingBookings;
	}

	public Property reconstruct(Property property, BindingResult binding) {
		Property result;

		if (property.getId() == 0) {
			result = property;
			result.setLessor(lessorService.findPrincipal());
			result.setName(property.getName());
			result.setAddress(property.getAddress());
			result.setDescription(property.getDescription());
			result.setRate(property.getRate());

			validator.validate(result, binding);
		} else {
			result = propertyRepository.findOne(property.getId());

			result.setName(property.getName());
			result.setAddress(property.getAddress());
			result.setDescription(property.getDescription());
			result.setRate(property.getRate());

			validator.validate(result, binding);
		}
		return result;
	}
}
