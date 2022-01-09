package fr.uga.im2ag.l3.miage.db.dao.api;

import fr.uga.im2ag.l3.miage.db.model.Student;

import java.util.List;

public interface StudentRepository extends Repository<Student, Long> {

    List<Student> findStudentHavingGradeAverageAbove(float minAverage);

}
