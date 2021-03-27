package com.programaciondos.prueba1.Repositories;


import com.programaciondos.prueba1.Models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    
}
