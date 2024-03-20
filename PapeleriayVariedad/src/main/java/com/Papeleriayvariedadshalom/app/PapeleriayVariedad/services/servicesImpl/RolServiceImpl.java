package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.servicesImpl;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Rol;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories.RolRepository;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //Con esta anotación le indicamos a Spring, que esta clase manejará la capa de servicios
public class RolServiceImpl implements RolService {
//En esta clase implementamos la interfaz RolService donde se definen los métodos a  utilizar

    @Autowired //Con esta anotación manejamos la inyección de dependencias
    RolRepository rolRepository;

    @Override
    public List<Rol> findAllRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findRolById(int id) throws ModelNotFoundException {
        Optional<Rol> rol = rolRepository.findById(id);
        if (!rol.isPresent()){
            throw new ModelNotFoundException("Rol is not available");
        }
        return rol.get();
    }

    @Override
    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol updateRol(int id, Rol rol) {
        Rol rolDb = rolRepository.findById(id).get();
        if (Objects.nonNull(rol.getIdRol()) && !"".equalsIgnoreCase(rol.getIdRol())){
            rolDb.setIdRol(rol.getIdRol());
        }
        if (Objects.nonNull(rol.getDescription()) && !"".equalsIgnoreCase(rol.getDescription())){
            rolDb.setDescription(rol.getDescription());
        }
        return rolRepository.save(rolDb);
    }

    @Override
    public void deleteRol(int id) {
        rolRepository.deleteById(id);
    }
}

