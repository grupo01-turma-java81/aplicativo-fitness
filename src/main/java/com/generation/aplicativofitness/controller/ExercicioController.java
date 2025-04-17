package com.generation.aplicativofitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.aplicativofitness.model.Exercicio;
import com.generation.aplicativofitness.repository.ExercicioRepository;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {

    @Autowired
    private ExercicioRepository exercicioRepository;
    
    @GetMapping
    public ResponseEntity<List<Exercicio>> getAll() {
	return ResponseEntity.ok(exercicioRepository.findAll());
    }
    
}
