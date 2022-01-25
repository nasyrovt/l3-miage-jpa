package fr.uga.im2ag.l3.miage.db.repository.api;

import fr.uga.im2ag.l3.miage.db.model.GraduationClass;

public interface GraduationClassRepository extends Repository<GraduationClass, Long> {

    /**
     * Find graduation class for a given year and name.
     * @param year the year
     * @param name the name as in {@link GraduationClass#getName()}
     * @return a graduation class or null
     */
    GraduationClass findByYearAndName(Integer year, String name);

}
