package miniproject.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import miniproject.entity.Country;


@RepositoryRestResource()
public interface CountryRepository extends CrudRepository<Country,String>{
}
