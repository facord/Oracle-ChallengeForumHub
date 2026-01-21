package br.com.alura.forumhub.domain.resposta.validacoes;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.resposta.DadosCriarResposta;
import br.com.alura.forumhub.domain.resposta.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDuplicidadeMensagemResposta implements ValidadorResposta {

    @Autowired
    private RespostaRepository repository;

    @Override
    public void validar(DadosCriarResposta dados) {
        boolean duplicado = repository.existsByMensagem(dados.mensagem());
        if (duplicado) {
            throw new ValidacaoException("Já existe um tópico com a mesma resposta.");
        }
    }
}
