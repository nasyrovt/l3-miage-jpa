package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.GraduationClass;
import fr.uga.im2ag.l3.miage.db.repository.api.GraduationClassRepository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraduationClassTest extends Base {

    GraduationClassRepository classRepository;

    @BeforeEach
    void before() {
        classRepository = daoFactory.newGraduationClassRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveClass() {
        // TODO
   	final var gClass = Fixtures.createClass() ; 
   	
   	
    	entityManager.getTransaction().begin();
    	classRepository.save(gClass);
    	entityManager.getTransaction().commit();
   	 	entityManager.detach(gClass);
   	 	
   	 	var check_graduation = classRepository.findById(gClass.getId());
   	 assertThat(check_graduation).isNotNull().isNotSameAs(gClass);
   	assertThat(check_graduation.getName()).isEqualTo(gClass.getName());
    assertThat(check_graduation.getYear()).isEqualTo(gClass.getYear());
    }


    @Test
    void shouldFindByYearAndName() {
    	final var gClass = Fixtures.createClass();
    	gClass.setName("Math");
    	gClass.setYear(2012);
    	gClass.setStudents(null);
    	entityManager.getTransaction().begin();
    	entityManager.persist(gClass);
    	entityManager.getTransaction().commit();
   	 	entityManager.detach(gClass);
   	 	
    	classRepository.findByYearAndName(2012, "Math");
       // classRepository.findByYearAndName(2012, "Math");
    }

}
