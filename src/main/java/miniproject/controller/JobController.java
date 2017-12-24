package miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import miniproject.entity.Department;
import miniproject.entity.Job;
import miniproject.service.JobService;

@Controller
public class JobController {
	
	@Autowired
	JobService jobService;
	@RequestMapping(value="/jobs")
    public String getJobs(Model model){
		model.addAttribute("jobs",jobService.getAllJobs());
        return "jobs";
    }
	
	@RequestMapping(value="/jobs/{id}")
    public String getDepartment(@PathVariable String id,Model model){
		model.addAttribute("j",new Job());
		model.addAttribute("job",jobService.getJob(id));
         return "job";
	}
	
	@RequestMapping(value="/jobs",method=RequestMethod.POST)
	public String updateDepartment(Model model,@ModelAttribute("j") Job job){
		jobService.createJob(job);
		model.addAttribute("jobs",jobService.getAllJobs());
		return "jobs";
	}

}
