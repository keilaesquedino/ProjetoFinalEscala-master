package com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.DTO.SkillDTO;
import com.teste.Model.Skill;
import com.teste.Repository.SkillRepository;

@Service
public class SkillService {

    @Autowired
    private SkillRepository repository;

    public void salvarSkill (Skill Skill) {repository.save(Skill);}

    public List<SkillDTO> findAll() {
        List<Skill> result = repository.findAll();
        return result.stream().map(x -> new
                SkillDTO(x)).collect(Collectors.toList());
    }

    public Skill findById(Long id) {
        Optional<Skill> s = repository.findById(id);
        return s.get();
    }

    public Skill save(Skill Skill) {
        Skill s = repository.save(Skill);
        return s;
    }

    @Transactional
    public Skill update(Long id,Skill Skill) {
        Skill s = repository.getById(id);
        s.setId(id);
        s.setNome(Skill.getNome());
        s.setDescricao(Skill.getDescricao());
        Skill vendpt = repository.save(s);
        return vendpt;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
