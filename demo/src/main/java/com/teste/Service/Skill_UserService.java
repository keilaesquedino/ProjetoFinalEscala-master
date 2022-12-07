package com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.DTO.Skill_UserDTO;
import com.teste.Model.Skill;
import com.teste.Model.Skill_User;
import com.teste.Repository.SkillRepository;
import com.teste.Repository.Skill_UserRepository;

@Service
public class Skill_UserService {

    @Autowired
    private Skill_UserRepository repository;

    @Autowired
    private SkillRepository vendrepository;

    public List<Skill_UserDTO> findAll() {
        List<Skill_User>result = repository.findAll();
        return result.stream().map(x -> new
                Skill_UserDTO(x)).collect(Collectors.toList());
    }

    public Skill_User findById(Long id) {
        Optional<Skill_User> s = repository.findById(id);
        return s.get();
    }

    public Skill_User save(Skill_User Skill_User) {
        Skill Skill = vendrepository.findById
                (Skill_User.getSkill().getId()).get();
        Skill_User.setSkill(Skill);
        Skill_User s = repository.save(Skill_User);
        return s;
    }

    @Transactional
    public Skill_User update(Long id,Skill_User Skill_User) {
        Skill_User s = repository.getById(id);
        s.setId(id);
        s.setNome(Skill_User.getNome());
        Skill_User prod = repository.save(s);
        return prod;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}