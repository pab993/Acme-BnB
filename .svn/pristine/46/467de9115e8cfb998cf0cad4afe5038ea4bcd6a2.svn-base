
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
import domain.Property;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class PropertyServiceTest extends AbstractTest {

	//Service under test
	@Autowired
	public PropertyService	propertyService;


	@Test
	public void testCreateProperty() {
		authenticate("lessor1");
		Property p = propertyService.create();
		Assert.notNull(p);
	}

	@Test
	public void testFindOneProperty() {
		Property p = propertyService.findOne(34);
		Assert.notNull(p);
	}

	@Test
	public void testFindAllProperty() {
		Collection<Property> properties = propertyService.findAll();
		Assert.notNull(properties);

	}

	@Test
	public void testSaveProperty() {
		Property property = propertyService.findOne(34);
		Property saved = propertyService.save(property);
		//compruebo todo OK
		Collection<Property> properties = propertyService.findAll();
		Assert.isTrue(properties.contains(saved));

	}

	@Test
	public void testDeleteProperty() {
		authenticate("lessor2");
		Property property = propertyService.findOne(35);
		Assert.notNull(property);
		propertyService.delete(property);
		//compruebo todo OK
		Collection<Property> properties = propertyService.findAll();
		Assert.isTrue(!properties.contains(property));

	}

	// Others bussines methods-------------------------------------

	@Test
	public void testFindLessorByProperty() {
		Property property = propertyService.findOne(34);
		Assert.notNull(property);

		Lessor l = propertyService.findLessorByProperty(property.getId());
		Assert.notNull(l);

		System.out.println("------------------------------------------------");
		System.out.println(l);
	}
}
