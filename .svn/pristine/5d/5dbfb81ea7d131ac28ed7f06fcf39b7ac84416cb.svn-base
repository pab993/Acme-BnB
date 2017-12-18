
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
import domain.AttributeValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AttributeValueServiceTest extends AbstractTest {

	//Service under test
	@Autowired
	public AttributeValueService	attributeValueService;


	@Test
	public void testCreateAttributeValue() {
		AttributeValue av = attributeValueService.create();
		Assert.notNull(av);
	}

	@Test
	public void testFindOneAttributeValue() {
		AttributeValue av = attributeValueService.findOne(42);
		Assert.notNull(av);
	}

	@Test
	public void testFindAllAttributeValue() {
		Collection<AttributeValue> attributeValues = attributeValueService.findAll();
		Assert.notNull(attributeValues);

	}

	@Test
	public void testSaveAttributeValue() {
		AttributeValue attributeValue = attributeValueService.findOne(42);
		AttributeValue saved = attributeValueService.save(attributeValue);
		//compruebo todo OK
		Collection<AttributeValue> attributeValues = attributeValueService.findAll();
		Assert.isTrue(attributeValues.contains(saved));

	}

	@Test
	public void testDeleteAttributeValue() {
		AttributeValue attributeValue = attributeValueService.findOne(42);
		Assert.notNull(attributeValue);
		attributeValueService.delete(attributeValue);
		//compruebo todo OK
		Collection<AttributeValue> attributeValues = attributeValueService.findAll();
		Assert.isTrue(!attributeValues.contains(attributeValue));

	}
}
