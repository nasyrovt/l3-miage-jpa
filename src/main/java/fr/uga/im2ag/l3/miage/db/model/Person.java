package fr.uga.im2ag.l3.miage.db.model;
import javax.persistence.InheritanceType;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public abstract class Person {
	
	@Id
	@GeneratedValue()
	@Column(name = "id")
    private Long id;
    private Gender gender;

    @Column(name = "student_name")
    private String firstName;

    @Column(name = "student_lastN")
    private String lastName;
    private Date birth;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Person setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getBirth() {
        return birth;
    }

    public Person setBirth(Date birth) {
        this.birth = birth;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public enum Gender {
        FEMALE, MALE, FLUID
    }

}
