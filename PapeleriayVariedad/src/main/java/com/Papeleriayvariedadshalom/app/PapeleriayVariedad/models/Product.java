package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


//Estas anotaciones pertenecen a la librería Lombok
@Entity
@Table(name = "Products")
@Data  //Con esta anotación le indicamos que nos cree de forma automática los métodos Getter, Setter, ToString
@AllArgsConstructor //Nos declara el constructor sobrecargado
@NoArgsConstructor  //Nos declara el constructor vacío
@Builder
public class Product {
    //Declaramos las variables o atributos correspondientes a la clase Product
    @Id
    @Column(name = "id_product")
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "product_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private long idProduct;

    @NotBlank(message = "Please, add name of product")
    private String productName;

    @Column(
            name = "price",
            nullable = false
    )
    @Min(
            value = 0,
            message = "The minimum price is 0"
    )
    private double price;

    @Min(
            value = 0,
            message = "The minimum stock is 0"
    )
    private int quantity;

    private boolean state;

    @ManyToOne()
    @JoinColumn(
            name = "id_category",
            referencedColumnName = "id_category"
    )
    private Category category;

}
