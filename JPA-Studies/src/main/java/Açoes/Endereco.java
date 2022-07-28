package Açoes;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.persistence.SequenceGenerator;
@Entity
public class Endereco {
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer idEndereco;
	@Column(nullable=false)
private String Estado;
	@Column(nullable=false)
private String Rua;
	@Column(nullable=false)
private String Numero;
	public Endereco() {
		
	}
public Integer getIdEndereco() {
	return idEndereco;
}
public void setIdEndereco(Integer idEndereco) {
	this.idEndereco = idEndereco;
}
public String getEstado() {
	return Estado;
}
public void setEstado(String estado) {
	Estado = estado;
}
public String getRua() {
	return Rua;
}
public void setRua(String rua) {
	Rua = rua;
}
public String getNumero() {
	return Numero;
}
public void setNumero(String numero) {
	Numero = numero;
}
@Override
public String toString() {
	return "Endereco [idEndereco=" + idEndereco + ", Estado=" + Estado + ", Rua=" + Rua + ", Numero=" + Numero + "]";
}

}
