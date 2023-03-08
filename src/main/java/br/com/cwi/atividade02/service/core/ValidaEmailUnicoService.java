package br.com.cwi.atividade02.service.core;

import br.com.cwi.atividade02.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class ValidaEmailUnicoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(String email) {

        boolean existeOutroEmailIgual = usuarioRepository.existsByEmail(email);

        if (existeOutroEmailIgual) {
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Email já cadastrado");
        }
    }
}
