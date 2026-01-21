package br.com.alura.forumhub.domain.resposta;

import br.com.alura.forumhub.domain.topico.Topico;
import br.com.alura.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "resposta")
@Entity(name = "Resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String mensagem;
    private LocalDateTime data_criacao;
    private Boolean solucao;
    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor_id;
    private Boolean ativo;

    public void excluir() {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizacaoResposta dados) {
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.solucao() != null) {
            this.solucao = dados.solucao();
        }
        if (dados.ativo() != null) {
            this.ativo = dados.ativo();
        }
    }
}
