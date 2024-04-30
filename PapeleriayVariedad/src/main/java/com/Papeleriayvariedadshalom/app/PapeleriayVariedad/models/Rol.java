package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rol {

    @Id //Definimos este campo como Primary Key
    @SequenceGenerator(
            name = "rol_sequence",
            sequenceName = "rol_sequence",
            allocationSize = 1
    )
    @GeneratedValue( //Le indicamos que este campo es auto incremental usando el generador de secuencia que creamos
            generator = "rol_sequence",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id_rol")
    private long idRol;

    @Column(name = "description", length = 25) //Forma implícita de definir la longitud del campo dentro de la anotación @Column
    @NotBlank(message = "Please, add rol name")
    private String description;

}
