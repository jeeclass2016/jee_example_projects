package com;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.student.Student;
import com.student.Subject;
import com.util.HibernateUtil;

public class App {

	Session session;
	Transaction tx = null;

	public static void main(String[] args) {
		System.out.println("Hibernate Many to Many (Annotation mapping)");

		App app = new App();
//		app.addStudent();
		app.listStudents();

		System.out.println("Done");
	}

	/**
	 * CREATE Stock
	 */
	public void addStudent() {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			
			Student student1 = new Student("SV001","Sinh vien 1", new BigDecimal(18));
			Student student2 = new Student("SV002","Sinh vien 2", new BigDecimal(18));
			Student student3 = new Student("SV003","Sinh vien 3", new BigDecimal(20));
			
			Subject subject1 = new Subject("Math", "This is one of the most difficult subject. But it's very interesting");
			Subject subject2 = new Subject("Physic", "Learn this subject, you can repair electric equipment in your house by yourself");
			Subject subject3 = new Subject("Philosophy", "Well, this is one of subject Vietnamese student doesn't want to learn.");
			
			student1.getSubjects().add(subject1);
			student1.getSubjects().add(subject2);
			
			student2.getSubjects().add(subject1);
			student2.getSubjects().add(subject3);
			
			student3.getSubjects().add(subject3);
			
			session.save(student1);		
			session.save(student2);	
			session.save(student3);	

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * READ all students information in database
	 */
	public void listStudents() {

		session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Student> students = (List<Student>) session.createQuery(
					"FROM com.student.Student").list();
			System.out.println("After gt list: " + students.size());
			Set<Subject> subjects;
			for (Student std : students) {
				if (std == null) {
					continue;
				}
				System.out.print("STUDENT ID: " + std.getStudentId());
				System.out.print(" STUDENT CODE: " + std.getStudentCode());
				System.out.print(" STUDENT NAME: " + std.getStudentName());
				System.out.println(" STUDENT AGE: " + std.getStudentAge());
				System.out.println("=======================================");
				
				subjects = std.getSubjects();
				for(Subject subject : subjects) {
					if (subject == null) {
						continue;
					}
					System.out.print("SUBJECT NAME: " + subject.getSubjectName());
					System.out.print(" SUBJECT DESC: " + subject.getSubjectDesc());
				}
				System.out.println("*************************************************");
			}

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * UPDATE a stock information in database
	 */
	public void updateStock() {

	}

	/**
	 * DELETE a stock information in database
	 */
	public void deleteStock() {

	}

}
