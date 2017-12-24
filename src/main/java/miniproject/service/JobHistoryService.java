package miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniproject.entity.Department;
import miniproject.entity.JobHistory;
import miniproject.entity.JobHistoryPK;
import miniproject.repository.JobHistoryRepository;

@Service
public class JobHistoryService {

	@Autowired
	JobHistoryRepository jobHistoryRepository;

	public List<JobHistory> getAllJobHistories(){
		return (List) jobHistoryRepository.findAll();
	}

	
	public JobHistory getJobHistory(JobHistoryPK jobHistoryId){
		return jobHistoryRepository.findOne(jobHistoryId);
	}
	
	public JobHistory createJobHistory(JobHistory jobHistory,long departmentId){
		jobHistory.setDepartment(new Department(departmentId));
		return jobHistoryRepository.save(jobHistory);
	}
	
	
	public void deleteJobHistory(JobHistoryPK jobHistoryId){
		jobHistoryRepository.delete(jobHistoryId);
	}
}
