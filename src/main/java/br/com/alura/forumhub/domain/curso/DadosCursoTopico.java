package br.com.alura.forumhub.domain.curso;

public record DadosCursoTopico(
        Long id,
        String nome,
        Categoria categoria
) {
    public DadosCursoTopico(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}

