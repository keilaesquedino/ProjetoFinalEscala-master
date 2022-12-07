package com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.DTO.SupervisorDTO;
import com.teste.Model.Supervisor;
import com.teste.Repository.SupervisorRepository;

@Service
public class SupervisorService {

    @Autowired
    private SupervisorRepository repository;

    public List<SupervisorDTO> findAll() {
        List<Supervisor> result = repository.findAll();
        return result.stream().map(x -> new
                SupervisorDTO(x)).collect(Collectors.toList());
    }

    public Supervisor findById(Long id) {
        Optional<Supervisor> s = repository.findById(id);
        return s.get();
    }

    public Supervisor save(Supervisor Supervisor) {
        Supervisor s = repository.save(Supervisor);
        return s;
    }

    @Transactional
    public Supervisor update(Long id,Supervisor Supervisor) {
        Supervisor s = repository.getById(id);
        s.setId(id);
        s.setNome(Supervisor.getNome());
        s.setData_admissao(Supervisor.getData_admissao());
        s.setFuncionario(Supervisor.getFuncionario());
        Supervisor spvr = repository.save(s);
        return spvr;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
