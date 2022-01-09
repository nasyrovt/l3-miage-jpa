package fr.uga.im2ag.l3.miage.db.model;

import com.github.javafaker.Faker;
import fr.uga.im2ag.l3.miage.db.model.Grade;
import fr.uga.im2ag.l3.miage.db.model.GraduationClass;
import fr.uga.im2ag.l3.miage.db.model.Person;
import fr.uga.im2ag.l3.miage.db.model.Student;
import fr.uga.im2ag.l3.miage.db.model.Subject;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Fixtures {

    public static Subject createSubject() {
        return new Subject()
                .setName(Faker.instance().funnyName().name())
                .setHours((float) Faker.instance().number().randomDouble(1, 10, 20))
                .setStart(Faker.instance().date().past(20, TimeUnit.DAYS))
                .setEnd(Faker.instance().date().future(20, TimeUnit.DAYS))
                .setPoints((int) Faker.instance().number().randomNumber(2, true));
    }


    public static Grade createGrade(Subject subject) {
        return new Grade()
                .setSubject(subject)
                .setValue((float) Faker.instance().number().randomDouble(1, 0, 20))
                .setWeight((float) Faker.instance().number().randomDouble(1, 0, 10));
    }

    public static GraduationClass createClass() {
        return new GraduationClass()
                .setName(Faker.instance().zelda().character())
                .setYear(2021);
    }

    public static Student createStudent(GraduationClass graduationClass) {
        var student = new Student().setBelongTo(graduationClass);
        student.setBirth(Faker.instance().date().past(19 * 365, 21 * 365, TimeUnit.DAYS))
                .setFirstName(Faker.instance().name().firstName())
                .setLastName(Faker.instance().name().lastName())
                .setGender(Person.Gender.values()[Faker.instance().number().numberBetween(0, 2)]);

        graduationClass.addStudent(student);

        return student;
    }

    public static Teacher createTeacher(Subject teaching, GraduationClass heading, Student... favs) {
        final var teacher = new Teacher()
                .setTeaching(teaching)
                .setHeading(heading)
                .setFavorites(Arrays.asList(favs));

        teacher.setBirth(Faker.instance().date().past(30 * 365, 60 * 365, TimeUnit.DAYS))
                .setFirstName(Faker.instance().name().firstName())
                .setLastName(Faker.instance().name().lastName())
                .setGender(Person.Gender.values()[Faker.instance().number().numberBetween(0, 2)]);

        return teacher;

    }

}
