package br.com.cwi.atividade02.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors()

                .and()
                    .authorizeRequests()
                        .antMatchers("/*/**/publico").permitAll()
                        .antMatchers("/usuarios/esqueci-senha").permitAll()
                        .antMatchers("/usuarios/alterar-senha/*").permitAll()
                        .antMatchers(POST, "/usuarios").permitAll()

                .and()
                    .authorizeRequests()
                        .anyRequest().authenticated()

                .and()
                    .httpBasic()
                        .authenticationEntryPoint((request, response, authException) -> response.setStatus(UNAUTHORIZED.value()))

                .and()
                    .logout()
                        .logoutSuccessHandler((request, response, authentication) -> response.setStatus(OK.value()))
        ;

        return http.build();
    }
}
