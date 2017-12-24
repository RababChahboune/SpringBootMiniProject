package miniproject.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import miniproject.entity.Department;
import miniproject.entity.Employee;
import miniproject.entity.Job;
import miniproject.entity.Region;
import miniproject.repository.EmployeeRepository;
import miniproject.repository.StatsRepository;

@Service
public class EmployeeService {

	
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees(){
		return (List) employeeRepository.findAll();
	}

	
	public Employee getEmployee(long employeeId){
		return employeeRepository.findOne(employeeId);
	}
	
	public Employee createEmployee(Employee employee,String jobId,long departmentId){
		employee.setDepartment(new Department(departmentId));
		employee.setJob(new Job(jobId));
		
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(long employeeId){
		employeeRepository.delete(employeeId);
	}
	
	public Map<BigDecimal,Integer> stats(){
		Map<BigDecimal,Integer> stat = new TreeMap<BigDecimal,Integer>();
		List<Employee> employees = this.getAllEmployees();
		for(Employee emp: employees){
			if(stat.get(emp.getSalary())==null){
				stat.put(emp.getSalary(), 1);
			}else{
				stat.put(emp.getSalary(), stat.get(emp.getSalary())+1);
			}
		}
		return stat;
	}
	
	public Map<BigDecimal,Integer> Decile(){
		Map<BigDecimal,Integer> stat = new TreeMap<BigDecimal,Integer>();
		List<Employee> employees = this.getAllEmployees();
		List<BigDecimal> salaries = new ArrayList<BigDecimal>();
		for(Employee emp: employees){
			salaries.add(emp.getSalary());
		}
		Collections.sort(salaries);
		int d1;
		double d2; 
		BigDecimal D;
		int index,index1;
		index1 = 0;
		for(int i=1;i<10;i++){
			d1 = (int) (i*(salaries.size()+1)/10.0);
			d2 = (i*(salaries.size()+1)/10.0);
			D = salaries.get(d1).add((salaries.get(d1+1).subtract(salaries.get(d1) )).multiply(new BigDecimal((d2 - d1), MathContext.DECIMAL64))) ;
			index = 0;			;
			while(D.compareTo(salaries.get(index))>0){
				index++;
			}
			stat.put(D, (index-index1));
			index1=index;
			if(i==9){
				stat.put(D.add(new BigDecimal(1)), (salaries.size()-index1));
			}
		}
		return stat;
	}
}
