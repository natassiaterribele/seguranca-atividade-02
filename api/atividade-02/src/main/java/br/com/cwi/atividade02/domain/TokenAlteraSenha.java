package br.com.cwi.atividade02.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TokenAlteraSenha {
    private String email;
    private Long criadoEm;
}
