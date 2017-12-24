package miniproject.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniproject.entity.Country;
import miniproject.entity.Department;
import miniproject.entity.Location;
import miniproject.repository.DepartmentRepository;

@Service
public class DepartmentService {

	
	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> getAllDepartments(){
		return (List) departmentRepository.findAll();
	}

	
	public Department getDepartment(long departmentId){
		return departmentRepository.findOne(departmentId);
	}
	
	public Department createDepartment(Department department,long locationId, BigDecimal managerId){
		department.setLocation(new Location(locationId));
		department.setManagerId(managerId);
		return departmentRepository.save(department);
	}
	
	
	public void deleteDepartment(long departmentId){
		departmentRepository.delete(departmentId);
	}
}
