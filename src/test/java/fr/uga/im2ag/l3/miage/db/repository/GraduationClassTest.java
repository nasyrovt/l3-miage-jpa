package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.Grade;
import fr.uga.im2ag.l3.miage.db.model.GraduationClass;
import fr.uga.im2ag.l3.miage.db.model.Student;
import fr.uga.im2ag.l3.miage.db.model.Person.Gender;
import fr.uga.im2ag.l3.miage.db.repository.api.GraduationClassRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

   		final var GraduationClass = Fixtures.createClass() ;
   	
   	
    	entityManager.getTransaction().begin();
    	classRepository.save(GraduationClass);
    	entityManager.getTransaction().commit();
   	 	entityManager.detach(GraduationClass);
   	 	
   	 	var CheckGraduationClass = classRepository.findById(GraduationClass.getId());
   	 	assertThat(CheckGraduationClass).isNotNull().isNotSameAs(GraduationClass);
   		assertThat(CheckGraduationClass.getName()).isEqualTo(GraduationClass.getName());
    	assertThat(CheckGraduationClass.getYear()).isEqualTo(GraduationClass.getYear());
    }


    @Test
    void shouldFindByYearAndName() {

		//First Test
    	GraduationClass CLIHMGraduationClass = new GraduationClass();
    	CLIHMGraduationClass.setName("CLIHM");
    	CLIHMGraduationClass.setYear(2016);
    	CLIHMGraduationClass.setStudents(null);

		//Second Test
    	GraduationClass MathGraduationClass = Fixtures.createClass();
    	MathGraduationClass.setName("Math");
    	MathGraduationClass.setYear(2015);
    	MathGraduationClass.setStudents(null);

		//Third Test
    	GraduationClass BDJPAGraduationClass = Fixtures.createClass();
    	
    	BDJPAGraduationClass.setName("BD-JPA");
    	BDJPAGraduationClass.setYear(2018);
    	BDJPAGraduationClass.setStudents(null);
    	
    	entityManager.getTransaction().begin();

		classRepository.save(CLIHMGraduationClass);
    	classRepository.save(MathGraduationClass);
    	classRepository.save(BDJPAGraduationClass);
    	
    	entityManager.getTransaction().commit();
    	entityManager.detach(CLIHMGraduationClass);
    	entityManager.detach(MathGraduationClass);
    	entityManager.detach(BDJPAGraduationClass);

    	List<GraduationClass> GraduationClasses = classRepository.getAll();
    	for ( GraduationClass g : GraduationClasses) {
    		System.out.println(g.getName());
    		System.out.println(g.getYear());
    	}
   	 
    	assertThat( classRepository.findByYearAndName(2015, "Math").getYear()==2015 && classRepository.findByYearAndName(2015, "Math").getName().equals("Math"));
    	assertThat( classRepository.findByYearAndName(2016, "CLIHM").getYear()==2016 && classRepository.findByYearAndName(2016, "CLIHM").getName().equals("CLIHM"));
    	assertThat( classRepository.findByYearAndName(2018, "BD-JPA").getYear()==2018 && classRepository.findByYearAndName(2018, "BD-JPA").getName().equals("BD-JPA"));

      
    }

}
