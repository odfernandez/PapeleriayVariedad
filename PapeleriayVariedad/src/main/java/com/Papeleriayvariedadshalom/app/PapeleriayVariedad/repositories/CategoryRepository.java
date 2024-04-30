package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    //Consulta con JPQL
    @Query(value = "Select c From Category c Where c.description = :descriptionCategory")
    Optional<Category> findCategoryByNameWithJPQL(@Param("descriptionCategory") String description);

    Optional<Category> findByDescription(String description);

    Optional<Category> findByDescriptionIgnoreCase(String description);

}
