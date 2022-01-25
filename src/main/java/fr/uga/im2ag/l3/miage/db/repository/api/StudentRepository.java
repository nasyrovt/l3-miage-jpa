package fr.uga.im2ag.l3.miage.db.repository.api;

import fr.uga.im2ag.l3.miage.db.model.Student;

import java.util.List;

public interface StudentRepository extends Repository<Student, Long> {

    /**
     * Returns all students have an average above the minimum provided
     * @param minAverage the low threshold grade average
     * @return student above average grade
     */
    List<Student> findStudentHavingGradeAverageAbove(float minAverage);

}
