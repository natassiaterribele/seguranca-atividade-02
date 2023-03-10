package br.com.cwi.atividade02.service;

import br.com.cwi.atividade02.controller.request.UsuarioIncluirRequest;
import br.com.cwi.atividade02.controller.response.UsuarioResponse;
import br.com.cwi.atividade02.domain.Usuario;
import br.com.cwi.atividade02.repository.UsuarioRepository;
import br.com.cwi.atividade02.security.domain.Permissao;
import br.com.cwi.atividade02.service.core.ValidaEmailUnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static br.com.cwi.atividade02.mapper.UsuarioMapper.toEntity;
import static br.com.cwi.atividade02.mapper.UsuarioMapper.toResponse;
import static br.com.cwi.atividade02.security.domain.Funcao.USUARIO;


@Service
public class UsuarioIncluirService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ValidaEmailUnicoService validaEmailUnicoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioResponse incluir(UsuarioIncluirRequest request) {

        validaEmailUnicoService.validar(request.getEmail());

        Usuario usuario = toEntity(request);
        usuario.setSenha(getSenhaCriptografada(request.getSenha()));
        usuario.adicionarPermissao(getPermissaoPadrao());
        usuario.setCriadoEm(LocalDateTime.now());
        usuario.setAtivo(true);

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }

    private String getSenhaCriptografada(String senhaAberta) {
        return passwordEncoder.encode(senhaAberta);
    }

    private Permissao getPermissaoPadrao() {
        Permissao permissao = new Permissao();
        permissao.setFuncao(USUARIO);
        return permissao;
    }

}
