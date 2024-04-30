package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
