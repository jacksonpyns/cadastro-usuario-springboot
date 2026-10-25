package com.javanauta.cadastro_usuario.infrastructure.repository;

import com.javanauta.cadastro_usuario.infrastructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> { // Essa interface vai extender o JPA
    /*
     O JPA vai pegar a classe Usuario a qual a UsuarioRepository se refere
     e vai usar o tipo Integer ja que é o tipo do campo Id
     */

    // No JPA já tem o findById, mas o findByEmail tem que ser criado
    /*
      O Optional evita o nullPointAception, faz com que eu seja obrigado
     a criar uma Exceção ou uma Alternativa caso aquele Email não exista
     */
    Optional<Usuario> findByEmail(String email);

    @Transactional // Essa anotação faz com que se caso der algum erro ele não poderá deletar
    void deleteByEmail(String email);
}
