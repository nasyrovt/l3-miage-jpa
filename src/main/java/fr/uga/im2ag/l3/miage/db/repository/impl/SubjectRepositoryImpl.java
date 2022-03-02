package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.repository.api.SubjectRepository;
import fr.uga.im2ag.l3.miage.db.model.Grade;
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
        entityManager.persist(entity);
    }

    @Override
    public void delete(Subject entity) {
        entityManager.remove(entity);
    }

    @Override
    public Subject findById(Long id) {
        // TODO
    	return entityManager.find(Subject.class, id);
    	
    }

    @Override
    public List<Subject> getAll() {
        String jql = "select s from Subject s ";
        return entityManager.createQuery(jql, Subject.class).getResultList();
    }

    @Override
    public Collection<Teacher> findTeachers(Long id) {
        // TODO
    	 String jql = "select t from Teacher t where t.id="+id;
    	// Collection<Teacher> coll = new Collection<Teacher>(entityManager.createQuery(jql, Subject.class).getResultList());
        return (Collection<Teacher> )entityManager.createQuery(jql, Teacher.class).getResultList() ;
    }
}
