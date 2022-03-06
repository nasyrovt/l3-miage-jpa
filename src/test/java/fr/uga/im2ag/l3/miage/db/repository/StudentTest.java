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
    	final var NewGraduationClass = Fixtures.createClass();
    	NewGraduationClass.setName("CheckClass");
    	NewGraduationClass.setYear(2022);
    	NewGraduationClass.setStudents(null);
        final var Student = Fixtures.createStudent(NewGraduationClass);
        
        entityManager.getTransaction().begin();
        entityManager.persist(NewGraduationClass);

        studentRepository.save(Student);
        entityManager.getTransaction().commit();
        entityManager.detach(Student);
        
        var CheckStudent = studentRepository.findById(Student.getId());
        assertThat(CheckStudent).isNotNull().isNotSameAs(Student);
        assertThat(CheckStudent.getFirstName()).isEqualTo(Student.getFirstName());
        assertThat(CheckStudent.getLastName()).isEqualTo(Student.getLastName());
        assertThat(CheckStudent.getGender()).isEqualTo(Student.getGender());
    }

    @Test
    void shouldFindStudentHavingGradeAverageAbove() {

        Subject NewSubject = Fixtures.createSubject();
    	
     	NewSubject.setName("CL&IHM");
     	NewSubject.setHours((float) 5.0);

        @SuppressWarnings("deprecation")
        Date StartDate = new Date(2022,2,28);

        @SuppressWarnings("deprecation")
     	Date EndDate = new Date(2022,3,1);
     	
     	NewSubject.setStart(StartDate);
     	NewSubject.setPoints(5);
     	NewSubject.setEnd(EndDate);
   	 	
    	var FirstGrade = Fixtures.createGrade(NewSubject);
    	FirstGrade.setValue(10.0f);
    	FirstGrade.setWeight(1.5f);
    	
    	var SecondGrade = Fixtures.createGrade(NewSubject);
    	SecondGrade.setValue(12.0f);
    	SecondGrade.setWeight(1.5f);
   	 	
   	    final var GraduationClass = Fixtures.createClass();
        GraduationClass.setName("L3MIAGE");
        GraduationClass.setYear(2022);
        GraduationClass.setStudents(null);
     
 	    final var Student = Fixtures.createStudent(GraduationClass);

        Student.setFirstName("Nurbek");
        Student.setGender(Gender.MALE);

        Date NurbekBirthDay = new Date(1987,5,18);
        Student.setBirth(NurbekBirthDay);

        List<Grade> GradeList=new ArrayList<Grade>();
        GradeList.add(FirstGrade);
        GradeList.add(SecondGrade);

        Student.setGrades(GradeList);
        Student.setBelongTo(GraduationClass);
        Student.setLastName("Serzhanov");

        entityManager.getTransaction().begin();

        entityManager.persist(NewSubject);
        entityManager.persist(GraduationClass);

        entityManager.persist(FirstGrade);
        entityManager.persist(SecondGrade);

        entityManager.persist(Student);

        entityManager.getTransaction().commit();

        entityManager.detach(NewSubject);
        entityManager.detach(GraduationClass);
        entityManager.detach(FirstGrade);
        entityManager.detach(SecondGrade);
        entityManager.detach(Student);

        assertThat(studentRepository.findStudentHavingGradeAverageAbove(16.5f).get(0).getFirstName()=="Nurbek");

    }

}
