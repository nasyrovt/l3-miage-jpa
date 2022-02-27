package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.repository.api.StudentRepository;

import static org.assertj.core.api.Assertions.assertThat;

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
        final var student = Fixtures.createStudent(null);
        
        entityManager.getTransaction().begin();
        studentRepository.save(student);
        entityManager.getTransaction().commit();
        entityManager.detach(student);
        
        var pStudent = studentRepository.findById(student.getId());
        assertThat(pStudent).isNotNull().isNotSameAs(student);
        assertThat(pStudent.getFirstName()).isEqualTo(student.getFirstName());
        assertThat(pStudent.getLastName()).isEqualTo(student.getLastName());
        assertThat(pStudent.getGender()).isEqualTo(student.getGender());
        assertThat(pStudent.getBirth()).isEqualTo(student.getBirth());


    }

    @Test
    void shouldFindStudentHavingGradeAverageAbove() {
        // TODO
    	studentRepository.findStudentHavingGradeAverageAbove(10);
    }

}
