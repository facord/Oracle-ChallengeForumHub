package br.com.alura.forumhub.domain.resposta;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoResposta(
        @NotNull
        Long id,
        String mensagem,
        Boolean solucao,
        Boolean ativo
) {
}
