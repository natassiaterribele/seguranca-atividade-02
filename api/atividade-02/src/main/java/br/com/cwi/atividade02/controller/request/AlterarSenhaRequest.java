package br.com.cwi.atividade02.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlterarSenhaRequest {
    @NotBlank(message = "Campo senha deve ser preenchido")
    private String novaSenha;
}
