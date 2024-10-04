package com.example.gerenciadorjogos.gerenciador_jogos.controller;

import com.example.gerenciadorjogos.gerenciador_jogos.model.Jogo;
import com.example.gerenciadorjogos.gerenciador_jogos.service.JogoService; // Importando o serviço correto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("jogo")
public class JogoController {

    @Autowired
    private JogoService jogoService; // Injetando o JogoService

    @PostMapping("remover")
    @Transactional
    public String remover(Long id, RedirectAttributes redirectAttributes) {
        jogoService.remover(id); // Use o método no serviço para remover
        redirectAttributes.addFlashAttribute("mensagem", "Jogo removido");
        return "redirect:/jogo/listar";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Jogo jogo) {
        return "jogo/cadastro";  // Crie a view correspondente
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Jogo jogo, RedirectAttributes redirectAttributes) {
        jogoService.cadastrar(jogo); // Usando o serviço
        redirectAttributes.addFlashAttribute("mensagem", "Jogo cadastrado!");
        return "redirect:/jogo/listar";  // Redireciona para a lista de jogos
    }

    @GetMapping("listar")
    public String listarJogos(Model model) {
        model.addAttribute("jogos", jogoService.listar()); // Usando o serviço
        return "jogo/listar";  // Crie a view correspondente
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("jogo", jogoService.listarPorId(id)); // Implementar método no serviço
        return "jogo/editar";  // Crie a view correspondente
    }

    @PostMapping("editar")
    public String editar(Jogo jogo, RedirectAttributes redirectAttributes) {
        jogoService.cadastrar(jogo); // Usando o serviço para atualizar
        redirectAttributes.addFlashAttribute("mensagem", "Jogo atualizado");
        return "redirect:/jogo/listar";  // Redireciona para a lista de jogos
    }

    @GetMapping("pesquisar")
    public String pesquisar(@RequestParam(required = false) String nome,
                            @RequestParam(required = false) String query,
                            @RequestParam(required = false) String genero,
                            @RequestParam(required = false) Long id,
                            Model model) {
        // Inicializa uma lista de jogos
        List<Jogo> jogos = new ArrayList<>();

        // Chama o método do serviço para buscar jogos
        if (nome != null && !nome.isEmpty()) {
            jogos = jogoService.pesquisarPorNome(nome);
        } else if (genero != null && !genero.isEmpty()) {
            jogos = jogoService.pesquisarPorGenero(genero);
        } else if (id != null) {
            Jogo jogo = jogoService.pesquisarPorId(id);
            if (jogo != null) {
                jogos.add(jogo); // Adiciona o jogo encontrado à lista
            }
        } else {
            // Se 'query' for fornecido, pode-se utilizar como nome ou gênero
            String searchTerm = query != null ? query : "";
            jogos = jogoService.pesquisarPorNome(searchTerm);
        }

        // Adiciona a linha de debug para imprimir a lista no console
        System.out.println("Jogos retornados: " + jogos);

        // Adiciona a lista de jogos e os parâmetros ao modelo
        model.addAttribute("jogos", jogos);
        model.addAttribute("nome", nome);
        model.addAttribute("genero", genero);
        model.addAttribute("id", id);
        model.addAttribute("query", query); // Passar a query ao modelo

        // Mensagem de feedback dependendo do resultado da pesquisa
        if (jogos.isEmpty()) {
            model.addAttribute("mensagem", "Nenhum jogo encontrado para os critérios de pesquisa.");
        } else {
            model.addAttribute("mensagem", "Resultados da pesquisa.");
        }

        return "jogo/pesquisa"; // Retorna a view correspondente para exibir os resultados
    }
}