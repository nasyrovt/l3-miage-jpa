package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.*;
import fr.uga.im2ag.l3.miage.db.model.Person.Gender;

import fr.uga.im2ag.l3.miage.db.repository.api.StudentRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest extends Base {

    StudentRepository studentRepository;

    @BeforeEach
    void before() {
        studentRepository = daoFactory.newStudentRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveStudent() {
    	final var gclass = Fixtures.createClass();
    	gclass.setName("L3MIAGE");
    	gclass.setYear(2018);
    	gclass.setStudents(null);
        final var student = Fixtures.createStudent(gclass);
        
        entityManager.getTransaction().begin();
        entityManager.persist(gclass);
        studentRepository.save(student);
        entityManager.getTransaction().commit();
        entityManager.detach(student);
        
        var pStudent = studentRepository.findById(student.getId());
        assertThat(pStudent).isNotNull().isNotSameAs(student);
        assertThat(pStudent.getFirstName()).isEqualTo(student.getFirstName());
        assertThat(pStudent.getLastName()).isEqualTo(student.getLastName());
        assertThat(pStudent.getGender()).isEqualTo(student.getGender());
     //   assertThat(pStudent.getBirth()).isEqualTo(student.getBirth());


    }

    @Test
    void shouldFindStudentHavingGradeAverageAbove() {
        // TODO
    	Subject subject = Fixtures.createSubject();
    	
     	subject.setName("Math");
     	subject.setHours((float) 5.0);
     	
     	 // Create a date object
     	@SuppressWarnings("deprecation")
     	
		Date d = new Date(2022,2,28);
     	@SuppressWarnings("deprecation")
     	Date e = new Date(2022,3,1);
     	
     	subject.setStart(d);
     	subject.setPoints(5);
     	subject.setEnd(e);
     	
     	
   	 	
   	 	//creation de la variable grade_a
   	 	
    	var grade_a = Fixtures.createGrade(subject);
    	grade_a.setValue(10.0f);
    	grade_a.setWeight(1.5f);
    	
    	
   	 	
   	 final var gclass = Fixtures.createClass();
 	gclass.setName("L3MIAGE");
 	gclass.setYear(2018);
 	gclass.setStudents(null);
     
 	final var student = Fixtures.createStudent(gclass);
     student.setFirstName("Dmitrii");
     
     student.setGender(Gender.MALE);
     
     Date Dmitrii_bth = new Date(1999,3,18);
     student.setBirth(Dmitrii_bth);
     
     List<Grade> list=new ArrayList<Grade>(); 
     list.add(grade_a);
     
     student.setGrades( list);
     student.setBelongTo(gclass);
     student.setLastName("Crivoi");
     
     entityManager.getTransaction().begin();
     
     entityManager.persist(subject);
     entityManager.persist(gclass);
 	entityManager.persist(grade_a);
 	entityManager.persist(student);
 	
 	entityManager.getTransaction().commit();
	 
 	entityManager.detach(subject);
 	  entityManager.detach(gclass);
	 	entityManager.detach(grade_a);
	 entityManager.detach(student);
     
     
   	 	
   	 	
    	studentRepository.findStudentHavingGradeAverageAbove(10);
    }

}
