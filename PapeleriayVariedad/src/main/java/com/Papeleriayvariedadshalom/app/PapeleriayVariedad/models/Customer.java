package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Con esta anotación le indicamos a Spring que esta clase es una entidad por medio del manejo de persistencia con JPA
@Table(name = "Customers") //Definimos el nombre de la tabla en la base de datos por medio de JPA
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id //Indicamos que este campo será la llave principal de la tabla
    @Column(name = "idCustomer") //Indicamos el nombre de la columna dentro de la tabla
    @NotBlank(message = "Please, add the Id of Customer") //Indicamos que este campo no puede recibir datos nulos o vacíos
    private String idCustomer; // Declaración de la variable o atributo

    @NotBlank(message = "Please, add the Name of Customer")
    private String firstName;

    private String secondName;

    @NotBlank(message = "Please, add the Last Name of Customer")
    private String firstLastName;

    private String secondLastName;

    @NotBlank(message = "Please, add the Address of Customer")
    private String address;

    @NotBlank(message = "Please, add the Phone Number of Customer")
    private String phone;

    @NotBlank(message = "Please, add the Email of Customer")
    private String email;
}
