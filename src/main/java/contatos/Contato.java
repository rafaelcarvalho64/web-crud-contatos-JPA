package contatos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue
	private Long id;
    private String nome;
    private String fone;
    private String email;
    
	public Contato() {
		super();
	}
	public Contato(Long id, String nome, String fone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}
	public Contato(String nome, String fone, String email) {
		super();
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
