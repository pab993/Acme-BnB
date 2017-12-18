package services;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.CommentRepository;
import domain.Booking;
import domain.Comentable;
import domain.Comment;
import domain.Customer;
import domain.Lessor;
import domain.Tenant;

@Transactional
@Service
public class CommentService {

	// Managed Repository
	// ====================================================================================

	@Autowired
	private CommentRepository commentRepository;

	// Supported Services
	// ====================================================================================

	@Autowired
	private ActorService actorService;

	// Constructor methods
	// ====================================================================================

	public CommentService() {
		super();
	}

	// Simple CRUDS methods
	// ====================================================================================

	public Comment findOne(int commentId) {
		Assert.notNull(commentId);

		Comment result;

		result = commentRepository.findOne(commentId);
		Assert.notNull(result);

		return result;
	}

	public Collection<Comment> findAll() {

		Collection<Comment> comments;

		comments = commentRepository.findAll();
		Assert.notNull(comments);

		return comments;
	}

	public Comment create(Comentable comentable) {
		Assert.notNull(comentable);

		Comment result;
		Date createMoment;
		Customer principal;

		principal = (Customer) actorService.findByPrincipal();
		Assert.notNull(principal);

		createMoment = new Date(System.currentTimeMillis());
		result = new Comment();
		result.setCreateMoment(createMoment);
		result.setCustomer(principal);
		comentable.getComments().add(result);
		result.setComentable(comentable);

		return result;
	}

	public Comment save(Comment comment) {
		Assert.notNull(comment);
		Comment result;
		Customer principal;

		principal = (Customer) actorService.findByPrincipal();
		Assert.notNull(principal);
		result = commentRepository.save(comment);

		return result;
	}

	// Others bussines methods
	// ====================================================================================

	public Boolean canComment(Customer lessor) {
		Boolean res = false;
		Customer principal = (Customer) actorService.findByPrincipal();

		if (principal != null) {
			Boolean principalIsLessor = principal.getClass() == Lessor.class;
			Boolean comentableIsTenant = lessor.getClass() == Tenant.class;
			
			if (lessor.getId() == principal.getId()) {
				res = true;
			} else if (principalIsLessor && comentableIsTenant) {
				Lessor l = (Lessor) principal;
				Tenant t = (Tenant) lessor;
				for (Booking b : t.getBookings()) {
					if (b.getProperty().getLessor().getId() == l.getId())
						res = true;
				}

			} else if (principal.getClass() == (Tenant.class)
					&& lessor.getClass() == (Lessor.class)) {
				Tenant t = (Tenant) principal;
				Lessor l = (Lessor) lessor;
				for (Booking b : t.getBookings()) {
					if (b.getProperty().getLessor().getId() == l.getId())
						res = true;
				}
			}
		}

		return res;
	}

}
