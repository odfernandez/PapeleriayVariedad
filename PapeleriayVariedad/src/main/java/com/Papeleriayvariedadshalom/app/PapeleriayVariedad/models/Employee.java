package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee{
    @Id
    @Column(name = "idEmployee")
    @NotBlank(message = "Please, add the ID of Employee")
    private String idEmployee;

    @NotBlank(message = "Please, add the Name of Employee")
    private String firstName;

    private String secondName;

    @NotBlank(message = "Please, add the Last Name of Employee")
    private String firstLastName;

    private String secondLastName;

    @NotBlank(message = "Please, add the Address of Employee")
    private String address;

    @NotBlank(message = "Please, add the Phone Number of Employee")
    private String phone;

    @NotBlank(message = "Please, add the Email of Employee")
    private String email;
    private boolean state;
    //private Rol rol;
}
