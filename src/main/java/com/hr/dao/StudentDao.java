package com.hr.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.hr.pojo.Student;
import com.hr.pojo.User;


public class StudentDao extends DAO {

	public StudentDao() {
	}	

	public Student register(Student student) throws Exception {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(student);
			commit();
			return student;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	
	public Boolean getID(int u) throws Exception {
		
		try {
			begin();
			Query q = getSession().createQuery("from Student where student_id = :student_ID");
			q.setLong("student_ID", u);
				
			Student student = (Student) q.uniqueResult();
			commit();
			if(student!=null) {
				return true;
				
			}else {
				return false;
			}			
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get student with id " + u, e);
		}
		
	}
	
	


}