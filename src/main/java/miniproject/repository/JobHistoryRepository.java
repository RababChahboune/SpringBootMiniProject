package miniproject.repository;

import org.springframework.data.repository.CrudRepository;

import miniproject.entity.JobHistory;
import miniproject.entity.JobHistoryPK;


public interface JobHistoryRepository extends CrudRepository<JobHistory, JobHistoryPK> {
	

}
