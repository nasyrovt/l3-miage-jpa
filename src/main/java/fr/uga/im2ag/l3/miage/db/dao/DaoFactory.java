package fr.uga.im2ag.l3.miage.db.dao;

import fr.uga.im2ag.l3.miage.db.dao.api.GradeRepository;
import fr.uga.im2ag.l3.miage.db.dao.api.GraduationClassRepository;
import fr.uga.im2ag.l3.miage.db.dao.api.StudentRepository;
import fr.uga.im2ag.l3.miage.db.dao.api.SubjectRepository;
import fr.uga.im2ag.l3.miage.db.dao.api.TeacherRepository;
import fr.uga.im2ag.l3.miage.db.dao.impl.GradeRepositoryImpl;
import fr.uga.im2ag.l3.miage.db.dao.impl.GraduationClassRepositoryImpl;
import fr.uga.im2ag.l3.miage.db.dao.impl.StudentRepositoryImpl;
import fr.uga.im2ag.l3.miage.db.dao.impl.SubjectRepositoryImpl;
import fr.uga.im2ag.l3.miage.db.dao.impl.TeacherRepositoryImpl;

import javax.persistence.EntityManager;

public class DaoFactory {

    public SubjectRepository newSubjectRepository(EntityManager entityManager) {
        return new SubjectRepositoryImpl(entityManager);
    }

    public StudentRepository newStudentRepository(EntityManager entityManager) {
        return new StudentRepositoryImpl(entityManager);
    }

    public GradeRepository newGradeRepository(EntityManager entityManager) {
        return new GradeRepositoryImpl(entityManager);
    }

    public GraduationClassRepository newGraduationClassRepository(EntityManager entityManager) {
        return new GraduationClassRepositoryImpl(entityManager);
    }

    public TeacherRepository newTeacherRepository(EntityManager entityManager) {
        return new TeacherRepositoryImpl(entityManager);
    }

}
