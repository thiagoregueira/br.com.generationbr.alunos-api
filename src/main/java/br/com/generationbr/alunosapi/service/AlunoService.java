package br.com.generationbr.alunosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.generationbr.alunosapi.model.Aluno;
import br.com.generationbr.alunosapi.repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    /**
     * Retorna todos os alunos do banco de dados.
     *
     * @return uma lista de todos os alunos
     */
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    /**
     * Retorna um objeto Aluno pelo seu ID.
     *
     * @param id o ID do Aluno a ser retornado
     * @return um objeto Optional contendo o Aluno, ou um Optional vazio caso nenhum
     *         Aluno seja encontrado
     */
    public Optional<Aluno> getAlunoById(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isEmpty()) {
            throw new IllegalArgumentException("Aluno não encontrado!");
        }
        return alunoOptional;
    }

    /**
     * Salva uma instância de `Aluno` no banco de dados.
     *
     * @param aluno o objeto `Aluno` a ser salvo
     * @return o objeto `Aluno` salvo
     */
    public Aluno saveAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    /**
     * Atualiza um Aluno existente no alunoRepository com o ID e objeto Aluno
     * fornecidos.
     *
     * @param id    o ID do Aluno a ser atualizado
     * @param aluno o objeto Aluno atualizado
     * @return o objeto Aluno atualizado salvo no alunoRepository
     * @throws IllegalArgumentException se o Aluno com o ID fornecido não existir
     */
    public Aluno updateAluno(Long id, Aluno aluno) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno alunoExistente = alunoOptional.get();
            alunoExistente.setNome(aluno.getNome());
            alunoExistente.setIdade(aluno.getIdade());
            alunoExistente.setNotaPrimeiroSemestre(aluno.getNotaPrimeiroSemestre());
            alunoExistente.setNotaSegundoSemestre(aluno.getNotaSegundoSemestre());
            alunoExistente.setNomeProfessor(aluno.getNomeProfessor());
            alunoExistente.setNumeroSala(aluno.getNumeroSala());
            return alunoRepository.save(alunoExistente);
        } else {
            throw new IllegalArgumentException("Aluno não encontrado!");
        }
    }

    /**
     * Deleta um aluno pelo seu ID.
     *
     * @param id o ID do aluno a ser deletado
     * @return nenhum
     */
    public void deleteAluno(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isEmpty()) {
            throw new IllegalArgumentException("Aluno não encontrado!");
        }
        alunoRepository.deleteById(id);
    }
}
