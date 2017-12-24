package miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import miniproject.entity.Country;
import miniproject.entity.Region;
import miniproject.service.CountryService;
import miniproject.service.RegionService;


@Controller
public class CountryController {

	@Autowired
	CountryService countryService;
	@Autowired
	RegionService regionService;
	@RequestMapping("/countries")
    public String getCountries(Model model) {
		List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        model.addAttribute("c", new Country());
        return "countries";
    }
	
	@RequestMapping("/country/{id}")
    public String getCountry(@PathVariable String id,Model model) {
		
		model.addAttribute("country",countryService.getCountry(id));
		model.addAttribute("regions",regionService.getAllRegions());
		model.addAttribute("c", new Country());
        return "country";
    }
	
	@RequestMapping(path="/countries", method=RequestMethod.POST)
    public String updateCountry(Model model,@ModelAttribute("c") Country country) {
		countryService.updateCountry(country);
		model.addAttribute("countries",countryService.getAllCountries());
        return "countries";
    }
	
}
