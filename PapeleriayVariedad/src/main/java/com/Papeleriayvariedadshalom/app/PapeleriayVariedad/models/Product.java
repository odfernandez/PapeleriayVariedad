package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Entity
@Table(schema = "Products")*/

//Estas anotaciones pertenecen a la librería Lombok
@Data  //Con esta anotación le indicamos que nos cree de forma automática los métodos Getter, Setter, ToString
@AllArgsConstructor //Nos declara el constructor sobrecargado
@NoArgsConstructor  //Nos declara el constructor vacío
public class Product {

    //Declaramos las variables o atributos correspondientes a la clase Product

    private long idProduct;

    private String productName;

    private Category category;

    private double price;

    private int quantity;

    private boolean state;
}
