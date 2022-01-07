package fr.uga.im2ag.l3.miage.db.model;

public class Grade {

    private Long id;
    private Subject subject;
    private Integer value;
    private Float weight;

    public Long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public Grade setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public Grade setValue(Integer value) {
        this.value = value;
        return this;
    }

    public Float getWeight() {
        return weight;
    }

    public Grade setWeight(Float weight) {
        this.weight = weight;
        return this;
    }
}
