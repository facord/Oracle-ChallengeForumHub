package br.com.alura.forumhub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "curso")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DadosCurso dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }

    public void atualizarInformacoes(DadosCurso dados) {
        if (dados.id() != null) {
            this.id = dados.id();
        }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
