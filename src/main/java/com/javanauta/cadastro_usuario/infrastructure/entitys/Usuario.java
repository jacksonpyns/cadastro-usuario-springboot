package com.javanauta.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter     // Para Obter informações
@Setter     // Para Setar informações
@AllArgsConstructor     // Os Contrutores para acessar essa classe
@NoArgsConstructor     // Os Contrutores para acessar essa classe
@Builder    // Para usar o Update
@Table(name = "usuario")       // Para indicar que isso aqui é uma Tabela
@Entity     // É usado junto com o @Table caso a tabela no banco tenha um nome diferente
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Vai gerar o Id automaticamente
    private Integer id;

    @Column(name = "email", unique = true)     // Coluna da tabela e o "unique" significa que o email é ÚNICO
    private String email;

    @Column(name = "nome")
    private String nome;


}
