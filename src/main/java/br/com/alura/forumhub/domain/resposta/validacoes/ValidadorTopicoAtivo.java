package br.com.alura.forumhub.domain.resposta.validacoes;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.resposta.DadosCriarResposta;
import br.com.alura.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoAtivo implements ValidadorResposta {

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(DadosCriarResposta dados) {
        var topicoEstaAtivo = repository.findAtivoById(dados.topicoId());
        if (!topicoEstaAtivo){
            throw new ValidacaoException("Esse tópico está encerrado.");
        }
    }
}