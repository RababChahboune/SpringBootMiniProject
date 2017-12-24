package miniproject.repository;

import org.springframework.data.repository.CrudRepository;

import miniproject.entity.Department;


public interface DepartmentRepository extends CrudRepository<Department, Long>{

}
