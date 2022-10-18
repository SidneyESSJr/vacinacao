package br.com.vacinacao.backend.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.vacinacao.backend.domains.Person;
import br.com.vacinacao.backend.services.PersonService;

@RestController
@RequestMapping(path = "/person")
public class PersonResource {

    @Autowired
    PersonService service;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Person person) {
        Person personSaved = service.save(person);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(personSaved.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Person> findById(@PathVariable Integer id) {
        Person person = service.findById(id);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Person person) {
        person.setId(id);
        service.update(person);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
