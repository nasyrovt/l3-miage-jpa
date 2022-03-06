package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.Subject;
import fr.uga.im2ag.l3.miage.db.model.Teacher;
import fr.uga.im2ag.l3.miage.db.repository.api.SubjectRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;

class SubjectTest extends Base {

    SubjectRepository subjectRepository;

    @BeforeEach
    void before() {
        subjectRepository = daoFactory.newSubjectRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveSubject() {

        final var Subject = Fixtures.createSubject();

        entityManager.getTransaction().begin();

        subjectRepository.save(Subject);

        entityManager.getTransaction().commit();

        entityManager.detach(Subject);

        var SubjectCheck = subjectRepository.findById(Subject.getId());
        assertThat(SubjectCheck).isNotNull().isNotSameAs(Subject);
        assertThat(SubjectCheck.getName()).isEqualTo(Subject.getName());

    }

    @Test
    void shouldFindTeachersForSubject() {

        //First Subject creation
        Subject Subject = Fixtures.createSubject();
        Subject.setName("Gestion");

        //Second Subject creation
    	Subject SubjectCheck = Fixtures.createSubject();
    	SubjectCheck.setName("Comptabilite");

        //First teacher creation
    	Teacher Teacher = Fixtures.createTeacher(Subject, null, null);
        Teacher.setFirstName("Ava");

        //Second teacher creation
        Teacher OtherTeacher = Fixtures.createTeacher(Subject, null, null);
    	OtherTeacher.setFirstName("Lana");

        //Third teacher creation
        Teacher OneAnotherTeacher = Fixtures.createTeacher(SubjectCheck, null, null);
    	OneAnotherTeacher.setFirstName("Luna");

        //Transaction begins here
    	entityManager.getTransaction().begin();

        //Persistance for Subjects
        entityManager.persist(Subject);
    	entityManager.persist(SubjectCheck);

        //Persistance for Teachers
        entityManager.persist(Teacher);
    	entityManager.persist(OtherTeacher);
    	entityManager.persist(OneAnotherTeacher);

        //Commit
        entityManager.getTransaction().commit();

        //Detach for Subjects
        entityManager.detach(SubjectCheck);
        entityManager.detach(Subject);

        //Detach for Teachers
        entityManager.detach(Teacher);
        entityManager.detach(OtherTeacher);
        entityManager.detach(OneAnotherTeacher);

        //First ResultList for persistance verification
        ArrayList<Teacher> TeachersListResult =  new ArrayList<Teacher>(subjectRepository.findTeachers(Subject.getId()) );
    	assertThat(TeachersListResult.get(0).getFirstName().equals("Ava"));
    	assertThat(TeachersListResult.get(1).getFirstName().equals("Lana"));
    	assertThat(TeachersListResult.size()==2);

        //Second ResultList for persistance verification
    	ArrayList<Teacher> OtherTeachersListResult = new ArrayList<Teacher>( subjectRepository.findTeachers(SubjectCheck.getId()) );
    	assertThat(OtherTeachersListResult.get(0).getFirstName().equals("Luna"));
    	assertThat(OtherTeachersListResult.size()==1);
    	
    }

}
