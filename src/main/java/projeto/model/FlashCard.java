package projeto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="flashcards")
public class FlashCard implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String termo;
	@Column
	private String definicao;
	@Column
	private int nivelAprend;
	@Column
	private int numRepet;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRepet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTermo() {
		return termo;
	}

	public void setTermo(String termo) {
		this.termo = termo;
	}

	public String getDefinicao() {
		return definicao;
	}

	public void setDefinicao(String definicao) {
		this.definicao = definicao;
	}

	public int getNivelAprend() {
		return nivelAprend;
	}

	public void setNivelAprend(int nivelAprend) {
		this.nivelAprend = nivelAprend;
	}

	public int getNumRepet() {
		return numRepet;
	}

	public void setNumRepet(int numRepet) {
		this.numRepet = numRepet;
	}

	public Date getDataRepet() {
		return dataRepet;
	}

	public void setDataRepet(Date dataRepet) {
		this.dataRepet = dataRepet;
	}

	@Override
	public String toString() {
		return "FlashCard [id=" + id + ", termo=" + termo + ", definicao=" + definicao + ", nivelAprend=" + nivelAprend
				+ ", numRepet=" + numRepet + ", dataRepet=" + dataRepet + "]";
	}
	
	
}
