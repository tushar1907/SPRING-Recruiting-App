package com.hr.pojo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "application_table")
public class Application {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="application_id", unique = true, nullable = false)
    private long application_id;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")	
	private Job job;	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")	
	private User user;
	
	
	
	public Application() {
		
		this.job = job;
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getApplication_id() {
		return application_id;
	}

	public void setApplication_id(long application_id) {
		this.application_id = application_id;
	}

	
	
	
}
