package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Con esta anotación le indicamos a Spring que esta clase es una entidad por medio del manejo de persistencia con JPA
@Table(
        name = "Customers", //Definimos el nombre de la tabla en la base de datos por medio de JPA
        uniqueConstraints = {
                @UniqueConstraint( //Definimos el campo id_customer como único para cada registro y es Primary Key.
                name = "idCustomer.unique",
                columnNames = {"id_customer"}),
                @UniqueConstraint( //Definimos el campo email como único para cada registro.
                        name = "email.unique",
                        columnNames = {"email_address"}
                )
        }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id //Indicamos que este campo será la llave principal de la tabla
    @Column(
            name = "id_customer",
            nullable = false
    ) //Indicamos el nombre de la columna dentro de la tabla
    @Size(
            min = 8,
            max = 10
    )
    @NotBlank(message = "Please, add the Id of Customer") //Indicamos que este campo no puede recibir datos nulos o vacíos
    @Pattern(
            message = "Only numbers are valid",
            regexp = "^[0-9]*$"
    )
    private String idCustomer; // Declaración de la variable o atributo

    @NotBlank(message = "Please, add the Name of Customer")
    @Pattern(
            message = "Only letters are valid",
            regexp = "^[a-zA-Z]*$"
    )
    private String firstName;

    @Pattern(
            message = "Only letters are valid",
            regexp = "^[a-zA-Z]*$"
    )
    private String secondName;

    @NotBlank(message = "Please, add the Last Name of Customer")
    @Pattern(
            message = "Only letters are valid",
            regexp = "^[a-zA-Z]*$"
    )
    private String firstLastName;

    @Pattern(
            message = "Only letters are valid",
            regexp = "^[a-zA-Z]*$"
    )
    private String secondLastName;

    @NotBlank(message = "Please, add the Address of Customer")
    private String address;

    @NotBlank(message = "Please, add the Phone Number of Customer")
    @Pattern(
            message = "Only numbers are valid",
            regexp = "^[0-9]*$"
    )
    @Size(
            min = 7,
            max = 10
    )
    private String phone;

    @Column(
            name = "email_address",
            nullable = false
    )
    @Email(
            message = "Email is not valid",
            regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    )    //^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$ -- [a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$
    @NotBlank(message = "Please, add the Email of Customer")
    private String email;
}
