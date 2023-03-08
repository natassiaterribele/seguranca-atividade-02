package br.com.cwi.atividade02.mapper;

import br.com.cwi.atividade02.controller.request.UsuarioIncluirRequest;
import br.com.cwi.atividade02.controller.response.UsuarioResponse;
import br.com.cwi.atividade02.domain.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioIncluirRequest request) {
        Usuario entity = new Usuario();
        entity.setNome(request.getNome());
        entity.setEmail(request.getEmail());
        entity.setFotoUrl(request.getFotoUrl());
        entity.setTelefone(request.getTelefone());
        return entity;
    }


    public static UsuarioResponse toResponse(Usuario entity) {

        return UsuarioResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .fotoUrl(entity.getFotoUrl())
                .email(entity.getEmail())
                .build();
    }
}
