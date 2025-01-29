package oct.soft.octvms.visitor.repos;

import oct.soft.octvms.visitor.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
