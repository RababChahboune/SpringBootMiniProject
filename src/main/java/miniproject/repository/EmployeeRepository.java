package miniproject.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import miniproject.entity.Employee;


public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
	public long countBySalary(BigDecimal Salary);
	
}
