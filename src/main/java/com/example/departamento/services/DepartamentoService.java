package com.example.departamento.services;

import com.example.departamento.models.DepartamentoModel;
import com.example.departamento.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoModel criarDepartamento(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    public List<DepartamentoModel> findAll(){
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoModel> buscarId(Long id){
        return departamentoRepository.findById(id);
    }

    public void deletar(Long id){
        departamentoRepository.deleteById(id);
    }
}
