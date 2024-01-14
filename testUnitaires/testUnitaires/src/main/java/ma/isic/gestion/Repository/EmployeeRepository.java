package ma.isic.gestion.Repository;



import org.springframework.data.jpa.repository.JpaRepository;


import ma.isic.gestion.entities.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);
}