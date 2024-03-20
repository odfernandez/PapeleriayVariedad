package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@Entity
@Table(name = "Users")
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;
    private Rol rol;
    private boolean state;

}
