public class Professor extends Pessoa{
	
	String grau;
	
	public Professor(String nome, String grau) {
		setNome(nome);
		setGrau(grau);
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}
	
}
