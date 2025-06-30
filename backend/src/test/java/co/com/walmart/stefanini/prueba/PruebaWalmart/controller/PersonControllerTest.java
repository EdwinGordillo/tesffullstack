package co.com.walmart.stefanini.prueba.PruebaWalmart.controller;

import co.com.walmart.stefanini.prueba.PruebaWalmart.entity.Person;
import co.com.walmart.stefanini.prueba.PruebaWalmart.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;

@WebMvcTest(PersonController.class)
@Import(PersonControllerTest.MockedServiceConfig.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonService personService;

    @Autowired
    private ObjectMapper objectMapper;

    @TestConfiguration
    static class MockedServiceConfig {
        @Bean
        public PersonService personService() {
            return Mockito.mock(PersonService.class);
        }
    }

    private Person samplePerson1() {
        Person p = new Person();
        p.setId(1L);
        p.setNombre("Edwin");
        p.setApellido("Gordillo");
        p.setFechaNacimiento(LocalDate.of(2001, 3, 21));
        p.setPuesto("Desarrollador Fullstack");
        p.setSueldo(new BigDecimal("3500.00"));
        return p;
    }

    private Person samplePerson2() {
        Person p = new Person();
        p.setId(2L);
        p.setNombre("Dayana");
        p.setApellido("Guzman");
        p.setFechaNacimiento(LocalDate.of(1995, 7, 10));
        p.setPuesto("QA Analyst");
        p.setSueldo(new BigDecimal("2800.00"));
        return p;
    }

    private Person updatedPerson() {
        Person p = new Person();
        p.setId(1L);
        p.setNombre("Leonardo");
        p.setApellido("Gomez");
        p.setFechaNacimiento(LocalDate.of(1990, 12, 1));
        p.setPuesto("Líder Técnico");
        p.setSueldo(new BigDecimal("5000.00"));
        return p;
    }

    private Person samplePersonSaved() {
        Person p = new Person();
        p.setId(3L);
        p.setNombre("Luis");
        p.setApellido("Orozco");
        p.setFechaNacimiento(LocalDate.of(2001, 6, 11));
        p.setPuesto("Desarrollador Senior");
        p.setSueldo(new BigDecimal("70000.00"));
        return p;
    }

    @Test
    void testGetAll() throws Exception {
        Mockito.when(personService.getAll()).thenReturn(List.of(samplePerson1(), samplePerson2()));

        mockMvc.perform(get("/api/personas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(true))
                .andExpect(jsonPath("$.data[0].nombre").value("Edwin"))
                .andExpect(jsonPath("$.data[0].apellido").value("Gordillo"))
                .andExpect(jsonPath("$.data[0].fechaNacimiento").value("2001-03-21"))
                .andExpect(jsonPath("$.data[0].puesto").value("Desarrollador Fullstack"))
                .andExpect(jsonPath("$.data[0].sueldo").value(3500.00))
                .andExpect(jsonPath("$.data[1].nombre").value("Dayana"))
                .andExpect(jsonPath("$.data[1].apellido").value("Guzman"))
                .andExpect(jsonPath("$.data[1].fechaNacimiento").value("1995-07-10"))
                .andExpect(jsonPath("$.data[1].puesto").value("QA Analyst"))
                .andExpect(jsonPath("$.data[1].sueldo").value(2800.00));
    }

    @Test
    void testGetById() throws Exception {
        Mockito.when(personService.getById(1L)).thenReturn(samplePerson1());

        mockMvc.perform(get("/api/personas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(true))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.nombre").value("Edwin"))
                .andExpect(jsonPath("$.data.apellido").value("Gordillo"))
                .andExpect(jsonPath("$.data.fechaNacimiento").value("2001-03-21"))
                .andExpect(jsonPath("$.data.puesto").value("Desarrollador Fullstack"))
                .andExpect(jsonPath("$.data.sueldo").value(3500.00));
    }

    @Test
    void testCreatePerson() throws Exception {
        // Simula el servicio que guarda y retorna con ID generado
        Mockito.when(personService.save(any(Person.class))).thenReturn(samplePersonSaved());

        mockMvc.perform(post("/api/personas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(samplePersonSaved())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(true))
                .andExpect(jsonPath("$.msg").value("Persona guardada"))
                .andExpect(jsonPath("$.data.id").value(3))
                .andExpect(jsonPath("$.data.nombre").value("Luis"))
                .andExpect(jsonPath("$.data.apellido").value("Orozco"))
                .andExpect(jsonPath("$.data.fechaNacimiento").value("2001-06-11"))
                .andExpect(jsonPath("$.data.puesto").value("Desarrollador Senior"))
                .andExpect(jsonPath("$.data.sueldo").value(70000.00));
    }

    @Test
    void testUpdatePerson() throws Exception {
        Mockito.when(personService.update(Mockito.eq(1L), any(Person.class))).thenReturn(updatedPerson());

        mockMvc.perform(put("/api/personas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedPerson())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(true))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.nombre").value("Leonardo"))
                .andExpect(jsonPath("$.data.apellido").value("Gomez"))
                .andExpect(jsonPath("$.data.fechaNacimiento").value("1990-12-01"))
                .andExpect(jsonPath("$.data.puesto").value("Líder Técnico"))
                .andExpect(jsonPath("$.data.sueldo").value(5000.00));
    }

    @Test
    void testDeletePerson() throws Exception {
        Mockito.doNothing().when(personService).delete(1L);

        mockMvc.perform(delete("/api/personas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(true))
                .andExpect(jsonPath("$.msg").value("Persona eliminada"));
    }
}