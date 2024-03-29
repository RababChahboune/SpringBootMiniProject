package miniproject.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The primary key class for the job_history database table.
 * 
 */
@Embeddable
public class JobHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EMPLOYEE_ID")
	private long employeeId;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date startDate;

	public JobHistoryPK() {
	}
	public long getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobHistoryPK)) {
			return false;
		}
		JobHistoryPK castOther = (JobHistoryPK)other;
		return 
			(this.employeeId == castOther.employeeId)
			&& this.startDate.equals(castOther.startDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.employeeId ^ (this.employeeId >>> 32)));
		hash = hash * prime + this.startDate.hashCode();
		
		return hash;
	}
}