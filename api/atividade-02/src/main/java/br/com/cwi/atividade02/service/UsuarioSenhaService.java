package br.com.cwi.atividade02.service;

import br.com.cwi.atividade02.controller.request.AlterarSenhaRequest;
import br.com.cwi.atividade02.controller.request.EsqueciSenhaRequest;
import br.com.cwi.atividade02.domain.TokenAlteraSenha;
import br.com.cwi.atividade02.domain.Usuario;
import br.com.cwi.atividade02.repository.UsuarioRepository;
import br.com.cwi.atividade02.security.service.EmailService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.KeyBasedPersistenceTokenService;
import org.springframework.security.core.token.SecureRandomFactoryBean;
import org.springframework.security.core.token.Token;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class UsuarioSenhaService {

    private static final int DURACAO_TOKEN_MINUTOS = 10;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @SneakyThrows
    public void esqueciSenha(EsqueciSenhaRequest request) {

        Usuario usuario = buscarUsuarioService.porEmail(request.getEmail());

        KeyBasedPersistenceTokenService geradorDeTokenService = obtemServicoGeradorToken(usuario);

        Token token = geradorDeTokenService.allocateToken(usuario.getEmail());

        emailService.enviarEmail(request.getEmail(), "Recuperação de senha", "Você poderá redefinir a senha acessando o link: http://localhost:3000/change-password/" + token.getKey());
    }

    @SneakyThrows
    @Transactional
    public void alterarSenha(AlterarSenhaRequest request, String token) {

        TokenAlteraSenha dadosToken = buscarDadosToken(token);

        if(verificaTokenExpirado(dadosToken)) {
            throw new ResponseStatusException(BAD_REQUEST, "Token expirado");
        }

        Usuario usuario = buscarUsuarioService.porEmail(dadosToken.getEmail());

        KeyBasedPersistenceTokenService geradorDeTokenService = obtemServicoGeradorToken(usuario);
        geradorDeTokenService.verifyToken(token);

        usuario.setSenha(this.passwordEncoder.encode(request.getNovaSenha()));
        usuarioRepository.save(usuario);
    }


    private boolean verificaTokenExpirado(TokenAlteraSenha tokenAlteraSenha) {
        Instant criadoEm = new Date(tokenAlteraSenha.getCriadoEm()).toInstant();
        Instant dataAtual = new Date().toInstant();

        return criadoEm.plus(Duration.ofMinutes(DURACAO_TOKEN_MINUTOS)).isBefore(dataAtual);
    }

    private KeyBasedPersistenceTokenService obtemServicoGeradorToken(Usuario usuario) throws Exception {
        KeyBasedPersistenceTokenService geradorDeTokenService = new KeyBasedPersistenceTokenService();

        geradorDeTokenService.setServerSecret(usuario.getSenha());
        geradorDeTokenService.setServerInteger(16);
        geradorDeTokenService.setSecureRandom(new SecureRandomFactoryBean().getObject());
        return geradorDeTokenService;
    }

    private TokenAlteraSenha buscarDadosToken(String token) {
        String tokenDecodificado = new String(Base64.getDecoder().decode(token));
        String[] tokenSplit = tokenDecodificado.split(":");
        Long dataCriacao = Long.parseLong(tokenSplit[0]);
        String email = tokenSplit[2];
        return new TokenAlteraSenha(email, dataCriacao);
    }

}
