
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
import domain.Finder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class FinderServiceTest extends AbstractTest {

	//Service under test
	// ====================================================================================

	@Autowired
	public FinderService	finderService;


	//Tests
	// ====================================================================================

	@Test
	public void testCreateFinder() {
		Finder l = finderService.create();
		Assert.notNull(l);
	}

	@Test
	public void testSaveFinder() {
		authenticate("tenant1");
		Finder finder = finderService.findOne(13);
		Finder saved = finderService.save(finder);
		//compruebo todo OK
		Collection<Finder> finders = finderService.findAll();
		Assert.isTrue(finders.contains(saved));
	}

	@Test
	public void testFindOneFinder() {
		Finder l = finderService.findOne(13);
		Assert.notNull(l);
	}

	@Test
	public void testFindAllFinders() {
		Collection<Finder> finders = finderService.findAll();
		Assert.notNull(finders);

	}

}
