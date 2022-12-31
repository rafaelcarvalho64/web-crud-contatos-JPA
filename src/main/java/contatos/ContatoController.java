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
		ModelAndView modelAndView = new ModelAndView("contatos.html");
		try {
			if (nome != null && nome != "") {
				List<Contato> lista = repository.findByNome(nome);
				try {
					Optional<Contato> data = repository.findById(Long.parseLong(nome));
			    	Contato a = data.get();
			    	lista.add(a);
				} catch (Exception e) {}
		        modelAndView.addObject("contatos", lista);
			}else {
				List<Contato> lista = repository.findAll();
		        modelAndView.addObject("contatos", lista);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return modelAndView;
	}
	
	@PostMapping("/contatos")
	public RedirectView saveContato(Contato contato) {
		  try {
			  repository.save(contato);
		} catch (Exception e) {}
		  return new RedirectView("/contatos", true);
	}
	    
	@GetMapping("/contatos/update")
	public RedirectView updateContato(Contato contato) {
		try {
			Optional<Contato> data = repository.findById(contato.getId());
	    	Contato a = data.get();
		      a.setNome(contato.getNome());
		      a.setFone(contato.getFone());
		      a.setEmail(contato.getEmail());
		      repository.save(a);	
		} catch (Exception e) {}
	      return new RedirectView("/contatos", true);
	}
	
	@GetMapping("/contatos/delete")
	public RedirectView deleteContato(Contato contato) {
		try {
			repository.deleteById(contato.getId());
		} catch (Exception e) {}
		return new RedirectView("/contatos", true);
	}	
}