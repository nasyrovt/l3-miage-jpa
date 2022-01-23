package fr.uga.im2ag.l3.miage.db.model;

import java.util.List;

// TODO ajouter une named query pour une des requêtes à faire dans le repository
public class Teacher extends Person {

    private Subject teaching;
    private List<Student> favorites;
    private GraduationClass heading;

    public Subject getTeaching() {
        return teaching;
    }

    public Teacher setTeaching(Subject teaching) {
        this.teaching = teaching;
        return this;
    }

    public List<Student> getFavorites() {
        return favorites;
    }

    public Teacher setFavorites(List<Student> favorites) {
        this.favorites = favorites;
        return this;
    }

    public GraduationClass getHeading() {
        return heading;
    }

    public Teacher setHeading(GraduationClass heading) {
        this.heading = heading;
        return this;
    }

}
