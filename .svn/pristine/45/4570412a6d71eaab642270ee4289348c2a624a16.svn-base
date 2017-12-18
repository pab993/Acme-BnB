
package services;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.BookingRepository;
import domain.Booking;
import domain.Property;
import domain.Tenant;

@Service
@Transactional
public class BookingService {

	// Managed Repository 
	// ====================================================================================

	@Autowired
	private BookingRepository	bookingRepository;

	@Autowired
	private Validator			validator;

	// Supported Services 
	// ====================================================================================

	@Autowired
	private TenantService		tenantService;

	@Autowired
	private PropertyService		propertyService;

	@Autowired
	private InvoiceService		invoiceService;


	// Constructor methods
	// ====================================================================================

	public BookingService() {
		super();
	}

	// Simple CRUDS methods 
	// ====================================================================================

	public Booking create(Property property) {
		Assert.notNull(property);

		Booking result;
		Tenant principal;

		result = new Booking();
		principal = tenantService.findByPrincipal();
		Assert.notNull(principal);
		Assert.isInstanceOf(Tenant.class, principal);

		result.setTenant(principal);
		result.setProperty(property);
		result.setStatus("PENDING");

		return result;
	}

	public Booking save(Booking booking) {
		Assert.notNull(booking);
		Booking result;
		Tenant principal;

		principal = tenantService.findByPrincipal();
		Assert.notNull(principal);
		Assert.isTrue(principal.equals(booking.getTenant()));
		Assert.isInstanceOf(Tenant.class, principal);
		long l = 10;
		Date date = new Date(System.currentTimeMillis() - l);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Assert.isTrue(booking.getCheckIn().after(calendar.getTime()));
		Assert.isTrue(booking.getCheckOut().after(booking.getCheckIn()));

		result = bookingRepository.save(booking);

		return result;
	}

	public Booking save2(Booking booking) {

		Assert.notNull(booking);
		//checkPrincipal(booking);

		Booking saved = bookingRepository.save(booking);

		return saved;
	}

	private void checkPrincipal(Booking booking) {
		// TODO Auto-generated method stub

		Tenant principal = tenantService.findByPrincipal();
		Assert.isTrue(principal.getBookings().contains(booking));

	}

	public void delete(Booking booking) {
		Assert.notNull(booking);

		long l = 10;
		Date d = new Date(System.currentTimeMillis() - l);

		System.out.println("------------------------------------------------");
		System.out.println(booking.getStatus());

		Assert.isTrue(booking.getCheckOut().after(d) && booking.getStatus().equals("ACCEPTED") || booking.getStatus().equals("DENIED") || booking.getStatus().equals("PENDING"));
		bookingRepository.delete(booking);
	}
	public Booking findOne(int id) {

		Assert.isTrue(bookingRepository.exists(id));

		return bookingRepository.findOne(id);
	}

	// Others bussines methods
	// ====================================================================================

	public Collection<Booking> findAllByProperty(Property property) {
		Assert.notNull(property);
		Collection<Booking> result;

		result = bookingRepository.findAllByPropertyId(property.getId());

		return result;
	}

	public Collection<Booking> findAllByTenant(Tenant tenant) {
		Assert.notNull(tenant);
		Collection<Booking> result;

		result = bookingRepository.findAllByTenantId(tenant.getId());

		return result;
	}

	public Collection<Booking> findAllAcceptedByLessor(int id) {
		Collection<Booking> result;

		result = bookingRepository.findAllAcceptedByLessor(id);

		return result;
	}

	public Booking changeStatus(Booking booking) {
		Assert.notNull(booking);
		Property property;

		property = booking.getProperty();
		Assert.notNull(property);

		if (booking.getStatus().equals("PENDING") || booking.getStatus().equals("DENIED")) {
			booking = bookingRepository.save(booking);
		} else if (booking.getStatus().equals("ACCEPTED")) {
			property.setBookCount(property.getBookCount() + 1);
			propertyService.save(property);
			invoiceService.create(booking);
			booking = bookingRepository.save(booking);
		} else {
			booking.setStatus("PENDING");
			booking = bookingRepository.save(booking);
		}

		return booking;
	}

	public Booking reconstruct(Booking booking, BindingResult binding) {
		Booking result;

		result = bookingRepository.findOne(booking.getId());

		result.setStatus(booking.getStatus());

		validator.validate(result, binding);

		return result;
	}
}
