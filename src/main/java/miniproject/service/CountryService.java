package miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniproject.entity.Country;
import miniproject.entity.Region;
import miniproject.repository.CountryRepository;
import miniproject.repository.RegionRepository;

@Service
public class CountryService {

	
	@Autowired
	CountryRepository countryRepository;

	public List<Country> getAllCountries(){
		return (List) countryRepository.findAll();
	}

	
	public Country getCountry(String countryId){
		return countryRepository.findOne(countryId);
	}
	
	public Country createCountry(Country country,long regionId){
		country.setRegion(new Region(regionId));
		return countryRepository.save(country);
	}
	
	public Country updateCountry(Country country){
		return countryRepository.save(country);
	}
	
	public void deleteCountry(String countryId){
		countryRepository.delete(countryId);
	}
}
