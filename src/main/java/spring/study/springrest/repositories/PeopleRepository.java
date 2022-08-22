package spring.study.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.study.springrest.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}