package com.example.gerenciadorjogos.gerenciador_jogos.repository;

import com.example.gerenciadorjogos.gerenciador_jogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByNomeContainingIgnoreCase(String nome);
    List<Jogo> findByGeneroContainingIgnoreCase(String genero); // Método para buscar por gênero
    List<Jogo> findByIdIn(List<Long> ids); // Método para buscar por uma lista de IDs
}
