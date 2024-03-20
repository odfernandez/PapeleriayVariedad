package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Rol;

import java.util.List;

public interface RolService {

    List<Rol> findAllRoles();
    Rol findRolById(int id) throws ModelNotFoundException;
    Rol saveRol(Rol rol);
    Rol updateRol(int id, Rol rol);
    void deleteRol(int id);

}
