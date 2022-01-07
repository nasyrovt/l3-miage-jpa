package fr.uga.im2ag.l3.miage.db.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {

    private EntityManager entityManager;

    @BeforeEach
    public void setup() {
        entityManager = Persistence.createEntityManagerFactory("TEST")
                .createEntityManager();

    }

    @Test
    void shouldSaveSubject() throws Exception {

    }

}
