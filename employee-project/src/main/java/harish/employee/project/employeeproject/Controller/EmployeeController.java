package harish.employee.project.employeeproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import harish.employee.project.employeeproject.Repository.EmployeeRepository;

import harish.employee.project.employeeproject.entity.Employee;
import harish.employee.project.employeeproject.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
    
	
	@PostMapping("/employee")
	public Employee addemployee(@Validated @RequestBody Employee employee) {
		Employee getemployee = employeeRepository.save(employee);
		return getemployee;
	}

    @PutMapping("/employee/{id}")
    public Employee updateemployee(@PathVariable(value = "id") long id,@Validated @RequestBody Employee employeeDetails) throws EmployeeNotFoundException{
    	Employee employee = employeeRepository.findById(id)
    			.orElseThrow(() -> new EmployeeNotFoundException(id));
    	employee.setId(employee.getId());
    	employee.setName(employee.getName());
    	employee.setDesignation(employee.getDesignation());
    	employee.setSalary(employee.getSalary());
    	Employee updateEmployee =employeeRepository.save(employee);
    	return updateEmployee;
    }
}
