package fr.uga.im2ag.l3.miage.db.dao.api;

import fr.uga.im2ag.l3.miage.db.model.GraduationClass;

public interface GraduationClassRepository extends Repository<GraduationClass, Long> {

    GraduationClass findByYearAndName(Integer year, String name);

}
