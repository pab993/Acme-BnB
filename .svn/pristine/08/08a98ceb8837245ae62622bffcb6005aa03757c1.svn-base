
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
import domain.Tenant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class TenantServiceTest extends AbstractTest {

	//Service under test

	@Autowired
	public TenantService	tenantService;


	@Test
	public void testCreateTenant() {
		Tenant l = tenantService.create();
		Assert.notNull(l);
	}

	@Test
	public void testFindOneTenant() {
		Tenant l = tenantService.findOne(12);
		Assert.notNull(l);
	}

	@Test
	public void testFindAllTenant() {
		Collection<Tenant> tenants = tenantService.findAll();
		Assert.notNull(tenants);

	}

	@Test
	public void testSaveTenant() {
		Tenant tenant = tenantService.findOne(12);
		Tenant saved = tenantService.save(tenant);
		//compruebo todo OK
		Collection<Tenant> tenants = tenantService.findAll();
		Assert.isTrue(tenants.contains(saved));

	}
}
