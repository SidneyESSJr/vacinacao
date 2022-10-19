package br.com.vacinacao.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vacinacao.backend.domains.Person;
import br.com.vacinacao.backend.repositories.PersonRepository;
import br.com.vacinacao.backend.services.exceptions.DataIntegrityViolationException;
import br.com.vacinacao.backend.services.exceptions.ObjectNotFoudException;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person save(Person person) {
        person.setId(null);
        return repository.save(person);
    }

    public Person findById(Integer id) {
        Optional<Person> person = repository.findById(id);
        return person.orElseThrow(
                () -> new ObjectNotFoudException("Object " + Person.class.getName() + " id " + id + " not found"));
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person update(Person person) {
        Person updatedPerson = findById(person.getId());
        BeanUtils.copyProperties(person, updatedPerson);
        return repository.save(updatedPerson);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new DataIntegrityViolationException(
                    "This person cannot be deleted because they are linked to other entities");
        }
    }

}
