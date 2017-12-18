
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Lessor;

@Repository
public interface LessorRepository extends JpaRepository<Lessor, Integer> {

	@Query("select l from Lessor l where l.userAccount.id = ?1")
	Lessor findPrincipal(int id);

	@Query("select l from Lessor l join l.properties p where p.id = ?1")
	Lessor findOneByProperty(int id);

	// The average number of accepted requests per lessor.
	@Query("select count(b)*1.0/(select count(t) from Lessor t) from Booking b where b.status='ACCEPTED'")
	Double avgAcceptedRequestPerLessor();

	// The average number of denied requests per lessor.
	@Query("select count(b)*1.0/(select count(t) from Lessor t) from Booking b where b.status='DENIED'")
	Double avgDeniedRequestPerLessor();

	// The lessors who have approved more requests.
	@Query("select ls from Lessor ls where (select count(b) from Lessor l join l.properties p join p.bookings b where b.status = 'ACCEPTED' and l.id=ls.id) >= all (select count(b1) from Lessor l1 join l1.properties p1 join p1.bookings b1 where b1.status = 'ACCEPTED' group by l1)")
	Collection<Lessor> lessorsMoreAcceptedRequest();

	//The lessors who have denied more requests.
	@Query("select t1 from Lessor t1 join t1.properties p1 join p1.bookings b1 where b1.status = 'DENIED' and (select count(b2) from Booking b2 join b2.property po join po.lessor t2 where b2.status = 'DENIED' AND t2.id = t1.id group by t2) >= ALL (select count(b3) from Booking b3 join b3.property op join op.lessor t4 where b3.status = 'DENIED' group by t4 ) group by t1")
	Collection<Lessor> lessorsMoreDeniedRequest();

	//The lessors who have more pending requests.
	@Query("select t1 from Lessor t1 join t1.properties p1 join p1.bookings b1 where b1.status = 'PENDING' and (select count(b2) from Booking b2 join b2.property po join po.lessor t2 where b2.status = 'PENDING' AND t2.id = t1.id group by t2) >= ALL (select count(b3) from Booking b3 join b3.property op join op.lessor t4 where b3.status = 'PENDING' group by t4 ) group by t1")
	Collection<Lessor> lessorsMorePendingRequest();

	//The lessor/s whose ratio of requested versus approved request/s is the maximum
	@Query("select b1.property.lessor from Booking b1 where (select count(b2)*1.0/(select count(b3) from Booking b3 where b3.property.lessor = b1.property.lessor) from Booking b2 where b2.status = 'ACCEPTED' and b2.property.lessor = b1.property.lessor) >= ALL(select count(b3)*1.0/(select count(b4) from Booking b4 where b4.property.lessor = b3.property.lessor) from Booking b3 where b3.status='ACCEPTED' group by b3.property.lessor) group by b1.property.lessor")
	Collection<Lessor> ratioLessorMax();

	//The lessor/s whose ratio of requested versus approved request/s is the minimum
	@Query("select b1.property.lessor from Booking b1 where (select count(b2)*1.0/(select count(b3) from Booking b3 where b3.property.lessor = b1.property.lessor) from Booking b2 where b2.status = 'ACCEPTED' and b2.property.lessor = b1.property.lessor) <= ALL(select count(b3)*1.0/(select count(b4) from Booking b4 where b4.property.lessor = b3.property.lessor) from Booking b3 where b3.status='ACCEPTED' group by b3.property.lessor) group by b1.property.lessor")
	Collection<Lessor> ratioLessorMin();

	@Query("select min(l.socialIdentities.size) from Lessor l")
	Double minSocialIdLessor();

	@Query("select avg(l.socialIdentities.size) from Lessor l")
	Double avgSocialIdLessor();

	@Query("select max(l.socialIdentities.size) from Lessor l")
	Double maxSocialIdLessor();
}
