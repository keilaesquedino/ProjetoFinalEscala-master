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

import com.teste.DTO.TreinamentoDTO;
import com.teste.Model.Treinamento;
import com.teste.Service.TreinamentoService;

@RestController
@RequestMapping(value = "/treinadores")
public class TreinamentoController {

    @Autowired
    private TreinamentoService service;

    @GetMapping
    public ResponseEntity<List<TreinamentoDTO>> findAll() {
        System.out.println("List of Trainings:");
        List<TreinamentoDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinamentoDTO> findById(@PathVariable Long id) {
        System.out.println("Training: " + id);
        TreinamentoDTO t = new TreinamentoDTO(service.findById(id));
        return ResponseEntity.ok(t);
    }

    @PostMapping
    public ResponseEntity<Treinamento> save(@RequestBody Treinamento Treinamento) throws Exception {
        try {
            Treinamento save = service.save(Treinamento);
            System.out.println("New Training Saved Sucessfully.");
            return new ResponseEntity<>(save, null, HttpStatus.CREATED);
        }
        catch(Exception ex) {
            throw new Exception(ex);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treinamento> update(@PathVariable Long id,@RequestBody Treinamento Treinamento) {
        System.out.println("Training " + id + " Updated Sucessfully.");
        return ResponseEntity.ok(service.update(id, Treinamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        System.out.println("Training " + id + " Deleted Sucessfully.");
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
