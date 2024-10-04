package com.example.gerenciadorjogos.gerenciador_jogos.service;

import com.example.gerenciadorjogos.gerenciador_jogos.model.Jogo;
import com.example.gerenciadorjogos.gerenciador_jogos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class JogoServiceImpl implements JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Override
    public Jogo cadastrar(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    @Override
    public List<Jogo> listar() {
        return jogoRepository.findAll();
    }

    @Override
    public List<Jogo> pesquisarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return Collections.emptyList();
        }
        List<Jogo> jogosEncontrados = jogoRepository.findByNomeContainingIgnoreCase(nome);
        System.out.println("Número de jogos encontrados: " + jogosEncontrados.size());
        return jogosEncontrados;
    }

    @Override
    public List<Jogo> pesquisarPorGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            return Collections.emptyList();
        }
        List<Jogo> jogosEncontrados = jogoRepository.findByGeneroContainingIgnoreCase(genero);
        System.out.println("Número de jogos encontrados por gênero: " + jogosEncontrados.size());
        return jogosEncontrados;
    }

    @Override
    public Optional<Jogo> listarPorId(Long id) {
        return jogoRepository.findById(id);
    }

    @Override
    public Jogo pesquisarPorId(Long id) {
        return jogoRepository.findById(id).orElse(null); // Retorna o jogo se encontrado ou null se não encontrado
    }

    @Override
    public void remover(Long id) {
        jogoRepository.deleteById(id);
    }
}
