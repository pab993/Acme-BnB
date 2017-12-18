
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import repositories.TenantRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Booking;
import domain.Finder;
import domain.SocialIdentity;
import domain.Tenant;
import forms.TenantForm;

@Transactional
@Service
public class TenantService {

	//Repository -----------------------------------------------
	@Autowired
	private TenantRepository	tenantRepository;

	//Services--------------------------------------------------

	@Autowired
	private FinderService		finderService;


	//Constructor-----------------------------------------------

	public TenantService() {
		super();
	}

	// Simple CRUDS methods --------------

	public Tenant create() {
		UserAccount us = new UserAccount();
		Tenant res = new Tenant();
		Collection<Authority> au = new ArrayList<Authority>();
		Authority i = new Authority();
		i.setAuthority("TENANT");
		au.add(i);
		us.setAuthorities(au);
		res.setUserAccount(us);
		return res;

	}

	public Tenant findOne(int tenantId) {

		Tenant result;
		Assert.notNull(tenantId);

		result = tenantRepository.findOne(tenantId);
		Assert.notNull(result);

		return result;
	}

	public Tenant save(Tenant tenant) {

		Assert.notNull(tenant);

		if (tenant.getFinder() == null) {
			Finder finder = finderService.create();
			finder.setTenant(tenant);
			tenant.setFinder(finder);

		}
		Tenant saved = tenantRepository.save(tenant);
		return saved;

	}

	public Collection<Tenant> findAll() {

		Collection<Tenant> tenants = tenantRepository.findAll();
		Assert.notNull(tenants);
		return tenants;
	}

	// Others bussines methods ----------------

	public Tenant findByPrincipal() {
		
		Tenant resul;
		UserAccount principal = LoginService.getPrincipal();
		
		resul = tenantRepository.findPrincipal(principal.getId());
		
		return resul;
	}

	public Tenant findByUserAccount(UserAccount userAccount) {
		Tenant result;

		result = tenantRepository.findByUserAccountId(userAccount.getId());

		return result;
	}

	public Tenant reconstruct(TenantForm tenantForm, BindingResult binding) {
		Tenant tenant = new Tenant();
		Collection<Booking> bookings = new ArrayList<Booking>();
		Collection<SocialIdentity> socialIdentities = new ArrayList<SocialIdentity>();

		Md5PasswordEncoder encode = new Md5PasswordEncoder();
		String hash = encode.encodePassword(tenantForm.getPassword(), null);

		Authority authority = new Authority();
		UserAccount userAccount = new UserAccount();

		authority.setAuthority("TENANT");
		userAccount.addAuthority(authority);
		tenant.setUserAccount(userAccount);
		tenant.getUserAccount().setUsername(tenantForm.getUsername());
		tenant.setName(tenantForm.getName());
		tenant.setSurname(tenantForm.getSurname());
		tenant.setEmail(tenantForm.getEmail());
		tenant.setPhone(tenantForm.getPhone());
		tenant.setPicture(tenantForm.getPicture());
		tenant.setBookings(bookings);
		tenant.setSocialIdentities(socialIdentities);

		if (!tenantForm.getPassword().equals(tenantForm.getRepeatPassword())) {
			ObjectError error = new ObjectError(hash, "Password mismatch");
			binding.addError(error);
		} else {
			tenant.getUserAccount().setPassword(hash);
		}

		return tenant;
	}

	public Tenant findPrincipal() {
		// TODO Auto-generated method stub

		Tenant principal = tenantRepository.findPrincipal(LoginService.getPrincipal().getId());
		Assert.notNull(principal, "principal is not lessor");

		return principal;

	}


	@Autowired
	private Validator	validator;


	public Tenant reconstruct(Tenant tenant, BindingResult binding) {
		// TODO Auto-generated method stub
		Tenant resul;

		if (tenant.getId() == 0)
			resul = tenant;
		else {
			resul = tenantRepository.findOne(tenant.getId());

			resul.setName(tenant.getName());
			resul.setSurname(tenant.getSurname());
			resul.setPhone(tenant.getPhone());
			resul.setEmail(tenant.getEmail());
			resul.setPicture(tenant.getPicture());

			validator.validate(resul, binding);
		}

		return resul;
	}

	public Double avgAcceptedRequestPerTenant() {
		Double res;
		res = tenantRepository.avgAcceptedRequestPerTenant();
		Assert.notNull(res);
		return res;
	}

	public Double avgDeniedRequestPerTenant() {
		Double res;
		res = tenantRepository.avgDeniedRequestPerTenant();
		Assert.notNull(res);
		return res;
	}

	public Collection<Tenant> tenantMoreAcceptedRequest() {
		Collection<Tenant> res;
		res = tenantRepository.tenantMoreAcceptedRequest();
		Assert.notNull(res);
		return res;
	}

	public Collection<Tenant> tenantMoreDeniedRequest() {
		Collection<Tenant> res;
		res = tenantRepository.tenantMoreDeniedRequest();
		Assert.notNull(res);
		return res;
	}

	public Collection<Tenant> tenantMorePendingRequest() {
		Collection<Tenant> res;
		res = tenantRepository.tenantMoreDeniedRequest();
		Assert.notNull(res);
		return res;
	}

	public Collection<Tenant> ratioTenantMax() {
		Collection<Tenant> res;
		res = tenantRepository.ratioTenantMax();
		Assert.notNull(res);
		return res;
	}

	public Collection<Tenant> ratioTenantMin() {
		Collection<Tenant> res;
		res = tenantRepository.ratioTenantMin();
		Assert.notNull(res);
		return res;
	}

	public Double minSocialIdTenant() {
		Double res;
		res = tenantRepository.minSocialIdTenant();
		Assert.notNull(res);
		return res;
	}

	public Double avgSocialIdTenant() {
		Double res;
		res = tenantRepository.avgSocialIdTenant();
		Assert.notNull(res);
		return res;
	}

	public Double maxSocialIdTenant() {
		Double res;
		res = tenantRepository.maxSocialIdTenant();
		Assert.notNull(res);
		return res;
	}
}
