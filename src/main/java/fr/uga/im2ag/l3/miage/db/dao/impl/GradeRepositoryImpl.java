package fr.uga.im2ag.l3.miage.db.dao.impl;

import fr.uga.im2ag.l3.miage.db.dao.api.GradeRepository;
import fr.uga.im2ag.l3.miage.db.model.Grade;
import fr.uga.im2ag.l3.miage.db.model.Subject;

import javax.persistence.EntityManager;
import java.util.List;

public class GradeRepositoryImpl extends BaseRepositoryImpl implements GradeRepository {

    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public GradeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Grade> findHighestGrades(int limit) {
        return null;
    }

    @Override
    public List<Grade> findHighestGradesBySubject(int limit, Subject subject) {
        return null;
    }

    @Override
    public void save(Grade entity) {

    }

    @Override
    public void delete(Grade entity) {

    }

    @Override
    public Grade findById(Class<Grade> entityClass, Long id) {
        return null;
    }

    @Override
    public List<Grade> getAll(Class<Grade> entityClass) {
        return null;
    }
}
