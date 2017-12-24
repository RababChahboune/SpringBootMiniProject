package miniproject.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import miniproject.entity.Region;


@Repository
public interface RegionRepository extends CrudRepository<Region, Long>{
	
}
