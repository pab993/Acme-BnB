
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer> {

	@Query("select a from Audit a where a.property.id = ?1 and a.draft = false")
	Collection<Audit> findAllByProperty(int id);

	@Query("select a from Audit a where a.auditor.id = ?1")
	Collection<Audit> findAllByAuditor(int id);

	@Query("select a from Audit a where a.auditor.id = ?1 and a.draft = true")
	Collection<Audit> findAllDraft(int id);

	@Query("select a from Audit a where a.auditor.id = ?1 and a.draft = false")
	Collection<Audit> findAllNotDraft(int id);

	@Query("select count(p) from Property p join p.audits a where a.auditor.id=?1 and p.id=?2")
	Integer countAuditByAuditorForProperty(int idAuditor, int idProperty);
}
