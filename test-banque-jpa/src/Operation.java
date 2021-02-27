import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */

/**
 * @author Ness'ti
 *
 */
@Entity
@Table(name = "OPERATION")
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column (name = "DATE")
	private LocalDateTime date;
	
	@Column (name = "MONTANT")
	private double montant;
	
	@Column (name = "MOTIF")
	private String motif;
	
	
	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private Compte compte;
	

	public Operation() {

	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

}
