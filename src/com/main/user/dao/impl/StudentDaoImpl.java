package com.main.user.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.service.ServiceRegistry;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.main.common.bean.Page;
import com.main.common.bean.PageBean;
import com.main.common.util.PageUtil;
import com.main.user.bean.StudentBean;
import com.main.user.dao.IStudentDao;
import com.main.user.model.Student;

@Repository
public class StudentDaoImpl implements IStudentDao{

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public Student addStudent(Student student) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
		return student;
	}

	@Override
	public Page<Student> findStudents(StudentBean queryBean,PageBean pageBean) {
		StringBuffer hql = new StringBuffer(" from Student  where 1 = 1");
		Page<Student> page = new Page<Student>();;
		Session session = sessionFactory.getCurrentSession();
		if (queryBean!=null) {
			if (queryBean.getStudentName()!=null && !"".equals(queryBean.getStudentName())) {
				hql.append(" and studentName like '%"+queryBean.getStudentName()+"%'");
			}
		}
		Query query = session.createQuery(hql.toString());
		 //设置每页显示多少个，设置多大结果。  
		int totalCount =getCount();
		PageBean pageBean2 = PageBean.createPage(pageBean.getPageSize(), totalCount, pageBean.getCurrentPage());
        query.setMaxResults(pageBean2.getPageSize());  
        //设置起点  
        query.setFirstResult(pageBean2.getBeginIndex());  
		List<Student> students = query.list();
		if (students!=null && students.size()>0) {
			page.setData(students);
			page.setPageBean(pageBean2);
			
		}
		return page;
	}

	@Override
	public Student queryStident(String sid) {
		Session session = sessionFactory.getCurrentSession();		
		return (Student) session.get(Student.class, Integer.parseInt(sid));
	}

	@Override
	public void deleteStudent(String sid) {
		Session session = sessionFactory.getCurrentSession();
		Student s = queryStident(sid);
		if (s!=null) {
			session.delete(s);
			session.flush();
		}
		
	}

	@Override
	public void updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		Student saveStudent = (Student) session.get(Student.class, student.getId());
		saveStudent.setAge(student.getAge());
		saveStudent.setStudentName(student.getStudentName());
		session.update(saveStudent);
		session.flush();
	}
	
	public int getCount(){
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from Student";
		Query query = session.createQuery(hql);
		List d = query.list();		
		session.close();
		return Integer.parseInt(d.get(0).toString()) ;
	}
}
