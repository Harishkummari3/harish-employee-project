package harish.employee.project.employeeproject.exception;

public class EmployeeNotFoundException extends Exception {
	private long id;
	public EmployeeNotFoundException(long id) {
		super(String.format("Employee was Not found with is id :'%s'",id ));
	}

}
