package co.com.walmart.stefanini.prueba.PruebaWalmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.walmart.stefanini.prueba.PruebaWalmart.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}
