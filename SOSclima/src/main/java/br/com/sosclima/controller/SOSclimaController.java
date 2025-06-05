package br.com.sosclima.controller;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.sosclima.model.Evento;
import br.com.sosclima.repository.EventoRepository;
import br.com.sosclima.repository.LocalRepository;
import br.com.sosclima.repository.RecomendacaoRepository;

@Controller
public class SOSclimaController {

    private final EventoRepository eventoRepository;
    private final LocalRepository localRepository;
    private final RecomendacaoRepository recomendacaoRepository;

    public SOSclimaController(EventoRepository eventoRepository,
                              LocalRepository localRepository,
                              RecomendacaoRepository recomendacaoRepository) {
        this.eventoRepository = eventoRepository;
        this.localRepository = localRepository;
        this.recomendacaoRepository = recomendacaoRepository;
    }

    @GetMapping("/")
    public String index(Model model, Authentication authentication) {
        String nomeUsuario = authentication.getName();
        
        List<Evento> eventos = eventoRepository.findAllComRelacionamentos();
        
        model.addAttribute("nome_usuario", nomeUsuario);
        model.addAttribute("eventos", eventos);
        return "index";
    }

    @GetMapping("/cad_evento_climatico")
    public String formCadastroEvento(Model model) {
        model.addAttribute("evento", new Evento());
        return "cad_evento_climatico";
    }

    @PostMapping("/salvar_evento")
    public String salvarEvento(@ModelAttribute Evento evento) {
        // Salvar entidades relacionadas primeiro
        localRepository.save(evento.getLocal());
        recomendacaoRepository.save(evento.getRecomendacao());
        
        // Salvar o evento com as relações
        eventoRepository.save(evento);
        return "redirect:/";
    }

    // Outros métodos permanecem similares, ajustados para o novo modelo
    @GetMapping("/detalhes_evento/{id}")
    public String detalhesEvento(@PathVariable Long id, Model model) {
        Evento evento = eventoRepository.findByIdComRelacionamentos(id)
            .orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("evento", evento);
        return "detalhes_evento";
    }

    @GetMapping("/atualizar_evento/{id}")
    public String formAtualizarEvento(@PathVariable Long id, Model model) {
        Evento evento = eventoRepository.findByIdComRelacionamentos(id)
            .orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("evento", evento);
        return "atualizar_evento";
    }

    @GetMapping("/remover_evento/{id}")
    public String removerEvento(@PathVariable Long id) {
        Evento evento = eventoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        
        eventoRepository.delete(evento);
        return "redirect:/";
    }

    @GetMapping("/acesso_negado")
    public String acessoNegado() {
        return "acesso_negado";
    }
}