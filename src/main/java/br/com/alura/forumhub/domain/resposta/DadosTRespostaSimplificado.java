package br.com.alura.forumhub.domain.resposta;

import br.com.alura.forumhub.domain.topico.Topico;

public record DadosTRespostaSimplificado(
        Long id,
        String titulo,
        String mensagem
) {
    public DadosTRespostaSimplificado(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem());
    }
}