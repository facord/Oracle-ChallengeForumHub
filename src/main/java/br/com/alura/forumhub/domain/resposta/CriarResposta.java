package br.com.alura.forumhub.domain.resposta;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.domain.resposta.validacoes.ValidadorResposta;
import br.com.alura.forumhub.domain.topico.TopicoRepository;
import br.com.alura.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CriarResposta {

    private final RespostaRepository respostaRepository;
    private final UsuarioRepository usuarioRepository;
    private final TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorResposta> validadores;

    public CriarResposta(RespostaRepository respostaRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository, TopicoRepository topicoRepository) {
        this.respostaRepository = respostaRepository;
        this.usuarioRepository = usuarioRepository;
        this.topicoRepository = topicoRepository;
    }

    public Resposta executar(DadosCriarResposta dados) {
        if (!usuarioRepository.existsById(dados.autorId())) {
            throw new ValidacaoException("Id do usuario informado não existe!");
        }
        if (!topicoRepository.existsById(dados.topicoId())) {
            throw new ValidacaoException("Id do tópico informado não existe!");
        }
        validadores.forEach(v -> v.validar(dados));
        var autor = usuarioRepository.getReferenceById(dados.autorId());
        var topico = topicoRepository.getReferenceById(dados.topicoId());

        var resposta = new Resposta(
                null,
                dados.mensagem(),
                LocalDateTime.now(),
                dados.solucao(),
                topico,
                autor,
                dados.ativo()
        );

        return respostaRepository.save(resposta);
    }
}
