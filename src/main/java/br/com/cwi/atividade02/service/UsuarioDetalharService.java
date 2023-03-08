package br.com.cwi.atividade02.service;

import br.com.cwi.atividade02.controller.response.UsuarioDetalharResponse;
import br.com.cwi.atividade02.domain.Usuario;
import br.com.cwi.atividade02.mapper.UsuarioDetalharMapper;
import br.com.cwi.atividade02.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UsuarioDetalharService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public UsuarioDetalharResponse detalhar() {

        Usuario usuarioLogado = usuarioAutenticadoService.get();

        return UsuarioDetalharMapper.toResponse(usuarioLogado);
    }
}
