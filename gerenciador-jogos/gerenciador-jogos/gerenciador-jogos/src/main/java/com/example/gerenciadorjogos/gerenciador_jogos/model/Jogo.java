package com.example.gerenciadorjogos.gerenciador_jogos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "TB_JOGO")
@Getter
@Setter
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do jogo é obrigatório")
    @Column(name = "nm_jogo", length = 80, nullable = false)
    private String nome;

    @NotBlank(message = "O gênero do jogo é obrigatório")
    @Column(name = "genero", length = 50, nullable = false) // Novo campo adicionado
    private String genero; // Adicionando o campo gênero

    @NotNull(message = "O valor do jogo é obrigatório")
    @Positive(message = "O valor deve ser positivo")
    @Column(name = "vl_jogo", nullable = false)
    private Double valor;

    @Column(name = "ds_jogo", length = 200)
    private String descricao;

    @Column(name = "dt_lancamento")
    private LocalDate dataLancamento;

    @Column(name = "plataforma", length = 50)
    private String plataforma;

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' + // Incluindo gênero na toString
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", plataforma='" + plataforma + '\'' +
                '}';
    }
}
