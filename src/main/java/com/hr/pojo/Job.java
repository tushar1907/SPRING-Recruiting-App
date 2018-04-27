package com.hr.pojo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.DiscriminatorColumn;


@Entity
@Table(name = "job_table")
public class Job {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_id", unique = true, nullable = false)
    private long job_id;

	@Column(name = "jobDesc")
	private String jobDesc;	
	
	@Column(name = "status")
	private String status;	
	
	public Job() {
	
	}

	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public long getJob_id() {
		return job_id;
	}


	public String getJobDesc() {
		return jobDesc;
	}


	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	
	
}
