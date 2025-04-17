package com.generation.aplicativofitness.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_exercicio")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 10, max = 130)
    private String nome;

    @Size(min = 20, max = 200)
    private String descricao;

    @NotBlank
    @Size(min = 10, max = 100)
    private String regiaoMuscular;

    @NotBlank
    @Size(min = 3, max = 30)
    private String diaExercicio;
    
    @ManyToOne
    @JsonIgnoreProperties("exercicio")
    private Treino treino;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public String getRegiaoMuscular() {
	return regiaoMuscular;
    }

    public void setRegiaoMuscular(String regiaoMuscular) {
	this.regiaoMuscular = regiaoMuscular;
    }

    public String getDiaExercicio() {
	return diaExercicio;
    }

    public void setDiaExercicio(String diaExercicio) {
	this.diaExercicio = diaExercicio;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

}
