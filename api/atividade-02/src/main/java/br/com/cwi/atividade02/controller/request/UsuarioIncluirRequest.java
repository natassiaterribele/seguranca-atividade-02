package br.com.cwi.atividade02.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class UsuarioIncluirRequest {

    @NotBlank(message = "Campo nome não pode ser nulo")
    private String nome;

    @Email
    @NotNull(message = "Campo email não pode ser nulo")
    private String email;

    @NotBlank(message = "Campo senha não pode ser nulo")
    private String senha;

    @NotBlank(message = "Campo telefone não pode ser nulo")
    private String telefone;

    private LocalDateTime criadoEm;

    @NotBlank(message = "Campo foto não pode ser nulo")
    private String fotoUrl;
}
