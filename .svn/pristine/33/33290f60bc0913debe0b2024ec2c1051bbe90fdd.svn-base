
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Finder;
import domain.Property;

@Repository
public interface FinderRepository extends JpaRepository<Finder, Integer> {

	@Query("select p from Property p join p.attributeValues attv where (attv.value like %?1% or p.name like %?1%) and (p.rate between ?2 AND ?3 ) or (p.name like %?4% or p.description like %?4% or p.address like %?4%) and (p.rate between ?2 AND ?3 )")
	Collection<Property> search(String d, Double min, Double max, String key);

	//The average of results per finder.
	@Query("select avg(f.results.size) from Finder f")
	Double avgResultPerFinder();

	//The maximum of results per finder.
	@Query("select max(f.results.size) from Finder f")
	Integer maxResultPerFinder();

	//The maximum of results per finder.
	@Query("select min(f.results.size) from Finder f")
	Integer minResultPerFinder();
}
