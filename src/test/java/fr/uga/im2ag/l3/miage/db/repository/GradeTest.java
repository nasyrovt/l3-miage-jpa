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
    
    	
    	Subject subject = Fixtures.createSubject();
     	subject.setName("Math");
     	subject.setHours((float) 5.0);
     	 // Create a date object
        @SuppressWarnings("deprecation")
        Date StartDate = new Date(2022,2,28);

        @SuppressWarnings("deprecation")
     	Date EndDate = new Date(2022,3,1);
     	
     	subject.setStart(StartDate);
     	subject.setPoints(5);
     	subject.setEnd(EndDate);
     	
    	 final var Grade = Fixtures.createGrade(subject) ;
    	 

    	 entityManager.getTransaction().begin();
         entityManager.persist(subject);
    	 gradeRepository.save(Grade);
    	 entityManager.getTransaction().commit();
    	 entityManager.detach(subject);
    	 entityManager.detach(Grade);
    	 
    	 var pGrade = gradeRepository.findById(Grade.getId());
    	 assertThat(pGrade).isNotNull().isNotSameAs(Grade);
         assertThat(pGrade.getValue()).isEqualTo(Grade.getValue());
         assertThat(pGrade.getWeight()).isEqualTo(Grade.getWeight());
    }

    @Test
    void shouldFailUpgradeGrade() {
    	final var Subject = Fixtures.createSubject();
        final var Grade = Fixtures.createGrade(Subject);

        float CurrentGrade = Grade.getValue();
        entityManager.getTransaction().begin();
        entityManager.persist(Subject);
        gradeRepository.save(Grade);
        gradeRepository.findById(Grade.getId()).setValue(2000f); // updating value after saved
        entityManager.getTransaction().commit();
        entityManager.detach(Grade);

        
        var Result = gradeRepository.findById(Grade.getId());
        
        assertThat(Result.getValue()).isEqualTo(CurrentGrade);
        assertThat(Result.getValue()).isNotEqualTo(2000f);
    }

    @Test
    void shouldFindHighestGrades() {
    	final var Subject = Fixtures.createSubject();
        final var FirstGrade = Fixtures.createGrade(Subject);
        final var SecondGrade = Fixtures.createGrade(Subject);
        final var ThirdGrade = Fixtures.createGrade(Subject);

        entityManager.getTransaction().begin();
        // need to persist the Subject to avoid error
        entityManager.persist(Subject);
        gradeRepository.save(FirstGrade);
        gradeRepository.save(SecondGrade);
        gradeRepository.save(ThirdGrade);
        entityManager.getTransaction().commit();
        
        FirstGrade.setValue((float) 10.2);
        SecondGrade.setValue((float) 15.4);
        ThirdGrade.setValue((float) 18.0);

        var Result = gradeRepository.findHighestGrades(1);

        assertThat(Result).isNotNull();
        assertThat(Result.size()).isEqualTo(1);
        assertThat(Result.get(0).getValue()).isEqualTo(ThirdGrade.getValue());
    }

    @Test
    void shouldFindHighestGradesBySubject() {

        final var Subject = Fixtures.createSubject();

    	Subject.setName("BD-JPA");
    	Subject.setHours((float) 6.0);
    	Date StartEndDate = new Date(2022,2,28);

        Subject.setStart(StartEndDate);
    	Subject.setPoints(5);
    	Subject.setEnd(StartEndDate);

        entityManager.getTransaction().begin();
    	entityManager.persist(Subject);
    	entityManager.getTransaction().commit();
   	 	entityManager.detach(Subject);
   	 	
    	gradeRepository.findHighestGradesBySubject(5, Subject);
    	
    	final var OtherSubject = Fixtures.createSubject();

       	Subject.setName("CL&IHM");
       	Subject.setHours((float) 2.0);
       	Date OtherStartEndDate = new Date(2022,2,28);

        Subject.setStart(OtherStartEndDate);
       	Subject.setPoints(5);
       	Subject.setEnd(OtherStartEndDate);
       	
       	gradeRepository.findHighestGradesBySubject(5, OtherSubject);
       	
    }

}
