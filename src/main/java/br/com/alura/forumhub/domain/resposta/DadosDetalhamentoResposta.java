package br.com.alura.forumhub.domain.resposta;

import br.com.alura.forumhub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(
        Long id,
        String mensagem,
        LocalDateTime data_criacao,
        Boolean solucao,
        Long topicoId,
        String autor_id,
        Boolean ativo
) {
    public DadosDetalhamentoResposta(Resposta resposta) {
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getData_criacao(),
                resposta.getSolucao(),
                resposta.getTopico().getId(),
                resposta.getAutor_id().getNome(),
                resposta.getAtivo()
        );
    }

}
