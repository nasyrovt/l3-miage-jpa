package fr.uga.im2ag.l3.miage.db.dao.api;

import fr.uga.im2ag.l3.miage.db.model.Subject;

import java.util.Collection;

public interface SubjectRepository extends Repository<Subject, Long> {

    /**
     * Find all subjects teaching more than one subject
     * @return a collection of subject
     */
    Collection<Subject> findSubjectsTaughtByManyTeacher();

}
