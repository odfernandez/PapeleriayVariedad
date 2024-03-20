package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id //Definimos este campo como Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Le indicamos que este campo es auto incremental
    private int id;

    @Column(name = "id_rol")
    @NotBlank(message = "Please, add IdRol")
    @Length(min = 2, max = 3) //Con esta anotación le indicamos la longitud que tendrá este campo en la tabla
    private String idRol;

    @Column(name = "description", length = 25) //Forma implícita de definir la longitud del campo dentro de la anotación @Column
    @NotBlank(message = "Please, add rol name")
    private String description;

}
