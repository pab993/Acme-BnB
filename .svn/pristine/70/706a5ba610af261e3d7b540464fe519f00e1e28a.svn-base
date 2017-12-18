
package services;

import java.util.Date;

import javax.transaction.Transactional;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.InvoiceRepository;
import security.Authority;
import domain.Booking;
import domain.Invoice;
import domain.Tenant;

@Transactional
@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository	invoiceRepository;

	// Auxiliar services
	// ==========================================================================

	@Autowired
	private TenantService		tenantService;


	public InvoiceService() {
		super();
	}

	// Simple CRUDs methods 
	// ==========================================================================

	public Invoice findOne(int id) {

		Assert.notNull(id);
		Assert.isTrue(invoiceRepository.exists(id));

		Invoice invoice = invoiceRepository.findOne(id);

		return invoice;
	}

	public Invoice create(Booking booking) {

		// comprobaciones ***************
		//		Tenant principal = tenantService.findPrincipal();
		//		checkIsTenant(principal);
		// ******************************

		Invoice result;

		result = new Invoice();
		result.setCreateMoment(new Date(System.currentTimeMillis() - 100));
		result.setVatNumber("ACME987754321");
		result.setInformation(booking.getTenant().getName() + " - " + booking.getTenant().getPhone() + " - " + booking.getTenant().getEmail());
		result.setDetails("details optional");

		Double pricePerDay = booking.getProperty().getRate();
		Integer daysBooked = getDaysBooked(booking);

		result.setAmount(pricePerDay * daysBooked);

		return result;
	}

	// Auxiliar methods
	//======================================

	//		  public Invoice save(Invoice invoice, Booking booking) {	  
	//		  
	//		  Assert.notNull(invoice);
	//		  Assert.isTrue(booking.getStatus().equals("ACCEPTED"), "STATUS error"); //requisito que sea aceptado
	//		  
	//		  invoice.setAmount(getAmount(booking));
	//		  booking.setInvoice(invoice);
	//		  
	//		  Invoice saved = invoiceRepository.save(invoice);
	//		  bookingService.save(booking);
	//		  
	//		  return saved;
	//		  }

	// Others bussines methods -------------
	// ==========================================================================

	public Invoice findMostRecent() {

		return invoiceRepository.findMostRecent().iterator().next();
	}

	// Auxliliar privates methods ------------
	// ==========================================================================

	private String createVatNumber() {
		// TODO Auto-generated method stub

		String resul = "";
		String lastCode = findMostRecent().getVatNumber();

		if (lastCode == null) 								//no code == no invoice
			lastCode = "ACME000000001";						// generate first code
		else {												// increment +1 the code
			String subString = lastCode.substring(4);		// get numeric part	
			int aux = Integer.parseInt(subString);
			aux++;											// incremento

			String formatted = String.format("%09d", aux);	// store numeric format correctly ACME+9D

			lastCode = "ACME" + formatted;					//	concat string ACME + 9{d}
		}

		resul = lastCode;

		return resul;
	}
	private void checkIsTenant(Tenant principal) {
		// TODO Auto-generated method stub

		Authority authority = new Authority();
		authority.setAuthority("TENANT");

		Assert.isTrue(principal.getUserAccount().getAuthorities().contains(authority), "principal must be tenant");
	}

	private Integer getDaysBooked(Booking booking) {

		Integer resul = 0;

		resul = Days.daysBetween(new LocalDate(booking.getCheckIn()), new LocalDate(booking.getCheckOut())).getDays();

		return resul;
	}

	public Invoice save(Invoice invoice) {
		// TODO Auto-generated method stub
		Assert.notNull(invoice);
		Invoice saved = invoiceRepository.save(invoice);

		return saved;
	}


	@Autowired
	Validator	validator;


	public Invoice reconstruct(Invoice invoice, BindingResult binding) {
		// TODO Auto-generated method stub

		Invoice result = invoiceRepository.findOne(invoice.getId());

		result.setDetails(invoice.getDetails());

		validator.validate(result, binding);

		return result;
	}

	//		private Double getAmount(Booking booking) {
	//			// TODO Auto-generated method stub
	//			
	//			int daysBooked = booking.getDaysBooked();
	//			double priceByDay  = booking.getProperty().getRate();
	//			
	//			Double resul = daysBooked * priceByDay;
	//			
	//			return resul;
	//		}
}
