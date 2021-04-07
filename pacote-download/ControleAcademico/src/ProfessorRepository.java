public class ProfessorRepository {
	
	private Professor[] professores;
	private int posicaoArray;
	
	public ProfessorRepository() {
		professores = new Professor[3];
		posicaoArray = 0;
	}
	
	public Professor[] ListarProfessor() {
		return this.professores;
	}
	
	public void salvarProfessor(String nome, String grau) 
			throws NomeInvalidoException, ArrayCheioException, GrauInvalidoException {
		
		if (nome == null || nome.trim().length() <= 3 || nome.isEmpty() ) {
			NomeInvalidoException nomeInvalidoException = new NomeInvalidoException(nome);
			throw nomeInvalidoException; 
		}
		
		if (grau == null || grau.trim().length() < 3 || grau.isEmpty()) {
			GrauInvalidoException grauInvalidoException = new GrauInvalidoException();
			throw grauInvalidoException;
		}

		try {
			Professor professor = new Professor(nome, grau);
			professores[posicaoArray] = professor;
			posicaoArray++;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayCheioException();
		}
	}
	
	public Professor pesquisaAProfessor(String nome) {
		for (Professor professor: professores) {

			String nomeAlunoMaiusculo = professor.getNome().toUpperCase();
			String nomeMaiusculo = nome.toUpperCase();
			
			if(professor != null && nomeAlunoMaiusculo.contains(nomeMaiusculo)) {
				String nomeDoProfessor = professor.getNome();
				System.out.println("Nome: " + nomeDoProfessor + " | Seu Grau de formação é : " + professor.getGrau());
				System.out.println(" ");
			return professor;
			} 
		}
		System.err.println("O nome do professor " + nome + " não está na nossa base de dados de Professores cadastrados.");
		System.out.println(" ");
		return null;
	}
	
}
