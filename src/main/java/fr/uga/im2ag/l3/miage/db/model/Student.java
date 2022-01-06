package fr.uga.im2ag.l3.miage.db.model;

import java.util.Objects;

public class Student extends Person{

    private Class assignedClass;

    public Class getAssignedClass() {
        return assignedClass;
    }

    public Student setAssignedClass(Class assignedClass) {
        this.assignedClass = assignedClass;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(assignedClass, student.assignedClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), assignedClass);
    }
}
