package com.generation.aplicativofitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.aplicativofitness.model.Treino;
import com.generation.aplicativofitness.repository.TreinoRepository;

@RestController
@RequestMapping("/treino")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TreinoController {

    @Autowired
    private TreinoRepository treinoRepository;
    
    @GetMapping
    public ResponseEntity<List<Treino>> getAll() {
	return ResponseEntity.ok(treinoRepository.findAll());
    }
}
