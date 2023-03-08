package br.com.cwi.atividade02.controller;

import br.com.cwi.atividade02.controller.request.UsuarioEditarRequest;
import br.com.cwi.atividade02.controller.request.UsuarioIncluirRequest;
import br.com.cwi.atividade02.controller.response.UsuarioDetalharResponse;
import br.com.cwi.atividade02.controller.response.UsuarioResponse;
import br.com.cwi.atividade02.service.UsuarioDetalharService;
import br.com.cwi.atividade02.service.UsuarioEditarService;
import br.com.cwi.atividade02.service.UsuarioIncluirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioIncluirService usuarioIncluirService;

    @Autowired
    private UsuarioEditarService usuarioEditarService;

    @Autowired
    private UsuarioDetalharService usuarioDetalharService;



    @PostMapping
    @ResponseStatus(CREATED)
    public UsuarioResponse incluir(@RequestBody UsuarioIncluirRequest request) {
        return usuarioIncluirService.incluir(request);
    }

    @PutMapping("/editar")
    @ResponseStatus(OK)
    public void editarUsuario (@Valid @RequestBody UsuarioEditarRequest request) {
        usuarioEditarService.editar(request);
    }

    @GetMapping("/detalhar")
    @ResponseStatus(OK)
    public UsuarioDetalharResponse detalharUsuario () {
        return usuarioDetalharService.detalhar ();
    }
}
