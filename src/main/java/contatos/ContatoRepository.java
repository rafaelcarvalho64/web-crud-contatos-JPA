package contatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
	List<Contato> findByNome(String nome);}
