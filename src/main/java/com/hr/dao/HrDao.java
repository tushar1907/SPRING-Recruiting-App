package com.hr.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.hr.pojo.Hr;
import com.hr.pojo.Student;

public class HrDao extends DAO {

	public HrDao() {
	}	

	public Hr register(Hr hr) throws Exception {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(hr);
			commit();
			return hr;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	
	
public Boolean getID(int u) throws Exception {
		
		try {
			begin();
			Query q = getSession().createQuery("from Hr where hr_id = :hr_ID");
			q.setLong("hr_ID", u);
				
			Hr hr = (Hr) q.uniqueResult();
			commit();
			if(hr!=null) {
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