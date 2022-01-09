package fr.uga.im2ag.l3.miage.db.model;

import fr.uga.im2ag.l3.miage.db.dao.api.GradeRepository;
import fr.uga.im2ag.l3.miage.db.dao.api.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubjectTest extends Base{

    private SubjectRepository subjectRepository;

    @BeforeEach
    public void setup() {
        subjectRepository = daoFactory.newSubjectRepository(entityManager);
    }

    @Test
    void shouldSaveSubject() throws Exception {

        final var subject = Fixtures.createSubject();

        entityManager.getTransaction().begin();
        subjectRepository.save(subject);
        entityManager.getTransaction().commit();

        Subject pSubject = subjectRepository.findById(Subject.class, subject.getId());
        assertThat(pSubject).isNotNull();
        assertThat(pSubject).isNotSameAs(subject);
        assertThat(pSubject.getName()).isEqualTo(subject.getName());

    }

    @Test
    void shouldUpdateSubject() throws Exception {

    }

    @Test
    void shouldDeleteSubject() throws Exception {

    }

    @Test
    void shouldFindSubjectsTaughtByManyTeacher() throws Exception {

    }

}
