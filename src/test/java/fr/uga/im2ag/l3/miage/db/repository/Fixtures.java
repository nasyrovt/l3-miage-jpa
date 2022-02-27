package fr.uga.im2ag.l3.miage.db.repository;

import com.github.javafaker.Faker;
import fr.uga.im2ag.l3.miage.db.model.Grade;
import fr.uga.im2ag.l3.miage.db.model.GraduationClass;
import fr.uga.im2ag.l3.miage.db.model.Person;
import fr.uga.im2ag.l3.miage.db.model.Student;
import fr.uga.im2ag.l3.miage.db.model.Subject;
import fr.uga.im2ag.l3.miage.db.model.Teacher;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Fixtures {

    private static final Faker FAKER = Faker.instance(new Random(42));

    public static Subject createSubject() {
        return new Subject()
                .setName(FAKER.funnyName().name())
                .setHours((float) FAKER.number().randomDouble(1, 10, 20))
                .setStart(FAKER.date().past(20, TimeUnit.DAYS))
                .setEnd(FAKER.date().future(20, TimeUnit.DAYS))
                .setPoints((int) FAKER.number().randomNumber(2, true));
    }


    public static Grade createGrade(Subject subject) {
        return new Grade()
                .setSubject(subject)
                .setValue((float) FAKER.number().randomDouble(1, 0, 20))
                .setWeight((float) FAKER.number().randomDouble(1, 0, 10));
    }

    public static GraduationClass createClass() {
        return new GraduationClass()
                .setName(FAKER.zelda().character())
                .setYear(2021);
    }

    public static Student createStudent(GraduationClass graduationClass) {
        var student = new Student().setBelongTo(graduationClass);
        student.setBirth(FAKER.date().past(19 * 365, TimeUnit.DAYS))
                .setFirstName(FAKER.name().firstName())
                .setLastName(FAKER.name().lastName())
                .setGender(Person.Gender.values()[FAKER.number().numberBetween(0, 2)]);

        graduationClass.addStudent(student);

        return student;
    }

    public static Teacher createTeacher(Subject teaching, GraduationClass heading, Student... favs) {
        final var teacher = new Teacher()
                .setTeaching(teaching)
                .setHeading(heading);
        if (favs != null)
            teacher.setFavorites(Arrays.asList(favs));

        teacher.setBirth(FAKER.date().past(60 * 365, 30 * 365, TimeUnit.DAYS))
                .setFirstName(FAKER.name().firstName())
                .setLastName(FAKER.name().lastName())
                .setGender(Person.Gender.values()[FAKER.number().numberBetween(0, 2)]);

        return teacher;

    }

}
