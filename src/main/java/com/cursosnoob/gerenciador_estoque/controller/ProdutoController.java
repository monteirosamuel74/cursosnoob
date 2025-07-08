package com.cursosnoob.gerenciador_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cursosnoob.gerenciador_estoque.model.Produto;
import com.cursosnoob.gerenciador_estoque.repository.ProdutoRepository;

@Controller
@RequestMapping("/produtos") // Mapeamento principal alterado para /produtos
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Exibe a lista de todos os produtos
    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("listaProdutos", produtoRepository.findAll());
        return "listagem-produtos"; // Aponta para o novo arquivo HTML
    }

    // Exibe o formulário de cadastro de novo produto
    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("produto", new Produto());
        // Envia os valores do Enum para o formulário poder criar o dropdown
        model.addAttribute("niveisEstoque", Produto.NivelEstoque.values());
        return "cadastro-produto"; // Aponta para o novo arquivo HTML
    }

    // Processa o envio do formulário
    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produtos"; // Redireciona para a listagem de produtos
    }
}