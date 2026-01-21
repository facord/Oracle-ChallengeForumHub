package br.com.alura.forumhub.domain.topico;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.domain.topico.validacoes.ValidadorAtualizacaoTopico;
import br.com.alura.forumhub.domain.topico.validacoes.ValidadorTopico;
import br.com.alura.forumhub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CriarTopico {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    @Autowired
    private List<ValidadorTopico> validadores;
    @Autowired
    private List<ValidadorAtualizacaoTopico> validadoresAtualizacao;

    public CriarTopico(TopicoRepository topicoRepository,
                       UsuarioRepository usuarioRepository,
                       CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    public Topico executar(DadosCriarTopico dados) {
        validadores.forEach(v -> v.validar(dados));
        var autor = usuarioRepository.getReferenceById(dados.autorId());
        var curso = cursoRepository.getReferenceById(dados.cursoId());

        var topico = new Topico(
                null,
                dados.titulo(),
                dados.mensagem(),
                LocalDateTime.now(),
                Status.NAO_RESPONDIDO,
                autor,
                curso,
                true,
                null
        );
        return topicoRepository.save(topico);
    }

    @Transactional
    public DadosDetalhamentoTopico atualizar(DadosAtualizacaoTopico dados) {
        validadoresAtualizacao.forEach(v -> v.validar(dados));
        var topico = topicoRepository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
        return new DadosDetalhamentoTopico(topico);
    }
}

