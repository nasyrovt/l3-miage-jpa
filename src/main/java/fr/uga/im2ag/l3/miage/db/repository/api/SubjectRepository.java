package fr.uga.im2ag.l3.miage.db.repository.api;

import fr.uga.im2ag.l3.miage.db.model.Subject;
import fr.uga.im2ag.l3.miage.db.model.Teacher;

import java.util.Collection;

public interface SubjectRepository extends Repository<Subject, Long> {

    /**
     * Retrieve teachers teaching a given subject (by id)
     * @param id the id of the subject
     * @return a collection (possibly empty) of teachers teaching that subject
     */
    Collection<Teacher> findTeachers(Long id);

}
