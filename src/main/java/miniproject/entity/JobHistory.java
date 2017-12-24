package miniproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the job_history database table.
 * 
 */
@Entity
@Table(name="job_history")
@NamedQuery(name="JobHistory.findAll", query="SELECT j FROM JobHistory j")
public class JobHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	JobHistoryPK id;
	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE", insertable=false, updatable=false)
	private Date startDate;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID", insertable=false, updatable=false)
	private Employee employee;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private Job job;

	public JobHistory() {
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}