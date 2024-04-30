package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {

    List<Rol> findAllRoles();
    Rol findRolById(Long id) throws ModelNotFoundException;
    Optional<Rol> findRolByDescriptionIgnoreCase(String description) throws ModelNotFoundException;
    Rol saveRol(Rol rol);
    Rol updateRol(Long id, Rol rol);
    void deleteRol(Long id);

}
