package br.com.cwi.atividade02.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDetalharResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String fotoUrl;

}
