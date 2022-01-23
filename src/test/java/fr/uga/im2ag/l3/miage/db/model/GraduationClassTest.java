package fr.uga.im2ag.l3.miage.db.model;

import fr.uga.im2ag.l3.miage.db.dao.api.GraduationClassRepository;
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
    }

    @Test
    void shouldUpdateClass() {
        // TODO
    }

    @Test
    void shouldDeleteClass() {
        // TODO
    }

    @Test
    void shouldFindByYearAndName() {
        // TODO
    }

}
