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
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseDTO<List<Person>> getAll() {
        return new ResponseDTO<>(true, "Listado exitoso", service.getAll());
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseDTO<Person> getById(@PathVariable("id") Long id) {
        return new ResponseDTO<>(true, "Persona encontrada", service.getById(id));
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseDTO<Person> save(@RequestBody Person person) {
        return new ResponseDTO<>(true, "Persona guardada", service.save(person));
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseDTO<Person> update(@PathVariable("id") Long id, @RequestBody Person person) {
        return new ResponseDTO<>(true, "Persona actualizada", service.update(id, person));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseDTO<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseDTO<>(true, "Persona eliminada", null);
    }
}