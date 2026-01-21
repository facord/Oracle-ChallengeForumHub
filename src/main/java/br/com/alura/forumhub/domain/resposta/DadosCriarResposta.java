package br.com.alura.forumhub.domain.resposta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCriarResposta(
        @NotBlank
        String mensagem,
        Boolean solucao,
        @NotNull
        Long topicoId,
        @NotNull
        Long autorId,
        Boolean ativo
) {
}
