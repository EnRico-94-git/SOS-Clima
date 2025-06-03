package br.com.sosclima.controller;

import com.example.SOSclima.model.EventoClimatico;
import com.example.SOSclima.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class SOSclimaController {

    private final EventoService eventoService;

    @Autowired
    public SOSclimaController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping("/")
    public String paginaInicial(Model model) {
        // Obter informações do usuário autenticado
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("nome_usuario", auth.getName());
        model.addAttribute("img_usuario", "/images/perfil.png"); // Imagem padrão
        
        // Lista de eventos climáticos
        model.addAttribute("eventos", eventoService.listarTodosEventos());
        
        // Alertas urgentes (exemplo)
        model.addAttribute("alertas", Arrays.asList(
            "Tempestade severa prevista para amanhã",
            "Nível dos rios acima do normal"
        ));
        
        return "index";
    }

    @GetMapping("/cad_evento_climatico")
    public String mostrarFormCadastro(Model model) {
        model.addAttribute("evento", new EventoClimatico());
        return "cad_evento_climatico";
    }

    @PostMapping("/salvar_evento")
    public String salvarEvento(@ModelAttribute EventoClimatico evento) {
        eventoService.salvarEvento(evento);
        return "redirect:/";
    }

    @GetMapping("/detalhes_evento/{id}")
    public String detalhesEvento(@PathVariable Long id, Model model) {
        model.addAttribute("evento", eventoService.buscarPorId(id));
        return "detalhes_evento";
    }

    @GetMapping("/atualizar_evento/{id}")
    public String mostrarFormAtualizacao(@PathVariable Long id, Model model) {
        model.addAttribute("evento", eventoService.buscarPorId(id));
        return "cad_evento_climatico";
    }

    @GetMapping("/remover_evento/{id}")
    public String removerEvento(@PathVariable Long id) {
        eventoService.removerEvento(id);
        return "redirect:/";
    }
    
    @GetMapping("/acesso_negado")
    public String acessoNegado() {
        return "acesso_negado";
    }
}