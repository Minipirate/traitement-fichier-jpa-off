import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */

/**
 * @author Ness'ti
 *
 */

@Entity
// héritage -> 1ère méthode 
@Inheritance(strategy = InheritanceType.JOINED)

@Table(name = "COMPTE")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NUMERO")
	private int numero;

	@Column(name = "SOLDE")
	private double solde;

	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"))

	private List<Client> clients = new ArrayList<>();

	// relation OneToMany dans Compte vers Operation
	@OneToMany
	@JoinColumn(name = "compte")
	private List<Operation> operations = new ArrayList<>();

	public Compte() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}
