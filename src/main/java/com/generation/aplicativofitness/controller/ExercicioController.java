package com.generation.aplicativofitness.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.aplicativofitness.model.Exercicio;
import com.generation.aplicativofitness.repository.ExercicioRepository;
import com.generation.aplicativofitness.repository.TreinoRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/exercicio")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExercicioController {

    @Autowired
    private final TreinoRepository treinoRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    ExercicioController(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Exercicio>> getAll() {
	return ResponseEntity.ok(exercicioRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> getById(@PathVariable Long id) {
        return exercicioRepository.findById(id)
        	.map(resposta -> ResponseEntity.ok(resposta))
        	.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Exercicio> post(@Valid @RequestBody Exercicio exercicio) {
	if (treinoRepository.existsById(exercicio.getTreino().getId())) {
	    return ResponseEntity.status(HttpStatus.CREATED)
		.body(exercicioRepository.save(exercicio));
	}
	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Treino não Encontrado", null);
    }

    @PutMapping
    public ResponseEntity<Exercicio> put(@Valid @RequestBody Exercicio exercicio) {
	if (exercicioRepository.existsById(exercicio.getId())) {
	    if (treinoRepository.existsById(exercicio.getTreino().getId())) {
        	    return ResponseEntity.status(HttpStatus.OK)
        		    .body(exercicioRepository.save(exercicio));
	    }
	    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Treino não encontrado", null);
	}
	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
	Optional<Exercicio> exercicio = exercicioRepository.findById(id);

	if (exercicio.isEmpty()) {
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	exercicioRepository.deleteById(id);
    }

}
