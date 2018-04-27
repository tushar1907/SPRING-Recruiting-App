package com.hr.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hr.pojo.Job;
import com.hr.pojo.User;

public class JobDao extends DAO {

	public JobDao() {

	}

	public Job createJob(Job job) throws Exception {
		try {
			begin();			
			getSession().save(job);
			commit();
			return job;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}

	public List<Job> getJobs() throws Exception {
		List<Job> jobList = new ArrayList<Job>();

		String select_query = "from Job";

		try {

			begin();
			Query q = getSession().createQuery(select_query);
			jobList = q.list();
			commit();
			return jobList;

		} catch (Exception ex) {
			System.out.println("Cannot retrieve data " + ex.getMessage());
		}

		return null;
	}
	
	public List<Job> getOpenJobs() throws Exception {
		List<Job> jobList = new ArrayList<Job>();

		String select_query = "from Job where status =:status";

		try {

			begin();
			Query q = getSession().createQuery(select_query);
			q.setString("status","OPEN");	
			jobList = q.list();
			commit();
			return jobList;

		} catch (Exception ex) {
			System.out.println("Cannot retrieve data " + ex.getMessage());
		}

		return null;
	}
	
	public List<Job> getProgressJobs() throws Exception {
		List<Job> jobList = new ArrayList<Job>();

		String select_query = "from Job where status =:status";

		try {

			begin();
			Query q = getSession().createQuery(select_query);
			q.setString("status","PROGRESS");	
			jobList = q.list();
			commit();
			return jobList;

		} catch (Exception ex) {
			System.out.println("Cannot retrieve data " + ex.getMessage());
		}

		return null;
	}
	public Job getJob(String job_id) throws Exception {
		List<Job> jobList = new ArrayList<Job>();

		String select_query = "from Job where job_id = :job_id";

		try {

			begin();
			Query q = getSession().createQuery(select_query);
			q.setString("job_id", job_id);			
			System.out.print(job_id);
			Job job = (Job) q.uniqueResult();
			System.out.print(job);
			commit();
			return job;
			

		} catch (Exception ex) {
			System.out.println("Cannot retrieve data " + ex.getMessage());
		}

		return null;
	}
}
