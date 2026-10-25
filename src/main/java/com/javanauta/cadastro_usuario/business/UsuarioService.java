package com.javanauta.cadastro_usuario.business;

import com.javanauta.cadastro_usuario.infrastructure.entitys.Usuario;
import com.javanauta.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service       // Para indicar pro Spring que essa aqui é a classe de Serviço
public class UsuarioService {

    /*
      Para fazer os métodos de Salvar, Buscar, Deletar, e Update
     vou usar o Repository
     */
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    // Ele salva e fecha a conexão com o banco de dados
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow( () -> new RuntimeException("Email não encontrado"));
    } // Por conta do findByEmail ser do tipo Optional retornei uma Exceção mostrando Email não encontrado

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    // Para fazer uma única alteração, não modificando os outros dados já salvos
    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow( () ->
                new RuntimeException("Usuario não encontrado"));  // Primeiro busco o usuario atravé do email
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail()) // ? = se, : = senão
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId()) // o Id não poderá ser passado/alterado
                .build();
        /*
         Agora eu vou ver pelo POSTMAN o que o usuario quer atualizar e os que ele não passou
         os que forem nulos eu vou pegar na Entity de volta e jogar no banco de dados
         */
        repository.saveAndFlush(usuarioAtualizado);
    }
}
