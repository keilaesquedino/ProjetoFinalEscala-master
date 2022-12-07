package com.teste.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.DTO.SkillDTO;
import com.teste.Model.Skill;
import com.teste.Service.SkillService;

@RestController
@RequestMapping(value = "/skills")
public class SkillController {

    @Autowired
    private SkillService service;

    @GetMapping
    public ResponseEntity<List<SkillDTO>> findAll() {
        System.out.println("List of Skills:");
        List<SkillDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDTO> findById(@PathVariable Long id) {
        System.out.println("Skill: " + id);
        SkillDTO v = new SkillDTO(service.findById(id));
        return ResponseEntity.ok(v);
    }

    @PostMapping
    public String save(@RequestBody Skill Skill) throws Exception {
        System.out.println("New Training Saved Sucessfully.");
        if (Skill.getNome() == null || Skill.getNome().equals("")) {
            return "O nome do skill é obrigatório";
        }
        return "Cadastro realizado";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> update(@PathVariable Long id,@RequestBody Skill Skill) {
        System.out.println("Skill " + id + " Updated Sucessfully.");
        return ResponseEntity.ok(service.update(id, Skill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        System.out.println("Skill " + id + " Deleted Sucessfully.");
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
