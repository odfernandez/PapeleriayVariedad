package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "Companies",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "nit.unique",
                        columnNames = {"nit"}
                )
        }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nit")
    @NotBlank(message = "Please, add nit of the company")
    @Pattern(message = "The NIT must be in the correct format (XXXXXXXXX-X)",
            regexp = "\\d{9}-\\d{1}")
    private String nit;

    @Column(name = "nameCompany")
    @NotBlank(message = "Please, add name of the company")
    private String nameCompany;
}
