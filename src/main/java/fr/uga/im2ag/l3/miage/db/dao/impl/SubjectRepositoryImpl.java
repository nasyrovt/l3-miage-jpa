package fr.uga.im2ag.l3.miage.db.dao.impl;

import fr.uga.im2ag.l3.miage.db.dao.api.SubjectRepository;
import fr.uga.im2ag.l3.miage.db.model.Subject;
import fr.uga.im2ag.l3.miage.db.model.Teacher;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

public class SubjectRepositoryImpl extends BaseRepositoryImpl implements SubjectRepository {


    public SubjectRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Subject entity) {
        // TODO
    }

    @Override
    public void delete(Subject entity) {
        // TODO
    }

    @Override
    public Subject findById(Class<Subject> entityClass, Long id) {
        // TODO
        return null;
    }

    @Override
    public List<Subject> getAll(Class<Subject> entityClass) {
        // TODO
        return null;
    }

    @Override
    public Collection<Teacher> findTeachers(Long id) {
        // TODO
        return null;
    }
}
