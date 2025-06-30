package co.com.walmart.stefanini.prueba.PruebaWalmart.controller;

import co.com.walmart.stefanini.prueba.PruebaWalmart.dto.ResponseDTO;
import co.com.walmart.stefanini.prueba.PruebaWalmart.entity.Person;
import co.com.walmart.stefanini.prueba.PruebaWalmart.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping
    public ResponseDTO<List<Person>> getAll() {
        return new ResponseDTO<>(true, "Listado exitoso", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseDTO<Person> getById(@PathVariable Long id) {
        return new ResponseDTO<>(true, "Persona encontrada", service.getById(id));
    }

    @PostMapping
    public ResponseDTO<Person> save(@RequestBody Person person) {
        return new ResponseDTO<>(true, "Persona guardada", service.save(person));
    }

    @PutMapping("/{id}")
    public ResponseDTO<Person> update(@PathVariable Long id, @RequestBody Person person) {
        return new ResponseDTO<>(true, "Persona actualizada", service.update(id, person));
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<String> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseDTO<>(true, "Persona eliminada", null);
    }
}