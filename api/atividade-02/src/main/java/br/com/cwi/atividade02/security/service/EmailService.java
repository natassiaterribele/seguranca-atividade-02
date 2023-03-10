package br.com.cwi.atividade02.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarEmail(String email, String assunto, String textoEmail) {
        SimpleMailMessage emailParaEnviar = new SimpleMailMessage();

        emailParaEnviar.setFrom("noreply@gmail.com");
        emailParaEnviar.setTo(email);
        emailParaEnviar.setSubject(assunto);
        emailParaEnviar.setText(textoEmail);

        javaMailSender.send(emailParaEnviar);
    }
}
