package it.polito.tdp.poweroutages.model;

import java.time.LocalDateTime;

public class Outages {

	private int anno;
	private LocalDateTime inizio;
	private LocalDateTime fine;
	private int tag_id;
	private int persone;

	public Outages(int anno, LocalDateTime inizio, LocalDateTime fine, int tag_id, int persone) {
		super();
		this.anno = anno;
		this.inizio = inizio;
		this.fine = fine;
		this.tag_id = tag_id;
		this.persone = persone;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public LocalDateTime getInizio() {
		return inizio;
	}

	public void setInizio(LocalDateTime inizio) {
		this.inizio = inizio;
	}

	public LocalDateTime getFine() {
		return fine;
	}

	public void setFine(LocalDateTime fine) {
		this.fine = fine;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public int getPersone() {
		return persone;
	}

	public void setPersone(int persone) {
		this.persone = persone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		result = prime * result + ((fine == null) ? 0 : fine.hashCode());
		result = prime * result + ((inizio == null) ? 0 : inizio.hashCode());
		result = prime * result + tag_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Outages other = (Outages) obj;
		if (anno != other.anno)
			return false;
		if (fine == null) {
			if (other.fine != null)
				return false;
		} else if (!fine.equals(other.fine))
			return false;
		if (inizio == null) {
			if (other.inizio != null)
				return false;
		} else if (!inizio.equals(other.inizio))
			return false;
		if (tag_id != other.tag_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return anno + " " + inizio + " " + fine + " " + tag_id + " " + persone + "\n";
	}

}
