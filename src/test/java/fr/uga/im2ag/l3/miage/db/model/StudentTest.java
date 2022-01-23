package fr.uga.im2ag.l3.miage.db.model;

import fr.uga.im2ag.l3.miage.db.dao.api.StudentRepository;
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
        // TODO
    }

    @Test
    void shouldUpdateStudent() {
        // TODO
    }

    @Test
    void shouldDeleteStudent() {
        // TODO
    }

    @Test
    void shouldFindStudentHavingGradeAverageAbove() {
        // TODO
    }

}
