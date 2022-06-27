package codiceFiscale;

public class Identity {
	private String cognome;
	private String nome;
	private String dataNascita;
	private String luogoNascita;
	private String gender;

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognomeSetted) {
		this.cognome = cognomeSetted;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeSetted) {
		this.nome = nomeSetted;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascitaSetted) {
		this.dataNascita = dataNascitaSetted;
	}

}
