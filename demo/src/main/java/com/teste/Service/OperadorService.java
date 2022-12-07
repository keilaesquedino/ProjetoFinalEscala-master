package com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.DTO.OperadorDTO;
import com.teste.Model.Operador;
import com.teste.Repository.OperadorRepository;

@Service
public class OperadorService {

    @Autowired
    private OperadorRepository repository;

    public void salvarOperador (Operador Operador) {repository.save(Operador);}

    public List<OperadorDTO> findAll() {
        List<Operador> result = repository.findAll();
        return result.stream().map(x -> new
                OperadorDTO(x)).collect(Collectors.toList());
    }

    public Operador findById(Long id) {
        Optional<Operador> v = repository.findById(id);
        return v.get();
    }

    public Operador save(Operador Operador) {
        Operador v = repository.save(Operador);
        return v;
    }

    @Transactional
    public Operador update(Long id,Operador Operador) {
        Operador o = repository.getById(id);
        o.setId(id);
        o.setNome(Operador.getNome());
        o.setData_admissao(Operador.getData_admissao());
        o.setRegime_trabalho(Operador.getRegime_trabalho());
        o.setCargo(Operador.getCargo());
        o.setSkill(Operador.getSkill());
        Operador opera = repository.save(o);
        return opera;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
