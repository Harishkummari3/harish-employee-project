package harish.employee.project.employeeproject.Repository;





import org.springframework.data.jpa.repository.JpaRepository;

import harish.employee.project.employeeproject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	

}
