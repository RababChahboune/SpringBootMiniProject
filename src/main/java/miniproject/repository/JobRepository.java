package miniproject.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import miniproject.entity.Job;


@RepositoryRestResource
public interface JobRepository extends CrudRepository<Job, String>{

	List<Job> findByMinSalaryGreaterThanOrderByMaxSalaryDesc(BigDecimal salary);

}
