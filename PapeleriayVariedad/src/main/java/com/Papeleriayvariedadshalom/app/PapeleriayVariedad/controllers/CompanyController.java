package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.controllers;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController //Con esta anotación le indicamos a spring que esta clase será un controlador
public class CompanyController {

    @Autowired
    CompanyService companyService;
}
