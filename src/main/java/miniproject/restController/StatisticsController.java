package miniproject.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Map;

import miniproject.service.EmployeeService;


@RestController
public class StatisticsController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/stats")
    public Map<BigDecimal,Integer> getStats() {
		return employeeService.stats();
    }
	
	@RequestMapping("/decile")
    public Map<BigDecimal,Integer> getDecile() {
		return employeeService.Decile();
    }
}
