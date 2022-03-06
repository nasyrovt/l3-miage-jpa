package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.Grade;
import static org.assertj.core.api.Assertions.assertThat;
import fr.uga.im2ag.l3.miage.db.model.GraduationClass;
import fr.uga.im2ag.l3.miage.db.model.Subject;
import fr.uga.im2ag.l3.miage.db.model.Teacher;
import fr.uga.im2ag.l3.miage.db.model.Person.Gender;
import fr.uga.im2ag.l3.miage.db.model.Student;
import fr.uga.im2ag.l3.miage.db.repository.api.TeacherRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeacherTest extends Base {

    TeacherRepository teacherRepository;

    @BeforeEach
    void before() {
        teacherRepository = daoFactory.newTeacherRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveTeacher()  {

    	Subject Subject = Fixtures.createSubject();
    	
    	Subject.setName("BD");
    	
    	GraduationClass GraduationClass = new GraduationClass();
    	
    	GraduationClass.setName("GMP");
    	GraduationClass.setYear(2016);
    	GraduationClass.setStudents(null);
    	
    	var FirstGrade = Fixtures.createGrade(Subject);
    	FirstGrade.setValue(9.0f);
    	FirstGrade.setWeight(1.5f);
    	
    	var SecondGrade = Fixtures.createGrade(Subject);
    	SecondGrade.setValue(15.0f);
    	SecondGrade.setWeight(1.5f);
    	
   

    	Teacher Teacher = Fixtures.createTeacher(Subject, GraduationClass,null);
    	
    	  entityManager.getTransaction().begin();

    	  entityManager.persist(Subject);

		  entityManager.persist(GraduationClass);

		  entityManager.persist(FirstGrade);
    	  entityManager.persist(SecondGrade);

		  entityManager.persist(Teacher);

		  entityManager.getTransaction().commit();

		  entityManager.detach(Subject);

		  entityManager.detach(GraduationClass);

		  entityManager.detach(FirstGrade);
    	  entityManager.detach(SecondGrade);

		  entityManager.detach(Teacher);
    	  
    	  var TeacherTest = teacherRepository.findById(Teacher.getId());
    	  assertThat(TeacherTest.getId()==1);
    	  assertThat(TeacherTest.getHeading().getName().equals("GMP"));
    	  assertThat(TeacherTest.getTeaching().getName().equals("BD"));
    	
    }

    @Test
    void shouldFindHeadingGraduationClassByYearAndName() {
        
		Subject Subject = Fixtures.createSubject();
    	
    	Subject.setName("French");
    	
    	GraduationClass GraduationClass = new GraduationClass();
    	
    	GraduationClass.setName("GDP");
    	GraduationClass.setYear(2020);
    	GraduationClass.setStudents(null);
    	
    	var FirstGrade = Fixtures.createGrade(Subject);
    	FirstGrade.setValue(12.0f);
    	FirstGrade.setWeight(1.5f);
    	
    	var SecondGrade = Fixtures.createGrade(Subject);
    	SecondGrade.setValue(12.0f);
    	SecondGrade.setWeight(1.5f);
    	
   

    	Teacher Teacher = Fixtures.createTeacher(Subject, GraduationClass,null);
    	Teacher.setFirstName("Kendra");
    	

		entityManager.getTransaction().begin();

		entityManager.persist(Subject);

		entityManager.persist(GraduationClass);

		entityManager.persist(FirstGrade);
   	  	entityManager.persist(SecondGrade);

		entityManager.persist(Teacher);

		entityManager.getTransaction().commit();

		entityManager.detach(Subject);

		entityManager.detach(GraduationClass);

		entityManager.detach(FirstGrade);
   	  	entityManager.detach(SecondGrade);

		entityManager.detach(Teacher);
   	  
   	 	assertThat(teacherRepository.findHeadingGraduationClassByYearAndName(2020, "GDP").getFirstName().equals("Kendra"));
   		assertThat(teacherRepository.findHeadingGraduationClassByYearAndName(2020, "GDP").getHeading().getName().equals("French"));
   		assertThat(teacherRepository.findHeadingGraduationClassByYearAndName(2020, "GDP").getHeading().getYear() == 2020);

    }

}
