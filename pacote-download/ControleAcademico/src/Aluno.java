public class Aluno extends Pessoa{

	private Double av1;
	private Double av2;
	
	public Aluno() {
		
	}
	
	public Aluno (String nome, Double av1, Double av2) {
		setNome(nome);
		setAv1(av1);
		setAv2(av2);
	}
		

	public Double getAv1() {
		return av1;
	}

	public void setAv1(Double av1) {
		this.av1 = av1;
	}

	public Double getAv2() {
		return av2;
	}

	public void setAv2(Double av2) {
		this.av2 = av2;
	}
		
	@Override
	public String toString() {
		return "Nome: " + nome + " | Nota da AV1: " + av1 + " | Nota da AV2: " + av2 + " | Média do aluno é: " + ((av1+av2)/2);
	}
}