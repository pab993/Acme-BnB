
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import utilities.AbstractTest;
import domain.Booking;
import domain.Property;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class BookingServiceTest extends AbstractTest {

	//Service under test
	// ====================================================================================

	@Autowired
	public BookingService	bookingService;

	@Autowired
	public PropertyService	propertyService;


	/**
	 * ################################################################
	 * 
	 * TEST POSITIVOS
	 * 
	 * #################################################################
	 */

	@Test
	public void testFindAllBySponsorPositive() {
		System.out.println("--------------------------Find All By Property--------------------------");
		authenticate("lessor1");

		Collection<Booking> result;
		Property property;

		property = propertyService.findOne(34);
		result = bookingService.findAllByProperty(property);

		System.out.println("Number of Bookings from Property " + property.getId() + " - " + result.size());

		for (Booking booking : result) {
			String s = "";
			System.out.println(s = s + "Booking ID: " + booking.getId());
		}
		authenticate(null);
		System.out.println("----------------------------------------------------------------");
	}

	@Test
	public void testChangeStatus() {
		Booking b = bookingService.findOne(46);
		b.setStatus("DENIED");
		Booking changed = bookingService.changeStatus(b);
		Booking b1 = bookingService.findOne(changed.getId());
		System.out.println("------------------------------------------------");
		System.out.println(b1.getStatus());
	}

	/**
	 * ################################################################
	 * 
	 * TEST NEGATIVOS
	 * 
	 * #################################################################
	 */

	@Test
	public void testFindAllBySponsorNegative() {
		System.out.println("--------------------------Find All By Property--------------------------");
		authenticate("lessor1");

		Collection<Booking> result;
		Property property;

		property = propertyService.findOne(34);
		result = bookingService.findAllByProperty(property);

		System.out.println("Number of Bookings from Property " + property.getId() + " - " + result.size());

		for (Booking booking : result) {
			String s = "";
			System.out.println(s = s + "Booking ID: " + booking.getId());
		}
		authenticate(null);
		System.out.println("----------------------------------------------------------------");
	}

}
