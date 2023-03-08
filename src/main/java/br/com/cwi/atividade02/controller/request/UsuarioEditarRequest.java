package br.com.cwi.atividade02.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEditarRequest {

    @NotBlank(message = "Campo nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "Campo telefone não pode ser nulo")
    private String telefone;

    @NotBlank(message = "Campo foto não pode ser nulo")
    private String fotoUrl;

    private LocalDateTime atualizadoEm;
}
