package co.com.walmart.stefanini.prueba.PruebaWalmart.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.walmart.stefanini.prueba.PruebaWalmart.entity.Person;
import co.com.walmart.stefanini.prueba.PruebaWalmart.service.PersonService;
import co.com.walmart.stefanini.prueba.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/personas")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping
    public ResponseDTO<List<Person>> getAll() {
        return new ResponseDTO<>(true, "Listado completo", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseDTO<Person> getById(@PathVariable Long id) {
        return new ResponseDTO<>(true, "Encontrado", service.getById(id));
    }

    @PostMapping
    public ResponseDTO<Person> save(@RequestBody Person person) {
        return new ResponseDTO<>(true, "Guardado", service.save(person));
    }

    @PutMapping("/{id}")
    public ResponseDTO<Person> update(@PathVariable Long id, @RequestBody Person person) {
        return new ResponseDTO<>(true, "Actualizado", service.update(id, person));
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<String> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseDTO<>(true, "Eliminado", null);
    }
}