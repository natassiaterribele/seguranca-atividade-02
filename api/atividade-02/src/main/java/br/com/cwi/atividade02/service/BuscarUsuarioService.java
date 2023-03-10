package br.com.cwi.atividade02.service;

import br.com.cwi.atividade02.domain.Usuario;
import br.com.cwi.atividade02.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class BuscarUsuarioService {

    private static final String USUARIO_NAO_ENCONTRADO = "Esse usuario não foi encontrado";

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario porId(Long id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, USUARIO_NAO_ENCONTRADO));
    }

    public Usuario porEmail(String email) {

        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, USUARIO_NAO_ENCONTRADO));
    }
}
