package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "Employees",
        uniqueConstraints = {
                @UniqueConstraint( //Definimos el campo id_employee como único para cada registro y es Primary Key.
                        name = "idEmployee.unique",
                        columnNames = {"id_employee"}),
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
public class Employee{
    @Id
    @Column(
            name = "id_employee",
            nullable = false
    )
    @Size(
            min = 8,
            max = 10
    )
    @NotBlank(message = "Please, add the ID of Employee")
    @Pattern(
            message = "Only numbers are valid",
            regexp = "^[0-9]*$"
    )
    private String idEmployee;

    @NotBlank(message = "Please, add the Name of Employee")
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

    @NotBlank(message = "Please, add the Last Name of Employee")
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

    @NotBlank(message = "Please, add the Address of Employee")
    private String address;

    @NotBlank(message = "Please, add the Phone Number of Employee")
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
    )
    @NotBlank(message = "Please, add the Email of Employee")
    private String email;

    private boolean state;

    @ManyToOne()
    @JoinColumn(
            name = "id_rol",
            referencedColumnName = "id_rol"
    )
    private Rol rol;
}
