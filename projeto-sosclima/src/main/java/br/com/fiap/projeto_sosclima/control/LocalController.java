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

import br.com.fiap.projeto_sosclima.model.Local;
import br.com.fiap.projeto_sosclima.respository.LocalRepository;

@RestController
@RequestMapping(value = "/local")
public class LocalController {

	@Autowired
	private LocalRepository repL;
	
	@GetMapping(value = "/todas")
	public List<Local> retornaTodosLocais() {		
		return repL.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Local buscaPorID(@PathVariable Long id) {

		Optional<Local> op = repL.findById(id);
		
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping(value = "/inserir")
	public Local inserirLocal(@RequestBody Local local) {
		repL.save(local);
		
		
		return local;
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public Local atualizarLocal(@RequestBody Local local, @PathVariable Long id) {

		Optional<Local> op = repL.findById(id);

		if (op.isPresent()) {

			Local local_atual = op.get();

			local_atual.setCidade(local.getCidade());
			local_atual.setPais(local.getPais());
			

			repL.save(local_atual);

			return local_atual;

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping(value = "/remover/{id}")
	public Local removerLocal(@PathVariable Long id) {

		Optional<Local> op = repL.findById(id);

		if (op.isPresent()) {

			Local local = op.get();
			repL.delete(local);
			return local;

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}
	
}
