package br.com.cwi.atividade02.service;

import br.com.cwi.atividade02.controller.request.UsuarioEditarRequest;
import br.com.cwi.atividade02.domain.Usuario;
import br.com.cwi.atividade02.repository.UsuarioRepository;
import br.com.cwi.atividade02.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UsuarioEditarService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void editar(UsuarioEditarRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        usuario.setNome(request.getNome());
        usuario.setTelefone(request.getTelefone());
        usuario.setFotoUrl(request.getFotoUrl());
        usuario.setAtualizadoEm(LocalDateTime.now());

        usuarioRepository.save(usuario);
    }
}
