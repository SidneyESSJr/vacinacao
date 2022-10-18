package br.com.vacinacao.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vacinacao.backend.domains.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
