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
    public void insert(Person p) {
        em.persist(p);
    }

    @Override
    public Person getById(int id) {
        return em.find(Person.class, id);
    }

    @Override
    public Person getFirst() {
        TypedQuery<Person> query = em.createQuery(
            "select e from Employee e where e.id = 1",
            Person.class);
        return query.getSingleResult();
    }

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> query = em.createQuery(
                "select e from Employee e",
                Person.class);
        return query.getResultList();
    }

    @Override
    public Person getByName(String name) {
        TypedQuery<Person> query = em.createQuery(
                "select e from Employee e where e.name = :name",
                Person.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}