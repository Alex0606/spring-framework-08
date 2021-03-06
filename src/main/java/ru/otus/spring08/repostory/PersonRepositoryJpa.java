package ru.otus.spring08.repostory;

import org.springframework.stereotype.Repository;
import ru.otus.spring08.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class PersonRepositoryJpa implements PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Person getById(int id) {
        return em.find(Person.class, id);
    }
}
