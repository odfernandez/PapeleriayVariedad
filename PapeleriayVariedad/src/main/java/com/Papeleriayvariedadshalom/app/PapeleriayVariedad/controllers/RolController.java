package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.controllers;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Product;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Rol;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.RolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS
        }
)
@RequestMapping(value = "/api/v1/roles")
public class RolController {

    @Autowired
    RolService rolService;

    @GetMapping(value = "findAllRoles")
    public List<Rol> findAllRoles(){
        return rolService.findAllRoles();
    }

    @GetMapping(value = "findRolById/{id}")
    public Rol findRolById(@PathVariable Long id) throws ModelNotFoundException {
        return rolService.findRolById(id);
    }

    @PostMapping(value = "saveRol")
    public Rol saveRol(@Valid @RequestBody Rol rol){
        return rolService.saveRol(rol);
    }

    @PutMapping(value = "updateRol/{id}")
    public Rol updateRol(@Valid @PathVariable Long id, @RequestBody Rol rol){
        return rolService.updateRol(id, rol);
    }

    @DeleteMapping(value = "deleteRol/{id}")
    public String deleteRol(@PathVariable Long id){
        rolService.deleteRol(id);
        return "Successfully Deleted";
    }

}
