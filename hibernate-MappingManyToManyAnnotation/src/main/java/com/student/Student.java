package com.student;

// Generated Apr 2, 2016 9:43:41 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name = "STUDENT", uniqueConstraints = @UniqueConstraint(columnNames = "STUDENT_CODE"))
public class Student implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal studentId;
	private String studentCode;
	private String studentName;
	private BigDecimal studentAge;
	private Set<Subject> subjects = new HashSet<Subject>(0);

	public Student() {
	}
	
	public Student(String studentCode,
			String studentName, BigDecimal studentAge) {
		this.studentCode = studentCode;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	public Student(BigDecimal studentId, String studentCode,
			String studentName, BigDecimal studentAge) {
		this.studentId = studentId;
		this.studentCode = studentCode;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	public Student(BigDecimal studentId, String studentCode,
			String studentName, BigDecimal studentAge, Set<Subject> subjects) {
		this.studentId = studentId;
		this.studentCode = studentCode;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.subjects = subjects;
	}

	@Id
	@Column(name = "STUDENT_ID", unique = true, nullable = false, precision = 22, scale = 0)
	@GeneratedValue(generator="student_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="student_seq", sequenceName="STUDENT_SEQ")
	public BigDecimal getStudentId() {
		return this.studentId;
	}

	public void setStudentId(BigDecimal studentId) {
		this.studentId = studentId;
	}

	@Column(name = "STUDENT_CODE", unique = true, nullable = false, length = 10)
	public String getStudentCode() {
		return this.studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	@Column(name = "STUDENT_NAME", nullable = false, length = 30)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "STUDENT_AGE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getStudentAge() {
		return this.studentAge;
	}

	public void setStudentAge(BigDecimal studentAge) {
		this.studentAge = studentAge;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "STUDENT_SUBJECT", joinColumns = { @JoinColumn(name = "STUDENT_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "SUBJECT_ID", nullable = false, updatable = false) })
	public Set<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

}
