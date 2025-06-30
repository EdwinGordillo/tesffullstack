package co.com.walmart.stefanini.prueba.PruebaWalmart.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Long createPerson() throws Exception {
        Map<String, Object> personMap = new HashMap<>();
        personMap.put("nombre", "TestNombre");
        personMap.put("apellido", "TestApellido");
        personMap.put("fechaNacimiento", "1990-01-01");
        personMap.put("puesto", "Desarrollador Java");
        personMap.put("sueldo", 1234.56);

        MvcResult result = mockMvc.perform(post("/api/personas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personMap)))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        JsonNode json = objectMapper.readTree(content);
        return json.get("data").get("id").asLong();
    }

    @Test
    void testCreatePerson() throws Exception {
        createPerson();
    }

    @Test
    void testGetById() throws Exception {
        Long id = createPerson();

        mockMvc.perform(get("/api/personas/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(true))
                .andExpect(jsonPath("$.data.id").value(id));
    }

    @Test
    void testUpdatePerson() throws Exception {
        Long id = createPerson();

        Map<String, Object> updated = new HashMap<>();
        updated.put("nombre", "NombreActualizado");
        updated.put("apellido", "ApellidoNuevo");
        updated.put("fechaNacimiento", "1980-05-10");
        updated.put("puesto", "Tech Lead");
        updated.put("sueldo", 9876.54);

        mockMvc.perform(put("/api/personas/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.nombre").value("NombreActualizado"));
    }

    @Test
    void testDeletePerson() throws Exception {
        Long id = createPerson();

        mockMvc.perform(delete("/api/personas/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(true))
                .andExpect(jsonPath("$.msg").value("Persona eliminada"));
    }

    @Test
    void testGetAll() throws Exception {
        createPerson();

        mockMvc.perform(get("/api/personas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(true))
                .andExpect(jsonPath("$.data").isArray());
    }
}