package controllers.tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.BookingService;
import services.InvoiceService;
import controllers.AbstractController;
import domain.Booking;
import domain.Invoice;

@Controller
@RequestMapping("/invoice/tenant")
public class InvoiceTenantController extends AbstractController {

	// Services
	
	@Autowired private InvoiceService invoiceService;
	@Autowired private BookingService bookingService;

	
	public InvoiceTenantController(){
		super();
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView create(int bookingId){
		
		ModelAndView resul;
		Booking booking = bookingService.findOne(bookingId);
		
		// Genero factura y la almaceno
		
		Invoice  invoice = invoiceService.create(booking);
		Invoice saved = invoiceService.save(invoice);
		
		// Asigno factura a la reserva y la almaceno
		
		booking.setInvoice(saved);
		bookingService.save(booking);
				
		resul = new ModelAndView("invoice/edit");
		resul.addObject("invoice", saved);
		
		return resul;
	}
	
	@RequestMapping(value="display", method=RequestMethod.GET)
	public ModelAndView display(@RequestParam int invoiceId){
		
		ModelAndView resul;
		
		Invoice invoice = invoiceService.findOne(invoiceId);
		
		resul = new ModelAndView("invoice/display");
		resul.addObject("invoice", invoice);
		
		return resul;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
	public ModelAndView save(Invoice invoice, BindingResult binding){
		
		ModelAndView resul;
		
		try{
			
			invoice = invoiceService.reconstruct(invoice, binding);
			invoiceService.save(invoice);
			resul = new ModelAndView("redirect:/tenant/tenant/listTenant.do");
			
		}catch (Throwable oops) {
			resul = createEditView(
				invoice, "invoice.commit.error");
		}
		
		
		return resul;
	}

	private ModelAndView createEditView(Invoice invoice, String message) {
		// TODO Auto-generated method stub
		
		ModelAndView resul = new ModelAndView("invoice/edit");
		
		resul.addObject("invoice", invoice);
		resul.addObject("message", message);
		
		return resul;
	}
}
