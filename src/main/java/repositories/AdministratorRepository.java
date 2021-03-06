
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

	@Query("select a from Administrator a where a.userAccount.id = ?1")
	Administrator findByUserAccountId(int userAccountId);

	@Query("select min(a.socialIdentities.size) from Administrator a")
	Double minSocialIdAdministrator();

	@Query("select avg(a.socialIdentities.size) from Administrator a")
	Double avgSocialIdAdministrator();

	@Query("select max(a.socialIdentities.size) from Administrator a")
	Double maxSocialIdAdministrator();
}
