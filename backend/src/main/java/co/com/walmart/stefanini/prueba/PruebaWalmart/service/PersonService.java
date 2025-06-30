package co.com.walmart.stefanini.prueba.PruebaWalmart.service;

import java.util.List;

import co.com.walmart.stefanini.prueba.PruebaWalmart.entity.Person;

public interface PersonService {

    List<Person> getAll();

    Person save(Person person);

    Person update(Long id, Person person);

    void delete(Long id);
    
    Person getById(Long id);
}