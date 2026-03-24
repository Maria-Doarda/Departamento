package com.example.departamento.controllers;

import com.example.departamento.models.DepartamentoModel;
import com.example.departamento.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel request = departamentoService.criarDepartamento(departamentoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(departamentoModel).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> request = departamentoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        departamentoService.deletar(id);
    }
}
