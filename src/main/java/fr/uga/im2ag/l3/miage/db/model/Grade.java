package fr.uga.im2ag.l3.miage.db.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name="Grade")
// TODO ajouter une named query pour une des requêtes à faire dans le repository
public class Grade {
	@Id
    @GeneratedValue()
	@Column(name = "id") 
	
    private Long id;
    @ManyToOne
    private Subject subject;
    
    @Column(name = "gradevalue")
    private Float value;
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

    public Float getValue() {
        return value;
    }

    public Grade setValue(Float value) {
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
