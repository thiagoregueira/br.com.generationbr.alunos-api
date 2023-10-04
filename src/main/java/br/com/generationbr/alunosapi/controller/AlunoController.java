package br.com.generationbr.alunosapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generationbr.alunosapi.model.Aluno;
import br.com.generationbr.alunosapi.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    /**
     * Recupera uma lista de todos os alunos.
     *
     * @return uma lista de todos os alunos
     */
    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    /**
     * Retorna um objeto Aluno pelo seu ID.
     *
     * @param id o ID do objeto Aluno a ser retornado
     * @return um ResponseEntity contendo o objeto Aluno se encontrado, ou uma
     *         resposta de não encontrado se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoService.getAlunoById(id);
        return aluno.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Salva um objeto Aluno.
     *
     * @param aluno o objeto Aluno a ser salvo
     * @return o ResponseEntity contendo o objeto Aluno salvo
     */
    @PostMapping
    public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno aluno) {
        Aluno savedAluno = alunoService.saveAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAluno);
    }

    /**
     * Atualiza um objeto Aluno com o ID fornecido.
     *
     * @param id    o ID do objeto Aluno a ser atualizado
     * @param aluno o objeto Aluno atualizado
     * @return o ResponseEntity contendo o objeto Aluno atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoOptional = alunoService.getAlunoById(id);
        if (alunoOptional.isPresent()) {
            Aluno alunoAtualizado = alunoOptional.get();
            alunoAtualizado.setNome(aluno.getNome());
            alunoAtualizado.setIdade(aluno.getIdade());
            alunoAtualizado.setNotaPrimeiroSemestre(aluno.getNotaPrimeiroSemestre());
            alunoAtualizado.setNotaSegundoSemestre(aluno.getNotaSegundoSemestre());
            alunoAtualizado.setNomeProfessor(aluno.getNomeProfessor());
            alunoAtualizado.setNumeroSala(aluno.getNumeroSala());
            return ResponseEntity.ok(alunoService.saveAluno(alunoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deleta um Aluno com o ID fornecido.
     *
     * @param id o ID do Aluno a ser deletado
     * @return um ResponseEntity sem conteúdo se a deleção for bem-sucedida,
     *         ou um ResponseEntity com o status "not found" se o Aluno não existir
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        try {
            alunoService.deleteAluno(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}