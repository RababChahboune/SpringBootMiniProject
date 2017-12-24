package miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import miniproject.entity.Region;
import miniproject.repository.RegionRepository;
@Service
public class RegionService {
	
	@Autowired
	RegionRepository regionRepository;

	public List<Region> getAllRegions(){
		return (List) regionRepository.findAll();
	}
	
	public Region getRegion(long regionId){
		return regionRepository.findOne(regionId);
	}
	
	public Region createRegion(Region region){
		return regionRepository.save(region);
	}
	
	public Region updateRegion(Region region){
		return regionRepository.save(region);
	}
	
	public void deleteRegion(long regionId){
		regionRepository.delete(regionId);
	}
}
