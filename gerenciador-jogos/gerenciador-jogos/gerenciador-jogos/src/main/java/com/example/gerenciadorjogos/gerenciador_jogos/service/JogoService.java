package com.example.gerenciadorjogos.gerenciador_jogos.service;

import com.example.gerenciadorjogos.gerenciador_jogos.model.Jogo;

import java.util.List;
import java.util.Optional;

public interface JogoService {
    Jogo cadastrar(Jogo jogo);
    List<Jogo> listar();
    List<Jogo> pesquisarPorNome(String nome);
    List<Jogo> pesquisarPorGenero(String genero);
    Optional<Jogo> listarPorId(Long id); // Método para listar por ID
    Jogo pesquisarPorId(Long id); // Método para pesquisar por ID
    void remover(Long id);
}
