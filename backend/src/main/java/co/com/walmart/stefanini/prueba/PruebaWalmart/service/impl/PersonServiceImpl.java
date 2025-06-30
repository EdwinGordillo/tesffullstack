package co.com.walmart.stefanini.prueba.PruebaWalmart.service.impl;

import co.com.walmart.stefanini.prueba.PruebaWalmart.entity.Person;
import co.com.walmart.stefanini.prueba.PruebaWalmart.repository.PersonRepository;
import co.com.walmart.stefanini.prueba.PruebaWalmart.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
        Person existing = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Persona con ID " + id + " no encontrada"
            ));

        existing.setNombre(person.getNombre());
        existing.setApellido(person.getApellido());
        existing.setFechaNacimiento(person.getFechaNacimiento());
        existing.setPuesto(person.getPuesto());
        existing.setSueldo(person.getSueldo());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se puede eliminar. Persona con ID " + id + " no existe"
            );
        }
        repository.deleteById(id);
    }

    @Override
    public Person getById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Persona con ID " + id + " no encontrada"
            ));
    }
}