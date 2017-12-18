
package services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.FinderRepository;
import domain.Finder;
import domain.Property;

@Service
@Transactional
public class FinderService {

	// Managed Repository 
	// ====================================================================================

	@Autowired
	private FinderRepository	finderRepository;

	// Supported Services 
	// ====================================================================================

	@Autowired
	private Validator			validator;


	// Constructor methods
	// ====================================================================================

	public FinderService() {
		super();
	}

	// Simple CRUDS methods 
	// ====================================================================================

	public Finder findOne(int id) {
		Finder result;

		result = finderRepository.findOne(id);

		return result;
	}

	public Collection<Finder> findAll() {

		Collection<Finder> finders;

		finders = finderRepository.findAll();
		Assert.notNull(finders);

		return finders;
	}

	public Finder create() {
		Finder result;
		Collection<Property> properties;

		result = new Finder();
		properties = new ArrayList<Property>();
		result.setResults(properties);
		result.setDestination("Insert a destination");

		return result;
	}

	public Finder save(Finder finder) {
		Assert.notNull(finder);
		Finder result;

		result = finderRepository.save(finder);

		return result;
	}

	public Finder reconstruct(Finder finder, BindingResult binding) {
		Finder result;

		if (finder.getId() == 0) {
			result = finder;
		} else {
			result = finderRepository.findOne(finder.getId());

			long l = 10;
			Date d = new Date(System.currentTimeMillis() - l);

			result.setSearchMoment(d);
			result.setDestination(finder.getDestination());
			result.setMinPrice(finder.getMinPrice());
			result.setMaxPrice(finder.getMaxPrice());
			result.setKeyword(finder.getKeyword());

			validator.validate(result, binding);
		}
		return result;
	}

	public Collection<Property> search(String destination, Double minPrice, Double maxPrice, String keyword) {
		Collection<Property> properties;
		Assert.notNull(destination);

		properties = finderRepository.search(destination, minPrice, maxPrice, keyword);

		return properties;

	}

	public Double avgResultPerFinder() {
		Double result;

		result = finderRepository.avgResultPerFinder();

		return result;
	}

	public Integer maxResultPerFinder() {
		Integer result;

		result = finderRepository.maxResultPerFinder();

		return result;
	}

	public Integer minResultPerFinder() {
		Integer result;

		result = finderRepository.minResultPerFinder();

		return result;
	}

}
