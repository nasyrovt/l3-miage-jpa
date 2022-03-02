package fr.uga.im2ag.l3.miage.db.repository;
import java.sql.Date;

import java.time.LocalDate;
import fr.uga.im2ag.l3.miage.db.repository.api.GradeRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.SubjectRepository;
import fr.uga.im2ag.l3.miage.db.model.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class GradeTest extends Base {

    GradeRepository gradeRepository;

    @BeforeEach
    void before() {
        gradeRepository = daoFactory.newGradeRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveGrade() {
        // TODO
    
    	
    	Subject subject = Fixtures.createSubject();
    	//subject.setId((long)1);
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
     	
    	 final var grade = Fixtures.createGrade(subject) ;
    	 
    	
    	 
    	
    	 entityManager.getTransaction().begin();
    	  entityManager.persist(subject); 
    	 gradeRepository.save(grade);
    	 entityManager.getTransaction().commit();
    	 entityManager.detach(subject);
    	 entityManager.detach(grade);
    	 
    	 var pGrade = gradeRepository.findById(grade.getId());
    	 assertThat(pGrade).isNotNull().isNotSameAs(grade);
         assertThat(pGrade.getValue()).isEqualTo(grade.getValue());
         assertThat(pGrade.getWeight()).isEqualTo(grade.getWeight());
    }

    @Test
    void shouldFailUpgradeGrade() {
        // TODO, ici tester que la mise à jour n'a pas eu lieu.
    }

    @Test
    void shouldFindHighestGrades() {
        // TODO
    	gradeRepository.findHighestGrades(15);
    }

    @Test
    void shouldFindHighestGradesBySubject() {
        // TODO
    	final var subject = Fixtures.createSubject();
   	 //subject.setId((long)1);
    	subject.setName("Physics");
    	subject.setHours((float) 5.0);
    	 // Create a date object
    	Date d = new Date(2022,2,28);
    	subject.setStart(d);
    	subject.setPoints(5);
    	subject.setEnd(d);
    	entityManager.getTransaction().begin();
    	entityManager.persist(subject);
    	entityManager.getTransaction().commit();
   	 	entityManager.detach(subject);
    	gradeRepository.findHighestGradesBySubject(5, subject);
    	
    	final var subject_2 = Fixtures.createSubject();
      	 //subject.setId((long)1);
       	subject.setName("GEO");
       	subject.setHours((float) 2.0);
       	 // Create a date object
       	Date data = new Date(2022,2,28);
       	subject.setStart(data);
       	subject.setPoints(5);
       	subject.setEnd(data);
       	gradeRepository.findHighestGradesBySubject(5, subject_2);
       	
    }

}
