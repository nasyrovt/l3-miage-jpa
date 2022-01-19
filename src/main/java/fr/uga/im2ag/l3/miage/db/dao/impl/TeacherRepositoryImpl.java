package fr.uga.im2ag.l3.miage.db.dao.impl;

import fr.uga.im2ag.l3.miage.db.dao.api.TeacherRepository;
import fr.uga.im2ag.l3.miage.db.model.Teacher;

import javax.persistence.EntityManager;
import java.util.List;

public class TeacherRepositoryImpl extends BaseRepositoryImpl implements TeacherRepository {

    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public TeacherRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public Teacher findHeadingGraduationClassByYearAndName(Integer year, String name) {
        return null;
    }

    @Override
    public void save(Teacher entity) {

    }

    @Override
    public void delete(Teacher entity) {

    }

    @Override
    public Teacher findById(Class<Teacher> entityClass, Long id) {
        return null;
    }

    @Override
    public List<Teacher> getAll(Class<Teacher> entityClass) {
        return null;
    }
}
