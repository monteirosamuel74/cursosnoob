package com.cursosnoob.controller;
import com.cursosnoob.model.Curso;
import com.cursosnoob.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursos") // Todas as URLs deste controller começarão com /cursos
public class CursoController {

    @Autowired // Injeção de dependência: O Spring fornecerá uma instância do CursoRepository.
    private CursoRepository cursoRepository;

    // Método para exibir a lista de todos os cursos
    @GetMapping
    public String listarCursos(Model model) {
        model.addAttribute("listaCursos", cursoRepository.findAll());
        return "listagem-cursos"; // Retorna o nome do arquivo HTML (sem a extensão .html)
    }

    // Método para exibir o formulário de cadastro
    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("curso", new Curso());
        return "cadastro-curso";
    }

    // Método para processar o envio do formulário
    @PostMapping("/salvar")
    public String salvarCurso(@ModelAttribute Curso curso) {
        cursoRepository.save(curso);
        return "redirect:/cursos"; // Redireciona para a página de listagem
    }
}
