package fr.uga.im2ag.l3.miage.db.model;

import fr.uga.im2ag.l3.miage.db.dao.DaoFactory;
import fr.uga.im2ag.l3.miage.db.dao.api.GraduationClassRepository;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class Base {

    protected EntityManager entityManager;
    protected DaoFactory daoFactory = new DaoFactory();

    @BeforeEach
    public void setup() {
        entityManager = Persistence.createEntityManagerFactory("TEST")
                .createEntityManager();
    }
}
