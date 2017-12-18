
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.FeeRepository;
import domain.Administrator;
import domain.Fee;

@Service
@Transactional
public class FeeService {

	// Managed Repository 
	// ====================================================================================

	@Autowired
	private FeeRepository			feeRepository;

	@Autowired
	private AdministratorService	administratorService;


	// Supported Services 
	// ====================================================================================

	// Constructor methods
	// ====================================================================================

	public FeeService() {
		super();
	}

	// Simple CRUDS methods 
	// ====================================================================================

	public Fee findOne(int id) {
		Fee result;

		result = feeRepository.findOne(id);

		return result;
	}

	public Collection<Fee> findAll() {

		Collection<Fee> fees;

		fees = feeRepository.findAll();
		Assert.notNull(fees);
		return fees;
	}

	public Fee findOneToEdit(int feeId) {
		Fee result;
		Administrator principal;

		principal = administratorService.findByPrincipal();
		Assert.isInstanceOf(Administrator.class, principal);
		result = feeRepository.findOne(feeId);

		return result;
	}

	public Fee create() {
		Fee result;
		Administrator principal;

		principal = administratorService.findByPrincipal();
		Assert.notNull(principal);
		Assert.isInstanceOf(Administrator.class, principal);

		result = new Fee();

		return result;
	}

	public Fee save(Fee fee) {
		Assert.notNull(fee);
		Fee result;
		Administrator principal;

		principal = administratorService.findByPrincipal();
		Assert.notNull(principal);
		Assert.isInstanceOf(Administrator.class, principal);

		result = feeRepository.save(fee);

		return result;
	}

	// Others bussines methods
	// ====================================================================================

}
