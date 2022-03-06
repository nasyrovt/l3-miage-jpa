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
    	final var GraduationClass = Fixtures.createClass();
    	GraduationClass.setName("L3MIAGE");
    	GraduationClass.setYear(2022);
    	GraduationClass.setStudents(null);
        final var student = Fixtures.createStudent(GraduationClass);
        
        entityManager.getTransaction().begin();
        entityManager.persist(GraduationClass);
        studentRepository.save(student);
        entityManager.getTransaction().commit();
        entityManager.detach(student);
        
        var pStudent = studentRepository.findById(student.getId());
        assertThat(pStudent).isNotNull().isNotSameAs(student);
        assertThat(pStudent.getFirstName()).isEqualTo(student.getFirstName());
        assertThat(pStudent.getLastName()).isEqualTo(student.getLastName());
        assertThat(pStudent.getGender()).isEqualTo(student.getGender());


    }

    @Test
    void shouldFindStudentHavingGradeAverageAbove() {
    	Subject subject = Fixtures.createSubject();
    	
     	subject.setName("BD-JPA");
     	subject.setHours((float) 5.0);
     	
     	 // Create a StartDate and EndDate object
     	@SuppressWarnings("deprecation")
		Date StartDate = new Date(2022,2,28);
     	@SuppressWarnings("deprecation")
     	Date EndDate = new Date(2022,3,1);
     	
     	subject.setStart(StartDate);
     	subject.setPoints(5);
     	subject.setEnd(EndDate);
     	
     	
   	 	
   	 	//creation de la variable FirstGrade
   	 	
    	var FirstGrade = Fixtures.createGrade(subject);
    	FirstGrade.setValue(10.0f);
    	FirstGrade.setWeight(1.5f);
    	
    	var SecondGrade = Fixtures.createGrade(subject);
    	SecondGrade.setValue(12.0f);
    	SecondGrade.setWeight(1.5f);
   	 	
   	 final var GraduationClass = Fixtures.createClass();
 	GraduationClass.setName("L3MIAGE");
 	GraduationClass.setYear(2018);
 	GraduationClass.setStudents(null);
     
 	final var student = Fixtures.createStudent(GraduationClass);
     student.setFirstName("Alfredo");
     
     student.setGender(Gender.MALE);
     
     Date StudentBirthDate = new Date(1997,3,22);
     student.setBirth(StudentBirthDate);
     
     List<Grade> ListOfGrades=new ArrayList<Grade>();
     ListOfGrades.add(FirstGrade);
     ListOfGrades.add(SecondGrade);
     
     student.setGrades( ListOfGrades);
     student.setBelongTo(GraduationClass);
     student.setLastName("Cappucino");

     entityManager.getTransaction().begin();
     
     entityManager.persist(subject);
     entityManager.persist(GraduationClass);
     entityManager.persist(FirstGrade);
     entityManager.persist(SecondGrade);
     entityManager.persist(student);

     entityManager.getTransaction().commit();

     entityManager.detach(subject);
     entityManager.detach(GraduationClass);
     entityManager.detach(FirstGrade);
     entityManager.detach(SecondGrade);
	 entityManager.detach(student);

     studentRepository.findStudentHavingGradeAverageAbove(16.5f);
    }

}
