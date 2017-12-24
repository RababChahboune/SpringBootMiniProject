package miniproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface StatsRepository {

	@Query("select count(salary) from employees group by salary")
	public List<Long> getCountSalaty();
}
