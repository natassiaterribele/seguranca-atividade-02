package br.com.cwi.atividade02.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EsqueciSenhaRequest {

    @NotBlank(message = "Campo email deve ser preenchido")
    private String email;
}
