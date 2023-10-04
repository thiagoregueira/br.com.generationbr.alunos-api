package br.com.generationbr.alunosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generationbr.alunosapi.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
