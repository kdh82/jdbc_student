package kr.or.dgit.jdbc;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.jdbc.dto.Student;
import kr.or.dgit.jdbc.service.StudentService;

public class StudentServiceTest {
	private static StudentService studentservice;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentservice = StudentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentservice = null;
	}

	@Test
	public void testInsertStudent() {
		Student insStudent = new Student(4, "김두환", "kdh@test.co.kr", new Date());
		int res = studentservice.insertStudent(insStudent);
		Assert.assertEquals(1, res);
	}
	@Test
	public void testfindAllStudents(){
		List<Student> lists = studentservice.findAllStudents();
		for(Student s : lists){
			System.out.println(s);
		}
		
		Assert.assertNotNull(lists);
	}
}
