package com.teste.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.teste.DTO.OperadorDTO;
import com.teste.Model.Operador;
import com.teste.Repository.OperadorRepository;
import com.teste.Service.OperadorService;

@RestController
@RequestMapping(value = "/operadores")
public class OperadorController {

    @Autowired
    private OperadorService service;

    @Autowired
    private OperadorRepository repository;

    @GetMapping
    public ResponseEntity<List<OperadorDTO>> findAll() {
        System.out.println("List of Operators:");
        List<OperadorDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<Operador>> findAll(Pageable pageable) {
        Page<Operador> list = repository.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperadorDTO> findById(@PathVariable Long id) {
        System.out.println("Operator: " + id);
        OperadorDTO t = new OperadorDTO(service.findById(id));
        return ResponseEntity.ok(t);
    }

    @PostMapping
    public ResponseEntity<Operador> save(@RequestBody Operador Operador) throws Exception {
        try {
            Operador save = service.save(Operador);
            System.out.println("New Operator Saved Sucessfully.");
            return new ResponseEntity<>(save, null, HttpStatus.CREATED);
        }
        catch(Exception ex) {
            throw new Exception(ex);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Operador> update(@PathVariable Long id,@RequestBody Operador Operador) {
        System.out.println("Operator " + id + " Updated Sucessfully.");
        return ResponseEntity.ok(service.update(id, Operador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        System.out.println("Operator " + id + " Deleted Sucessfully.");
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

