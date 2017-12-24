package miniproject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import miniproject.entity.Employee;
import miniproject.entity.Job;
import miniproject.service.DepartmentService;
import miniproject.service.EmployeeService;
import miniproject.service.JobService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	JobService jobService;
	
	@RequestMapping(value="/employees")
    public String getEmployees(Model model){
		model.addAttribute("employees",employeeService.getAllEmployees());
		return "employees";
    }
	
	@RequestMapping(value="/employees/{id}")
    public String getDepartment(@PathVariable Long id,Model model){
		model.addAttribute("e",new Employee());
		model.addAttribute("employee",employeeService.getEmployee(id));
		model.addAttribute("managers",employeeService.getAllEmployees());
		model.addAttribute("jobs",jobService.getAllJobs());
		model.addAttribute("departments",departmentService.getAllDepartments());
         return "employee";
	}
	
	@RequestMapping(value="/employees",method=RequestMethod.POST)
	public String updateDepartment(Model model,@ModelAttribute("e") Employee employee){
		employeeService.createEmployee(employee, employee.getJob().getJobId(), employee.getDepartment().getDepartmentId());
		model.addAttribute("employees",employeeService.getAllEmployees());
		return "employees";
	}

}
