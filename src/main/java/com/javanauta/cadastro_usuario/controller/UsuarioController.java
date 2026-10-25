package com.javanauta.cadastro_usuario.controller;

import com.javanauta.cadastro_usuario.business.UsuarioService;
import com.javanauta.cadastro_usuario.infrastructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor // Uma forma diferente do método usado no UsuarioService, sem o contrutor
public class UsuarioController {

    private final UsuarioService usuarioService; // Para adicionar as dependencias do Service

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){ // O ResponseEntity é para ter o retorno certo do Status Codes HTTP
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build(); // Qualquer resposta HTTP é aceita aqui
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmial(@RequestParam String email){ // RequestParam é porque vai receber um parâmetro
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id, @RequestBody Usuario usuario){

        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }
}
