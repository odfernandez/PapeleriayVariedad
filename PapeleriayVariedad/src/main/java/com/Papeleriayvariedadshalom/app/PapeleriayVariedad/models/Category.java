package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Table(name = "Categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @Column(name = "id_category")
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "category_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private long idCategory;

    @NotBlank(message = "Please, add the description of the category")
    private String description;

    private boolean state;

    /*@OneToMany(mappedBy = "category")
    private List<Product> product;*/
}
