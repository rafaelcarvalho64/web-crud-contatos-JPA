package contatos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContatoController {

	@Autowired
	ContatoRepository repository;

	@GetMapping("/contato/{id}")
	public Contato getContatoById(@PathVariable Long id) {
		return repository.findById(id).get();
	}

	@GetMapping("/contato")
	public List<Contato> getAllContatos() {
		return repository.findAll();
	}


	@PostMapping("/contato")
	public Contato saveContato(@RequestBody Contato contato) {
		return repository.save(contato);
	}

	@DeleteMapping("/contato/{id}")
	public void deleteContato(@PathVariable Long id) {
		repository.deleteById(id);
	}

	    
	@PutMapping("/contato/{id}")
	public Contato updateAluno(@PathVariable long id, @RequestBody Contato contato) {
		Optional<Contato> data = repository.findById(id);
	    	Contato a = data.get();
	      a.setNome(contato.getNome());
	      a.setFone(contato.getFone());
	      a.setEMail(contato.getEMail());
	      return repository.save(a);	   
	}
}