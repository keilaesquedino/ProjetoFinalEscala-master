package com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.DTO.TreinamentoDTO;
import com.teste.Model.Treinamento;
import com.teste.Repository.TreinamentoRepository;

@Service
public class TreinamentoService {

    @Autowired
    private TreinamentoRepository repository;

    public List<TreinamentoDTO> findAll() {
        List<Treinamento> result = repository.findAll();
        return result.stream().map(x -> new
                TreinamentoDTO(x)).collect(Collectors.toList());
    }

    public Treinamento findById(Long id) {
        Optional<Treinamento> t = repository.findById(id);
        return t.get();
    }

    public Treinamento save(Treinamento Treinamento) {
        Treinamento t = repository.save(Treinamento);
        return t;
    }

    @Transactional
    public Treinamento update(Long id,Treinamento Treinamento) {
        Treinamento t = repository.getById(id);
        t.setId(id);
        t.setNome(Treinamento.getNome());
        Treinamento vendpt = repository.save(t);
        return vendpt;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

