package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.servicesImpl;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Company;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories.CompanyRepository;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Declaramos esta clase como un servicio
public class CompanyServiceImpl implements CompanyService {


    @Autowired //Inyectamos la dependencia al repositorio
    CompanyRepository companyRepository;

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company findCompanyById(Integer id) throws ModelNotFoundException {
        Optional<Company> company = companyRepository.findById(id);
        if (!company.isPresent()){
            throw new ModelNotFoundException("Company is not available");
        }
        return company.get();
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Integer id, Company company) {
        return null;
    }

    @Override
    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }
}
