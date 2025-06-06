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

import br.com.fiap.projeto_sosclima.model.Recomendacao;
import br.com.fiap.projeto_sosclima.respository.RecomendacaoRepository;

@RestController
@RequestMapping(value = "/recomendacao")
public class RecomendacaoController {

	@Autowired
	private RecomendacaoRepository repR;

	@GetMapping(value = "/todas")
	public List<Recomendacao> retornaTodasRecomendacoes() {		
		return repR.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Recomendacao buscaPorID(@PathVariable Long id) {

		Optional<Recomendacao> op = repR.findById(id);
		
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping(value = "/inserir")
	public Recomendacao inserirRecomendacao(@RequestBody Recomendacao recomendacao) {
		repR.save(recomendacao);
		
		
		return recomendacao;
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public Recomendacao atualizarRecomendacao(@RequestBody Recomendacao recomendacao, @PathVariable Long id) {

		Optional<Recomendacao> op = repR.findById(id);

		if (op.isPresent()) {

			Recomendacao recomendacao_atual = op.get();

			recomendacao_atual.setDescricao(recomendacao.getDescricao());
			

			repR.save(recomendacao_atual);

			return recomendacao_atual;

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping(value = "/remover/{id}")
	public Recomendacao removerRecomendacao(@PathVariable Long id) {

		Optional<Recomendacao> op = repR.findById(id);

		if (op.isPresent()) {

			Recomendacao recomendacao = op.get();
			repR.delete(recomendacao);
			return recomendacao;

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}
	
}
