package fr.uga.im2ag.l3.miage.db.repository.api;

import fr.uga.im2ag.l3.miage.db.model.Grade;
import fr.uga.im2ag.l3.miage.db.model.Subject;

import java.util.List;

public interface GradeRepository extends Repository<Grade, Long> {

    /**
     * Get the highest grades amongst all subjects
     * @param limit number of grades to return
     * @return a list of the nth best grades
     */
    List<Grade> findHighestGrades(int limit);



    /**
     * Get the highest grades for a given subject
     * @param limit number of grades to return
     * @return a list of the nth best grades for the subject
     */
    List<Grade> findHighestGradesBySubject(int limit, Subject subject);

}
