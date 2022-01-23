package fr.uga.im2ag.l3.miage.db.dao.impl;

import fr.uga.im2ag.l3.miage.db.dao.api.GraduationClassRepository;
import fr.uga.im2ag.l3.miage.db.model.GraduationClass;

import javax.persistence.EntityManager;
import java.util.List;

public class GraduationClassRepositoryImpl extends BaseRepositoryImpl implements GraduationClassRepository {

    public GraduationClassRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public GraduationClass findByYearAndName(Integer year, String name) {
        // TODO
        return null;
    }

    @Override
    public void save(GraduationClass entity) {
        // TODO

    }

    @Override
    public void delete(GraduationClass entity) {
        // TODO

    }

    @Override
    public GraduationClass findById(Class<GraduationClass> entityClass, Long id) {
        // TODO
        return null;
    }

    @Override
    public List<GraduationClass> getAll(Class<GraduationClass> entityClass) {
        // TODO
        return null;
    }
}
