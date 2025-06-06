package br.com.fiap.projeto_sosclima.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projeto_sosclima.model.Evento;
import br.com.fiap.projeto_sosclima.respository.EventoRepository;

@RestController
@RequestMapping(value = "/evento")
public class EventoController {
	
	@Autowired
	private EventoRepository repE;
	
	@GetMapping(value = "/todas")
	public List<Evento> retornaTodosEventos() {		
		return repE.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Evento buscaPorID(@PathVariable Long id) {

		Optional<Evento> op = repE.findById(id);
		
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping(value = "/inserir")
	public Evento inserirEvento(@RequestBody Evento evento) {
		repE.save(evento);
		
		
		return evento;
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public Evento atualizarEvento(@RequestBody Evento evento, @PathVariable Long id) {

		Optional<Evento> op = repE.findById(id);

		if (op.isPresent()) {

			Evento evento_atual = op.get();

			evento_atual.setTipo(evento.getTipo());
			evento_atual.setNivel(evento.getNivel());
			

			repE.save(evento_atual);

			return evento_atual;

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping(value = "/remover/{id}")
	public Evento removerEvento(@PathVariable Long id) {

		Optional<Evento> op = repE.findById(id);

		if (op.isPresent()) {

			Evento evento = op.get();
			repE.delete(evento);
			return evento;

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}
	
	
}
