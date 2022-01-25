package fr.uga.im2ag.l3.miage.db.repository.api;

import fr.uga.im2ag.l3.miage.db.model.Teacher;

public interface TeacherRepository extends Repository<Teacher, Long> {

    /**
     * Fetch the teacher in charge (heading) of a given graduation class by year and name
     * @param year year of the graduation class
     * @param name name of the graduation class
     * @return a teacher matching the class or null
     */
    Teacher findHeadingGraduationClassByYearAndName(Integer year, String name);

}
