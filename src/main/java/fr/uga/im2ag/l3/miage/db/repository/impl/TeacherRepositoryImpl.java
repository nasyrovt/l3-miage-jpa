package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.repository.api.TeacherRepository;
import fr.uga.im2ag.l3.miage.db.model.GraduationClass;
import fr.uga.im2ag.l3.miage.db.model.Student;
import fr.uga.im2ag.l3.miage.db.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
    	TypedQuery<Teacher> query =  (TypedQuery<Teacher>) entityManager.createQuery("select t from Teacher t JOIN t.heading h where h.year=:year AND h.name=:name");
        return query
  			  .setParameter("name", name)
  			  .setParameter("year", year).getSingleResult();
    }

    @Override
    public void save(Teacher entity) {
        entityManager.persist(entity);

    }

    @Override
    public void delete(Teacher entity) {
        entityManager.remove(entity);

    }

    @Override
    public Teacher findById(Long id) {
        // TODO
         return entityManager.find(Teacher.class, id);
    }

    @Override
    public List<Teacher> getAll() {
        // TODO
    	String jql = "select t FROM Teacher t";
        return entityManager.createQuery(jql, Teacher.class).getResultList();
    }
}
