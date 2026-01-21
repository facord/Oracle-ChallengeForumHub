package br.com.alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCriarTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        Long autorId,
        @NotNull
        Long cursoId,
        boolean ativo
) {
}


