package br.com.alura.forumhub.domain.resposta.validacoes;

import br.com.alura.forumhub.domain.resposta.DadosCriarResposta;
import br.com.alura.forumhub.domain.resposta.Resposta;

public interface ValidadorResposta {
    void validar(DadosCriarResposta dados);
}
