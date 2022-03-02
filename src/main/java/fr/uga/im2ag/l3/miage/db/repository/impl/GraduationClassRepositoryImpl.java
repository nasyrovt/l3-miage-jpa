package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.repository.api.GraduationClassRepository;
import fr.uga.im2ag.l3.miage.db.model.GraduationClass;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

public class GraduationClassRepositoryImpl extends BaseRepositoryImpl implements GraduationClassRepository {

    public GraduationClassRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public GraduationClass findByYearAndName(Integer year, String name) {
        // TODO
    	
    	
    	TypedQuery<GraduationClass> query = entityManager.createQuery(
    			  "SELECT g FROM GraduationClass AS g WHERE g.name = :name AND g.year = :year" , GraduationClass.class);
    	System.out.print("On est la");		
    	if( query
    			  .setParameter("name", name)
    			  .setParameter("year", year)
    			  .getResultList().size() ==1)
    	{ return (GraduationClass) query ; }
    	
    	else { 
    		return null ;
    	}
    			
    }

    @Override
    public void save(GraduationClass entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(GraduationClass entity) {
        entityManager.remove(entity);
    }

    @Override
    public GraduationClass findById(Long id) {
        // TODO
        return entityManager.find(GraduationClass.class, id);
    }

    @Override
    public List<GraduationClass> getAll() {
        String jql = "select g from GraduationClass g ";
        return entityManager.createQuery(jql,GraduationClass.class).getResultList();
    }
}
