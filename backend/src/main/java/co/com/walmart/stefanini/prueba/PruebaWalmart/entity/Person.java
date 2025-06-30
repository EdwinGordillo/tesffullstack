package co.com.walmart.stefanini.prueba.PruebaWalmart.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(name = "fecha_nacimiento")  // 👈 Esto enlaza con la columna real en MySQL
    private LocalDate fechaNacimiento;

    private String puesto;

    private BigDecimal sueldo;
}