package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.resposta.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resposta")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {
    @Autowired
    private final CriarResposta criarResposta;
    @Autowired
    private RespostaRepository respostaRepository;

    public RespostaController(CriarResposta criarResposta) {
        this.criarResposta = criarResposta;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoResposta> criar(
            @RequestBody @Valid DadosCriarResposta dados) {
        var resposta = criarResposta.executar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoResposta(resposta));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemResposta>> listar(
            @PageableDefault(size = 10, sort = {"id"}) Pageable paginacao
    ){
        var page = respostaRepository.findAll(paginacao).map(DadosListagemResposta::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var resposta = respostaRepository.getReferenceById(id);
        resposta.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var resposta = respostaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoResposta(resposta));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoResposta dados) {
        var resposta = respostaRepository.getReferenceById(dados.id());
        resposta.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoResposta(resposta));
    }

}
