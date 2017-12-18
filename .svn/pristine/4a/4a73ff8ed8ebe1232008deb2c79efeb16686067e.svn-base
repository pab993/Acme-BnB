
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("select b from Booking b where b.property.id = ?1")
	Collection<Booking> findAllByPropertyId(int id);

	@Query("select b from Booking b where b.tenant.id = ?1")
	Collection<Booking> findAllByTenantId(int id);

	@Query("select b from Booking b where  b.status = 'ACCEPTED' and b.property.lessor.id = ?1")
	Collection<Booking> findAllAcceptedByLessor(int id);
}
