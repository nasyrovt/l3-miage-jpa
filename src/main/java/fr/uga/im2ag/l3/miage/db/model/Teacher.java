package fr.uga.im2ag.l3.miage.db.model;

import java.util.Objects;

public class Teacher extends Person{

    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public Teacher setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getSubject(), teacher.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSubject());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject=" + subject +
                '}';
    }
}
