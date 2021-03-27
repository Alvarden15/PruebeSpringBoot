package com.programaciondos.prueba1.APIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.programaciondos.prueba1.Models.Employee;
import com.programaciondos.prueba1.Repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleado")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @RequestMapping("/")
    public String index(){
        return "Saludos desde spring boot";
    }

    @GetMapping(value = "/employees", produces = {"application/json"})
    public ResponseEntity<List<Employee>> employees(){
        List<Employee> empleados = employeeRepository.findAll();
        return new ResponseEntity<List<Employee>>(empleados, HttpStatus.OK) ;
    }

    @GetMapping(value = "/employees/{id}", produces = {"application/json"})
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id){
        Optional<Employee> empleado = employeeRepository.findById(id);
        if (empleado.isPresent()){
            return new ResponseEntity<Employee>(empleado.get(), HttpStatus.OK) ;
        }else{
            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST) ;
        }
        
    }

    @PostMapping(value = "/employee", produces = {"application/json"})
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e){
        employeeRepository.save(e);
        employeeRepository.flush();
        return new ResponseEntity<Employee>(e, HttpStatus.OK) ;
    }

    @PutMapping(value = "/employees/{id}", produces = {"application/json"})
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee e){
        Optional<Employee> empleado = employeeRepository.findById(id);
        if (!empleado.isPresent()){
            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST) ;
        }
        Employee modificado = empleado.get();
        modificado.setNombre(e.getNombre());
        modificado.setApellido(e.getApellido());
        employeeRepository.save(modificado);

        return new ResponseEntity<Employee>(empleado.get(), HttpStatus.OK) ;

    }

    @DeleteMapping(value = "/employees/{id}", produces = {"application/json"})
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id){
        Optional<Employee> empleado = employeeRepository.findById(id);
        if (!empleado.isPresent()){
            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST) ;
        }
        employeeRepository.deleteById(id);
        return new ResponseEntity<Employee>(empleado.get(), HttpStatus.OK) ;

    }
}
