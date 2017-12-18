
package services;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import utilities.AbstractTest;
import domain.Audit;
import domain.Property;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AuditServiceTest extends AbstractTest {

	//Service under test
	// ====================================================================================

	@Autowired
	public AuditService		auditService;

	@Autowired
	public AuditorService	auditorService;

	@Autowired
	public PropertyService	propertyService;


	// Tests 
	// =========================================================================================

	/**
	 * ################################################################
	 * 
	 * TEST POSITIVOS
	 * 
	 * #################################################################
	 */

	// Simple CRUDS methods -------------------------

	//	@Test
	//	public void testCreateAudit() {
	//		authenticate("auditor1");
	//		Audit a = auditService.create();
	//		Assert.notNull(a);
	//	}

	@Test
	public void testFindAllBySponsorPositive() {
		System.out.println("--------------------------Find All By Property--------------------------");
		authenticate("auditor1");

		Collection<Audit> result;
		Property property;

		property = propertyService.findOne(34);
		result = auditService.findAllByProperty(property.getId());

		System.out.println("Number of Audits from Property " + property.getId() + " - " + result.size());

		for (Audit audit : result) {
			String s = "";
			System.out.println(s = s + "Audit ID: " + audit.getId());
		}
		authenticate(null);
		System.out.println("----------------------------------------------------------------");
	}

	@Test
	public void testCreatePositive() {
		System.out.println("-----------------------------Create-----------------------------");
		authenticate("auditor1");

		Audit audit;
		Property property;

		property = propertyService.findOne(34);
		audit = auditService.create(property);

		System.out.println("Create moment: " + audit.getCreateMoment());
		System.out.println("Text: " + audit.getText());
		System.out.println("Attachments: " + audit.getAttachments());
		System.out.println("Draft: " + audit.getDraft());
		System.out.println("Auditor: " + audit.getAuditor());

		authenticate(null);
		System.out.println("----------------------------------------------------------------");
	}

	@Test
	public void testSavePositive() {
		System.out.println("-----------------------------Save-----------------------------");
		authenticate("auditor1");

		Audit audit;
		Date createMoment;
		Property property;

		property = propertyService.findOne(34);
		audit = auditService.create(property);
		createMoment = new Date(System.currentTimeMillis());

		audit.setCreateMoment(createMoment);

		audit = auditService.save(audit);

		System.out.println("Create moment: " + audit.getCreateMoment());
		System.out.println("Text: " + audit.getText());
		System.out.println("Attachments: " + audit.getAttachments());
		System.out.println("Draft: " + audit.getDraft());
		System.out.println("Auditor: " + audit.getAuditor());

		authenticate(null);
		System.out.println("----------------------------------------------------------------");
	}

	//	@Test
	//	public void testFindOneAudit() {
	//		Audit a = auditService.findOne(46);
	//		Assert.notNull(a);
	//	}
	//
	//	@Test
	//	public void testFindAllAudit() {
	//		Collection<Audit> audits = auditService.findAll();
	//		Assert.notNull(audits);
	//
	//	}
	//
	//	@Test
	//	public void testSaveAudit() {
	//		authenticate("auditor1");
	//		Audit audit = auditService.findOne(46);
	//		Audit saved = auditService.save(audit);
	//		//compruebo todo OK
	//		Collection<Audit> audits = auditService.findAll();
	//		Assert.isTrue(audits.contains(saved));
	//
	//	}
	//
	//	@Test
	//	public void testDeleteAudit() {
	//		authenticate("auditor2");
	//		Audit audit = auditService.findOne(48);
	//		Assert.notNull(audit);
	//		auditService.delete(audit);
	//
	//		Collection<Audit> audits = auditService.findAll();
	//		Assert.isTrue(!audits.contains(audit));
	//	}

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

		Collection<Audit> result;
		Property property;

		property = propertyService.findOne(34);
		result = auditService.findAllByProperty(property.getId());

		System.out.println("Number of Audits from Property " + property.getId() + " - " + result.size());

		for (Audit audit : result) {
			String s = "";
			System.out.println(s = s + "Audit ID: " + audit.getId());
		}
		authenticate(null);
		System.out.println("----------------------------------------------------------------");
	}

	@Test
	public void testCreateNegative() {
		System.out.println("-----------------------------Create-----------------------------");
		authenticate("auditor1");

		Audit audit;
		Property property;

		property = propertyService.findOne(34);
		audit = auditService.create(property);

		System.out.println("Create moment: " + audit.getCreateMoment());
		System.out.println("Text: " + audit.getText());
		System.out.println("Attachments: " + audit.getAttachments());
		System.out.println("Draft: " + audit.getDraft());
		System.out.println("Auditor: " + audit.getAuditor());

		authenticate(null);
		System.out.println("----------------------------------------------------------------");
	}

	@Test
	public void testSaveNegative() {
		System.out.println("-----------------------------Save-----------------------------");
		authenticate("auditor1");

		Audit audit;
		Date createMoment;
		Property property;

		property = propertyService.findOne(34);
		audit = auditService.create(property);
		createMoment = new Date(System.currentTimeMillis());

		audit.setCreateMoment(createMoment);

		audit = auditService.save(audit);

		System.out.println("Create moment: " + audit.getCreateMoment());
		System.out.println("Text: " + audit.getText());
		System.out.println("Attachments: " + audit.getAttachments());
		System.out.println("Draft: " + audit.getDraft());
		System.out.println("Auditor: " + audit.getAuditor());

		authenticate(null);
		System.out.println("----------------------------------------------------------------");
	}
}
