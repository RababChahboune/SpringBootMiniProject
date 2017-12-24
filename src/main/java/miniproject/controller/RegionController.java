package miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import miniproject.entity.Person;
import miniproject.entity.Region;
import miniproject.service.RegionService;

@Controller
public class RegionController {
	@Autowired
	RegionService regionService;
	@RequestMapping("/regions")
	public String getRegions(Model model){
		model.addAttribute("regions",regionService.getAllRegions());
		
		model.addAttribute("region",new Region());
		return "regions";
	}
	
	@RequestMapping(path="/regions", method=RequestMethod.POST)
	public String updateRegion(@ModelAttribute("region") Region region,Model model) {
		regionService.updateRegion(region);
		model.addAttribute("regions",regionService.getAllRegions());
        return "regions";
    }
}
