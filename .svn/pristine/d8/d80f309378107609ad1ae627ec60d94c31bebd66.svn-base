
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
import domain.AttributeName;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})

@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AttributeNameServiceTest extends AbstractTest {

	//Service under test
	@Autowired
	public AttributeNameService	attributeNameService;

	@Test
	public void testCreateAttributeName() {
		authenticate("admin");
		AttributeName an = attributeNameService.create();
		Assert.notNull(an);
	}

	@Test
	public void testFindOneAttributeName() {
		AttributeName an = attributeNameService.findOne(40);
		Assert.notNull(an);
	}

	@Test
	public void testFindAllAttributeName() {
		Collection<AttributeName> attributeNames = attributeNameService.findAll();
		Assert.notNull(attributeNames);

	}

	@Test
	public void testSaveAttributeName() {
		authenticate("admin");
		AttributeName attributeName = attributeNameService.findOne(40);
		AttributeName saved = attributeNameService.save(attributeName);
		//compruebo todo OK
		Collection<AttributeName> attributeNames = attributeNameService.findAll();
		Assert.isTrue(attributeNames.contains(saved));

	}

	@Test
	public void testDeleteAttributeName() {
		authenticate("admin");
		AttributeName attributeName = attributeNameService.findOne(40);
		Assert.notNull(attributeName);
		attributeNameService.delete(attributeName);
		//compruebo todo OK
		Collection<AttributeName> attributeNames = attributeNameService.findAll();
		Assert.isTrue(!attributeNames.contains(attributeName));

	}

}
