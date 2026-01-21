package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topico")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private final CriarTopico topicoService;
    @Autowired
    private TopicoRepository topicoRepository;

    public TopicoController(CriarTopico topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoTopico> criar(
            @RequestBody @Valid DadosCriarTopico dados) {
        var topico = topicoService.executar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(
            @PageableDefault(size = 10, sort = {"id"}) Pageable paginacao
    ){
        var page = topicoRepository.findAll(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = topicoService.atualizar(dados);
        return ResponseEntity.ok(topico);
    }

    @GetMapping("/curso/{idCurso}")
    public List<DadosListagemTopico> listarPorCurso(@PathVariable Long idCurso) {
        return topicoRepository
                .findByCursoIdAndAtivoTrue(idCurso)
                .stream()
                .map(DadosListagemTopico::new)
                .toList();
    }

    @GetMapping("/{id}/respostas")
    public DadosTopicoResposta detalharComRespostas(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        return new DadosTopicoResposta(topico);
    }

    @GetMapping("/ordenados")
    public List<DadosListagemTopico> listarOrdenados() {
        return topicoRepository
                .findAllByAtivoTrue(Sort.by("dataCriacao").descending())
                .stream()
                .map(DadosListagemTopico::new)
                .toList();
    }

}

