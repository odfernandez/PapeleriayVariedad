package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAllCompanies();
    Company findCompanyById(Integer id) throws ModelNotFoundException;
    Company saveCompany(Company company);
    Company updateCompany(Integer id, Company company);
    void deleteCompany(Integer id);
}
