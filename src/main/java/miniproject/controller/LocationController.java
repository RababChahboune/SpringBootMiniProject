package miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import miniproject.entity.Country;
import miniproject.entity.Location;
import miniproject.service.CountryService;
import miniproject.service.LocationService;

@Controller
public class LocationController {
	
	@Autowired
	LocationService locationService;
	@Autowired
	CountryService countryService;
	@RequestMapping(value="/locations")
    public String getLocations(Model model){
		List<Location> locations = locationService.getAllLocations();
		model.addAttribute("locations", locations);
        return "locations";
    }
	
	@RequestMapping(value="/locations/{id}")
    public String getLocation(@PathVariable long id,Model model){
		model.addAttribute("location",locationService.getLocation(id));
		model.addAttribute("countries",countryService.getAllCountries());
		model.addAttribute("l",new Location());
        return "location";
    }
	
	@RequestMapping(path="/locations", method=RequestMethod.POST)
    public String updateLocation(Model model,@ModelAttribute("l") Location l) {
		locationService.createLocation(l, l.getCountry().getCountryId());
		model.addAttribute("locations", locationService.getAllLocations());
        return "locations";
    }
	
}
