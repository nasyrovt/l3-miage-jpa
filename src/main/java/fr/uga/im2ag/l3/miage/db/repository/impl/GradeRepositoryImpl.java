package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.repository.api.GradeRepository;
import fr.uga.im2ag.l3.miage.db.model.Grade;
import fr.uga.im2ag.l3.miage.db.model.Student;
import fr.uga.im2ag.l3.miage.db.model.Subject;

import javax.persistence.EntityManager;

import java.util.ArrayList;
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
    	String jpql = "select * from Grade where grade="+limit;
    	return  (List<Grade>) entityManager.createQuery(jpql,Grade.class);
       
    }

    @Override
    public List<Grade> findHighestGradesBySubject(int limit, Subject subject) {
    	String jpql = "select * from Grade where grade="+limit+"and id="+subject.getId();
    	return  (List<Grade>) entityManager.createQuery(jpql,Grade.class);
       
    }

    @Override
    public void save(Grade entity) {
       entityManager.persist(entity);
    }

    @Override
    public void delete(Grade entity) {
        entityManager.remove(entity);
    }

    @Override
    public Grade findById(Long id) {
        return entityManager.find(Grade.class, id);
    }

    @Override
    public List<Grade> getAll() {
        // TODO
        String jpql = "select * from Grades";
    	return  (List<Grade>) entityManager.createQuery(jpql,Grade.class);
    }
}
