package br.com.cwi.atividade02.mapper;

import br.com.cwi.atividade02.controller.response.UsuarioDetalharResponse;
import br.com.cwi.atividade02.domain.Usuario;

import java.util.stream.Collectors;

public class UsuarioDetalharMapper {

    public static UsuarioDetalharResponse toResponse(Usuario entity) {

        return UsuarioDetalharResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .telefone(entity.getTelefone())
                .fotoUrl(entity.getFotoUrl())
                .build();
    }
}
