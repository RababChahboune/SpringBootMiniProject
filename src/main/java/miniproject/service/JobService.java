package miniproject.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniproject.entity.Job;
import miniproject.entity.Location;
import miniproject.repository.JobRepository;

@Service
public class JobService {

	
	@Autowired
	JobRepository jobRepository;

	public List<Job> getAllJobs(){
		return (List) jobRepository.findAll();
	}

	
	public Job getJob(String jobId){
		return jobRepository.findOne(jobId);
	}
	
	public Job createJob(Job job){
		return jobRepository.save(job);
	}
	
	
	public void deleteJob(String jobId){
		jobRepository.delete(jobId);
	}
}
