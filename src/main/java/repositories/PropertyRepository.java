
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Lessor;
import domain.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

	@Query("select l from Lessor l join l.properties lp where lp.id = ?1")
	Lessor findLessorByProperty(int id);

	@Query("select p from Property p where p.lessor.id = ?1")
	Collection<Property> findAllByPrincipal(int id);

	@Query("select count(b) from Booking b where b.property.id = ?1 and b.status = 'ACCEPTED'")
	Integer countBooking(int idProperty);

	@Query("select min(p.audits.size) from Property p")
	Double minAudits();

	@Query("select avg(p.audits.size) from Property p")
	Double avgAudits();

	@Query("select max(p.audits.size) from Property p")
	Double maxAudits();

	@Query("select attn.name from AttributeName attn group by attn.name order by count(attn.name) DESC")
	Collection<String> findAttNameOrderByUse();

	@Query("select p from Lessor l join l.properties p where l.id=?1 order by p.audits.size DESC")
	Collection<Property> findPropertyByAudits(int lessorId);

	@Query("select p from Lessor l join l.properties p where l.id=?1 order by p.bookings.size DESC")
	Collection<Property> findPropertyByBookings(int lessorId);

	@Query("select p from Lessor l join l.properties p join p.bookings b where l.id=?1 and b.status = 'ACCEPTED' order by p.bookings.size DESC")
	Collection<Property> findPropertyByAcceptedBookings(int lessorId);

	@Query("select p from Lessor l join l.properties p join p.bookings b where l.id=?1 and b.status = 'DENIED' order by p.bookings.size DESC")
	Collection<Property> findPropertyByDeniedBookings(int lessorId);

	@Query("select p from Lessor l join l.properties p join p.bookings b where l.id=?1 and b.status = 'PENDING' order by p.bookings.size DESC")
	Collection<Property> findPropertyByPendingBookings(int lessorId);
}
