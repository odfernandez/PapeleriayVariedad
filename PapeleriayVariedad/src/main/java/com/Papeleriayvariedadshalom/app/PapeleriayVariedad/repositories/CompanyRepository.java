package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Le indicamos a Spring que esta interfaz es un repositorio
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    //
}
