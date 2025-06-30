package co.com.walmart.stefanini.prueba.PruebaWalmart.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.walmart.stefanini.prueba.PruebaWalmart.entity.Person;
import co.com.walmart.stefanini.prueba.PruebaWalmart.repository.PersonRepository;
import co.com.walmart.stefanini.prueba.PruebaWalmart.service.PersonService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public Person update(Long id, Person person) {
        Person existing = repository.findById(id).orElseThrow();
        existing.setNombre(person.getNombre());
        existing.setApellido(person.getApellido());
        existing.setFechaNacimiento(person.getFechaNacimiento());
        existing.setPuesto(person.getPuesto());
        existing.setSueldo(person.getSueldo());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Person getById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}