package com.teste.Controller;

import java.util.List;

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

import com.teste.DTO.SupervisorDTO;
import com.teste.Model.Supervisor;
import com.teste.Service.SupervisorService;

@RestController
@RequestMapping(value = "/supervisores")
public class SupervisorController {

    @Autowired
    private SupervisorService service;

    @GetMapping
    public ResponseEntity<List<SupervisorDTO>> findAll() {
        System.out.println("List of Supervisors:");
        List<SupervisorDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupervisorDTO> findById(@PathVariable Long id) {
        System.out.println("Supervisor: " + id);
        SupervisorDTO v = new SupervisorDTO(service.findById(id));
        return ResponseEntity.ok(v);
    }

    @PostMapping
    public ResponseEntity<Supervisor> save(@RequestBody Supervisor Supervisor) throws Exception {
        try {
            Supervisor save = service.save(Supervisor);
            System.out.println("New Supervisor Saved Sucessfully.");
            return new ResponseEntity<>(save, null, HttpStatus.CREATED);
        }
        catch(Exception ex) {
            throw new Exception(ex);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supervisor> update(@PathVariable Long id,@RequestBody Supervisor Supervisor) {
        System.out.println("Supervisor " + id + " Updated Sucessfully.");
        return ResponseEntity.ok(service.update(id, Supervisor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        System.out.println("Supervisor " + id + " Deleted Sucessfully.");
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
