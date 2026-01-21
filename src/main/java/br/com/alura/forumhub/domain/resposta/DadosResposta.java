package br.com.alura.forumhub.domain.resposta;

import br.com.alura.forumhub.domain.curso.Curso;
import br.com.alura.forumhub.domain.topico.Topico;
import br.com.alura.forumhub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record DadosResposta(
        @NotBlank
        Long id,
        @NotBlank
        String mensagem,
        @NotBlank
        LocalDateTime data_criacao,
        Boolean solucao,
        @NotBlank
        Topico topico,
        @NotBlank
        Usuario autor_id,
        Boolean ativo
) {
    public DadosResposta(Resposta resposta) {
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getData_criacao(),
                resposta.getSolucao(),
                resposta.getTopico(),
                resposta.getAutor_id(),
                resposta.getAtivo()
        );
    }
}
