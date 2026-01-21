package br.com.alura.forumhub.domain.perfil;

import br.com.alura.forumhub.domain.curso.Categoria;
import br.com.alura.forumhub.domain.curso.DadosCurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "perfil")
@Entity(name = "Perfil")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Perfil(DadosPerfil dados) {
        this.id = dados.id();
        this.nome = dados.nome();
    }

    public void atualizarInformacoes(DadosPerfil dados) {
        if (dados.id() != null) {
            this.id = dados.id();
        }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }
}
