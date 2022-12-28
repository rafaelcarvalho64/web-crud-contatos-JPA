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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
@RestController
public class ContatoController {

	@Autowired
	ContatoRepository repository;

	@GetMapping("/contatos")
	public ModelAndView getAllContatos(String nome) {
		if (nome != null && nome != "") {
			List<Contato> lista = repository.findByNome(nome);
			ModelAndView modelAndView = new ModelAndView("contatos.html");
	        modelAndView.addObject("contatos", lista);
	        return modelAndView;
		}else {
			List<Contato> lista = repository.findAll();
			ModelAndView modelAndView = new ModelAndView("contatos.html");
	        modelAndView.addObject("contatos", lista);
	        return modelAndView;
		}
	}
	
	@PostMapping("/contatos")
	public RedirectView saveContato(Contato contato) {
		  repository.save(contato);
		  return new RedirectView("/contatos", true);
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