package br.com.alura.forumhub.domain.perfil;

import jakarta.validation.constraints.NotBlank;

public record DadosPerfil(
        @NotBlank
        Long id,
        @NotBlank
        String nome
) {
}
