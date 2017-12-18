
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Auditor;

@Repository
public interface AuditorRepository extends JpaRepository<Auditor, Integer> {

	@Query("select a from Auditor a where a.userAccount.id = ?1")
	Auditor findByUserAccountId(int userAccountId);

	@Query("select a from Auditor a where a.userAccount.id = ?1")
	Auditor findPrincipal(int id);

	@Query("select min(a.socialIdentities.size) from Auditor a")
	Double minSocialIdAuditor();

	@Query("select avg(a.socialIdentities.size) from Auditor a")
	Double avgSocialIdAuditor();

	@Query("select max(a.socialIdentities.size) from Auditor a")
	Double maxSocialIdAuditor();

}
