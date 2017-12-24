package miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniproject.entity.Country;
import miniproject.entity.Location;
import miniproject.repository.LocationRepository;

@Service
public class LocationService {
	@Autowired
	LocationRepository locationRepository;

	public List<Location> getAllLocations(){
		return (List) locationRepository.findAll();
	}

	
	public Location getLocation(long locationId){
		return locationRepository.findOne(locationId);
	}
	
	public Location createLocation(Location location,String countryId){
		location.setCountry(new Country(countryId));
		return locationRepository.save(location);
	}
	
	
	public void deleteLocation(long locationId){
		locationRepository.delete(locationId);
	}
}
