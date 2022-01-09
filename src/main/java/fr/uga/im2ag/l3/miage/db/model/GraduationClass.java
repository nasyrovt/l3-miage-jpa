package fr.uga.im2ag.l3.miage.db.model;

import java.util.ArrayList;
import java.util.List;

public class GraduationClass {

    private Long id;
    private String name;
    private Integer year;
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GraduationClass setId(Long id) {
        this.id = id;
        return this;
    }

    public GraduationClass setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public GraduationClass setYear(Integer year) {
        this.year = year;
        return this;
    }

    public List<Student> getStudents() {
        return students;
    }

    public GraduationClass setStudents(List<Student> students) {
        this.students = students;
        return this;
    }

    public void addStudent(Student student) {
        if(students == null){
            students = new ArrayList<>();
        }
        students.add(student);
    }
}
