package academy.itk.repository;

import academy.itk.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Реализация не требуется по условию
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
