
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {

	@Query("select t from Tenant t where t.userAccount.id = ?1")
	Tenant findByUserAccountId(int userAccountId);

	@Query("select t from Tenant t where t.userAccount.id = ?1")
	Tenant findPrincipal(int id);

	// The average number of accepted requests per tenant.
	@Query("select count(b)*1.0/(select count(t) from Tenant t) from Booking b where b.status='ACCEPTED'")
	Double avgAcceptedRequestPerTenant();

	// The average number of accepted requests per tenant.
	@Query("select count(b)*1.0/(select count(t) from Tenant t) from Booking b where b.status='DENIED'")
	Double avgDeniedRequestPerTenant();

	//The tenants who have got more requests approved.
	@Query("select t1 from Tenant t1 join t1.bookings b1 where b1.status = 'ACCEPTED' and (select count(b2) from Booking b2 join b2.tenant t2 where b2.status = 'ACCEPTED' AND t2.id = t1.id group by t2) >= ALL (select count(b3) from Booking b3 join b3.tenant t4 where b3.status = 'ACCEPTED' group by t4 ) group by t1")
	Collection<Tenant> tenantMoreAcceptedRequest();

	//The tenants who have got more requests denied.
	@Query("select t1 from Tenant t1 join t1.bookings b1 where b1.status = 'DENIED' and (select count(b2) from Booking b2 join b2.tenant t2 where b2.status = 'DENIED' AND t2.id = t1.id group by t2) >= ALL (select count(b3) from Booking b3 join b3.tenant t4 where b3.status = 'DENIED' group by t4 ) group by t1")
	Collection<Tenant> tenantMoreDeniedRequest();

	//The tenants who have got more requests pending.
	@Query("select t1 from Tenant t1 join t1.bookings b1 where b1.status = 'PENDING' and (select count(b2) from Booking b2 join b2.tenant t2 where b2.status = 'PENDING' AND t2.id = t1.id group by t2) >= ALL (select count(b3) from Booking b3 join b3.tenant t4 where b3.status = 'PENDING' group by t4 ) group by t1")
	Collection<Tenant> tenantMorePendingRequest();

	//The lessor/s whose ratio of requested versus approved request/s is the maximum
	@Query("select b1.tenant from Booking b1 where (select 1.0*count(b2)/(select count(b3) from Booking b3 where b3.tenant.id = b1.tenant.id) from Booking b2 where b2.status = 'ACCEPTED' and b2.tenant.id = b1.tenant.id) >= all(select 1.0*count(b4)/(select count(b5) from Booking b5 where b5.tenant.id = b4.tenant.id) from Booking b4 where b4.status = 'ACCEPTED' group by b4.tenant) group by b1.tenant")
	Collection<Tenant> ratioTenantMax();

	//The lessor/s whose ratio of requested versus approved request/s is the minimum
	@Query("select b1.tenant from Booking b1 where (select 1.0*count(b2)/(select count(b3) from Booking b3 where b3.tenant.id = b1.tenant.id) from Booking b2 where b2.status = 'ACCEPTED' and b2.tenant.id = b1.tenant.id) <= all(select 1.0*count(b4)/(select count(b5) from Booking b5 where b5.tenant.id = b4.tenant.id) from Booking b4 where b4.status = 'ACCEPTED' group by b4.tenant) group by b1.tenant")
	Collection<Tenant> ratioTenantMin();

	@Query("select min(t.socialIdentities.size) from Tenant t")
	Double minSocialIdTenant();

	@Query("select avg(t.socialIdentities.size) from Tenant t")
	Double avgSocialIdTenant();

	@Query("select max(t.socialIdentities.size) from Tenant t")
	Double maxSocialIdTenant();
}
