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

import com.teste.DTO.Skill_UserDTO;
import com.teste.Model.Skill_User;
import com.teste.Service.Skill_UserService;

@RestController
@RequestMapping(value = "/skillusers")
public class Skill_UserController {

    @Autowired
    private Skill_UserService service;

    @GetMapping
    public ResponseEntity<List<Skill_UserDTO>> findAll() {
        System.out.println("List of SkillUsers:");
        List<Skill_UserDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill_UserDTO> findById(@PathVariable Long id) {
        System.out.println("SkillUser: " + id);
        Skill_UserDTO t = new Skill_UserDTO(service.findById(id));
        return ResponseEntity.ok(t);
    }

    @PostMapping
    public ResponseEntity<Skill_User> save(@RequestBody Skill_User Skill_User) throws Exception {
        try {
            Skill_User save = service.save(Skill_User);
            System.out.println("New SkillUser Saved Sucessfully.");
            return new ResponseEntity<>(save, null, HttpStatus.CREATED);
        }
        catch(Exception ex) {
            throw new Exception(ex);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill_User> update(@PathVariable Long id,@RequestBody Skill_User Skill_User) {
        System.out.println("SkillUser " + id + " Updated Sucessfully.");
        return ResponseEntity.ok(service.update(id, Skill_User));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        System.out.println("SkillUser " + id + " Deleted Sucessfully.");
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
