
package services;

import java.util.Collection;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.AuditRepository;
import domain.Audit;
import domain.Auditor;
import domain.Property;

@Transactional
@Service
public class AuditService {

	// Managed Repository 
	// ====================================================================================

	@Autowired
	private AuditRepository	auditRepository;

	// Supported Services 
	// ====================================================================================

	@Autowired
	private AuditorService	auditorService;

	@Autowired
	private Validator		validator;


	// Constructor methods
	// ====================================================================================

	public AuditService() {
		super();
	}

	// Simple CRUDS methods 
	// ====================================================================================

	public Audit findOne(int auditId) {

		Audit result;
		Assert.notNull(auditId);

		result = auditRepository.findOne(auditId);
		Assert.notNull(result);

		return result;
	}

	public Audit create(Property property) {
		Audit result;
		Date createMoment;
		Auditor principal;

		principal = auditorService.findByPrincipal();
		Assert.notNull(principal);

		createMoment = new Date(System.currentTimeMillis());
		result = new Audit();
		result.setCreateMoment(createMoment);
		result.setAuditor(principal);
		result.setProperty(property);

		return result;
	}

	public Audit save(Audit audit) {
		Assert.notNull(audit);
		Audit result;
		Auditor principal;

		principal = auditorService.findByPrincipal();
		Assert.notNull(principal);

		audit.setDraft(true);
		result = auditRepository.save(audit);

		return result;
	}

	public void delete(Audit audit) {
		Assert.notNull(audit);
		Assert.isTrue(auditRepository.exists(audit.getId()));
		Auditor principal;

		principal = auditorService.findByPrincipal();
		Assert.notNull(principal);
		Assert.isTrue(principal.equals(audit.getAuditor()));
		Assert.isInstanceOf(Auditor.class, principal);

		if (audit.getDraft() == true) {
			auditRepository.delete(audit);
		} else {
			JOptionPane.showMessageDialog(null, "No se puede borrar, ya está publicada");
		}
	}

	public Collection<Audit> findAll() {
		Collection<Audit> audits;

		audits = auditRepository.findAll();
		Assert.notNull(audits);

		return audits;
	}

	public Audit reconstruct(Audit audit, BindingResult binding) {
		Audit result;

		if (audit.getId() == 0) {
			result = audit;
		} else {
			result = auditRepository.findOne(audit.getId());

			Boolean draft = true;

			result.setDraft(draft);
			result.setCreateMoment(audit.getCreateMoment());
			result.setText(audit.getText());
			result.setAttachments(audit.getAttachments());

			validator.validate(result, binding);
		}
		return result;
	}

	// Others bussines methods
	// ====================================================================================

	public Collection<Audit> findAllByProperty(int id) {
		Assert.notNull(id);

		Collection<Audit> audits = auditRepository.findAllByProperty(id);

		return audits;
	}

	public Collection<Audit> findAllByAuditor(int id) {
		Assert.notNull(id);

		Collection<Audit> audits = auditRepository.findAllByAuditor(id);

		return audits;
	}

	public Collection<Audit> findAllDraft(int id) {
		Collection<Audit> result;

		result = auditRepository.findAllDraft(id);

		return result;
	}

	public Collection<Audit> findAllNotDraft(int id) {
		Collection<Audit> result;

		result = auditRepository.findAllNotDraft(id);

		return result;
	}

	public void draft(int auditId) {
		Auditor auditor;
		Audit audit;
		Collection<Audit> audits;

		auditor = auditorService.findByPrincipal();
		audits = auditRepository.findAllDraft(auditor.getId());
		audit = findOne(auditId);

		Assert.isInstanceOf(Auditor.class, auditor);
		Assert.isTrue(!audits.contains(audit));

		audit.setDraft(true);

		auditRepository.save(audit);
	}

	public void notDraft(int auditId) {
		Auditor auditor;
		Audit audit;
		Collection<Audit> audits;

		auditor = auditorService.findByPrincipal();
		audits = auditRepository.findAllNotDraft(auditor.getId());
		audit = findOne(auditId);

		Assert.isInstanceOf(Auditor.class, auditor);
		Assert.isTrue(!audits.contains(audit));

		audit.setDraft(false);

		auditRepository.save(audit);
	}

	public Integer countAuditByAuditorForProperty(int idAuditor, int idProperty) {
		Integer result;

		result = auditRepository.countAuditByAuditorForProperty(idAuditor, idProperty);

		return result;
	}

}
