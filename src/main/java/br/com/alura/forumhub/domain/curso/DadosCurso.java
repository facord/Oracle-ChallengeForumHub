package br.com.alura.forumhub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCurso(
        @NotBlank
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        Categoria categoria
) {
}
