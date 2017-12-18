
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
import domain.Auditor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AuditorServiceTest extends AbstractTest {

	//Service under test
	@Autowired
	public AuditorService	auditorService;


	// Simple CRUDS methods -------------------------
	@Test
	public void testCreateAuditor() {
		Auditor a = auditorService.create();
		Assert.notNull(a);
	}

	@Test
	public void testFindOneAuditor() {
		Auditor a = auditorService.findOne(54);
		Assert.notNull(a);
	}

	@Test
	public void testFindAllAuditor() {
		Collection<Auditor> auditors = auditorService.findAll();
		Assert.notNull(auditors);

	}

	@Test
	public void testSaveAuditor() {
		Auditor auditor = auditorService.findOne(54);
		Auditor saved = auditorService.save(auditor);
		//compruebo todo OK
		Collection<Auditor> auditors = auditorService.findAll();
		Assert.isTrue(auditors.contains(saved));

	}
}
