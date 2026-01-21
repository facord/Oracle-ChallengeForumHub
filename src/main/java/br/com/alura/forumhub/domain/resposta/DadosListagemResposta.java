package br.com.alura.forumhub.domain.resposta;

import br.com.alura.forumhub.domain.usuario.DadosAutor;
import java.time.LocalDateTime;

public record DadosListagemResposta(
        Long id,
        String mensagem,
        LocalDateTime data_criacao,
        Boolean solucao,
        DadosAutor autor,
        DadosTRespostaSimplificado topico,
        boolean ativo) {
    public DadosListagemResposta(Resposta resposta) {
        this(resposta.getId(),
                resposta.getMensagem(),
                resposta.getData_criacao(),
                resposta.getSolucao(),
                new DadosAutor(resposta.getAutor_id()),
                new DadosTRespostaSimplificado(resposta.getTopico()),
                resposta.getAtivo());
    }
}