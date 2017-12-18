
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import utilities.AbstractTest;
import domain.Lessor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class LessorServiceTest extends AbstractTest {

	//Service under test
	// ====================================================================================

	@Autowired
	public LessorService	lessorService;


	/**
	 * ################################################################
	 * 
	 * TEST POSITIVOS
	 * 
	 * #################################################################
	 */

	@Test
	public void testCreateLessor() {
		Lessor l = lessorService.create();
		Assert.notNull(l);
	}

	@Test
	public void testFindOneLessor() {
		Lessor l = lessorService.findOne(20);
		Assert.notNull(l);
	}

	@Test
	public void testFindAllLessor() {
		Collection<Lessor> lessors = lessorService.findAll();
		Assert.notNull(lessors);

	}

	@Test
	public void testSaveLessor() {
		Lessor lessor = lessorService.findOne(20);
		Lessor saved = lessorService.save(lessor);
		//compruebo todo OK
		Collection<Lessor> lessors = lessorService.findAll();
		Assert.isTrue(lessors.contains(saved));

	}

	@Test
	public void testCalculateAmount() {
		authenticate("lessor1");

		Lessor lessor = lessorService.findOne(18);
		Assert.notNull(lessor);

		Double result = lessorService.calculateAmount(lessor);

		System.out.println("-----------------------------------------------");
		System.out.println("Total amount of Lessor " + lessor.getId() + " : " + result);

	}

}
