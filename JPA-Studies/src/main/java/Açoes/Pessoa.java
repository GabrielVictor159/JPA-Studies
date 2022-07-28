package Açoes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	Com o SequenceGenerator podemos definir param�tros para o auto incremente no padr�o sequence
	@SequenceGenerator(name = "PessoaGenerator", 
	sequenceName = "Pessoa_SEQ", 
//	Aqui vamos colocar o primeiro valor da sequencia
	initialValue = 1, 
//	aqui definimos o tamanho da sequencia
	allocationSize = 100)
//	No GeneratedValue temos que identificar a estrategia temos IDENTITY, SEQUENCE E TABLE, se n�o colocamos nada ficara como AUTO (podemos declarar AUTO tamb�m)
//	No tipo AUTO o jpa decidira a melhor estrategia
//	No tipo IDENTITY utilizamos colunas com valores autoincrement�veis, alguns banco de dados n�o teram suporte
//	No tipo SEQUENCE utilizamos uma sequencia global, todas as tabelas compartilhar�o uma mesma sequ�ncia

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "nomecompleto", nullable = false)
	private String nome;
	private String email;
	@ManyToOne
	@JoinColumn(name = "Endereco_Id")
	private Endereco endereco;
	@Transient
	private int naoserapersistido;

	public Pessoa() {

	}
	

	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}

}
