package com.learneracademy.Entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.learneracademyutility.HibernateUtility;

public class MainApplication {
	static Session session = null;
	static Transaction tx = null;
	
	public static void addAdministration(Administration administration) {
		session = HibernateUtility.getSession();
		tx = session.beginTransaction();
		Administration admin = new Administration(administration.getName(),administration.getEmail(),
				administration.getPhone(),administration.getPassword(),
				administration.getCity());
		session.save(admin);
		tx.commit();
		session.disconnect();
		System.out.println("Admin added successfully");
	}

	public static boolean adminExist(String name,String email) {
		session = HibernateUtility.getSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("From Administration");
		List<Administration> adminList = query.list();
		for(Administration aList : adminList) {
			if(aList.getName().equals(name) && aList.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public static void addStudent(Student student) {
	   session = HibernateUtility.getSession();
	   tx = session.beginTransaction();
	   Student stu = new Student(student.getSname(), student.getCname(),student.getSubname(),student.getTname());
	   session.save(stu);
	   tx.commit();
	   session.close();
	   System.out.println("Student added Successfully");
	}
	
	public static boolean isValidAdmin(String name,String password) {
		session = HibernateUtility.getSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("From Administration");
		List<Administration> adminList = query.list();
		
		for(Administration aList : adminList) {
			if(aList.getName().equals(name) && aList.getPassword().equals(password))
					return true;
		}
		return false;
	}

	public static List<String> getStudentFromClass(String className) {
		session = HibernateUtility.getSession();
		tx = session.getTransaction();
		Query query = session.createQuery("From Student");
		List<Student> studentList = query.list();
		List<String> slist = new ArrayList<String>();
		for(Student student : studentList) {
			if(student.getCname().equals(className)) {
				slist.add(student.getSname());
				
			}
		}
		return slist;
	}


	
	public static boolean updateAdmin(Administration admin) {
        int id = getAdminId(admin.getName());
        if (id != -1) {
            Session session = HibernateUtility.getSession();

            Transaction tx = session.beginTransaction();

            Administration e = (Administration) session.get(Administration.class, id);
            e.setCity(admin.getCity());
            e.setPassword(admin.getPassword());
            e.setEmail(admin.getEmail());
            e.setPhone(admin.getPhone());
            session.update(e);
            tx.commit();
            return true;
        }

        return false;
    }

	private static int getAdminId(String name) {
		session = HibernateUtility.getSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("From Administration");
		  List<Administration> admins = query.list();

	        for (Administration admin : admins) {
	            if (admin.getName().equals(name)) {
	                return admin.getId();
	            }
	        }

	        return -1;
	}

	public static List<Student> getAllDetails() {
		session = HibernateUtility.getSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("From Student");
		List<Student> slist = query.list();
		return slist;
	}

	public static void deleteDetails(String id) {
		session = HibernateUtility.getSession();
		tx = session.beginTransaction();
		Student stu = new Student();
		stu.setId(Integer.parseInt(id));
		session.delete(stu);
		tx.commit();
		session.disconnect();
		System.out.println("Deleted successfully");
		
		
	}

	public static Student getStudentById(String id) {
		 Session session = HibernateUtility.getSession();
	        Transaction tx = session.beginTransaction();

	        Query query = session.createQuery("from Student");
	        List<Student> students = query.list();
	        for (Student student : students) {
	            if ((student.getId() + "").equals(id)) {
	                return student;
	            }
	        }
	        return null;
	}

	public static void updateStudent(Student s1) {
		Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();

        Student e = (Student) session.get(Student.class, s1.getId());
        e.setSname(s1.getSname());
        e.setCname(s1.getCname());
        e.setSubname(s1.getSubname());
        e.setTname(s1.getTname());

        session.update(e);
        tx.commit();
        System.out.println("Student update was successful");
		
	}
}

