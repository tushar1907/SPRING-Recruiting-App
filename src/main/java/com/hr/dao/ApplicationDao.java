package com.hr.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.hr.pojo.Application;
import com.hr.pojo.Job;
import com.hr.pojo.Student;
import com.hr.pojo.User;

public class ApplicationDao extends DAO {

	public ApplicationDao() {
	}	

	public Application createApplication(Application application) throws Exception {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(application);
			commit();
			return application;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	
	
	public List<Application> getApplication(String student_id) throws Exception {
		List<Application> applicationList = new ArrayList<Application>();
		
		String select_query = "from Application where student_id =:student_id";

		try {

			begin();
			Query q = getSession().createQuery(select_query);
			q.setString("student_id", student_id);
			applicationList = q.list();
			commit();
			return applicationList;

		} catch (Exception ex) {
			System.out.println("Cannot retrieve data " + ex.getMessage());
		}

		return null;
	}
	
	
	
	public List<Application> getAllApplication() throws Exception {
		List<Application> applicationList = new ArrayList<Application>();
		
		String select_query = "from Application";

		try {

			begin();
			Query q = getSession().createQuery(select_query);
			
			applicationList = q.list();
			commit();
			return applicationList;

		} catch (Exception ex) {
			System.out.println("Cannot retrieve data " + ex.getMessage());
		}

		return null;
	}
	
	
	public Application getapplication(String application_id) throws Exception {
		

		String select_query = "from Application where application_id = :application_id";

		try {

			begin();
			Query q = getSession().createQuery(select_query);
			q.setString("application_id", application_id);			
			//System.out.print(job_id);
			Application application = (Application) q.uniqueResult();
			
			commit();
			return application;
			

		} catch (Exception ex) {
			System.out.println("Cannot retrieve data " + ex.getMessage());
		}

		return null;
	}
}
