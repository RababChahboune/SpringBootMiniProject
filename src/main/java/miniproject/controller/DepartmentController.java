package miniproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import miniproject.entity.Country;
import miniproject.entity.Department;
import miniproject.service.DepartmentService;
import miniproject.service.EmployeeService;
import miniproject.service.LocationService;

@Controller
public class DepartmentController {

	
	@Autowired
	DepartmentService departmentService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	LocationService locationService;
	@RequestMapping(value="/departments")
    public String getDepartments(Model model){
         model.addAttribute("departments",departmentService.getAllDepartments());
         return "departments";
	}
	
	@RequestMapping(value="/departments/{id}")
    public String getDepartment(@PathVariable long id,Model model){
		model.addAttribute("managers",employeeService.getAllEmployees());
		model.addAttribute("locations",locationService.getAllLocations());
		model.addAttribute("d",new Department());
		model.addAttribute("department",departmentService.getDepartment(id));
         return "department";
	}
	
	@RequestMapping(value="/departments",method=RequestMethod.POST)
	public String updateDepartment(Model model,@ModelAttribute("d") Department department){
		departmentService.createDepartment(department, department.getLocation().getLocationId(), department.getManagerId());
        model.addAttribute("departments",departmentService.getAllDepartments());
		return "departments";
	}
}
