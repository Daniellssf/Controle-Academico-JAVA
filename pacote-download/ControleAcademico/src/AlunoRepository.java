public class AlunoRepository {
	
	private Aluno[] alunos;
	private int posicaoArray;
	
	public AlunoRepository() {
		alunos = new Aluno[5];
		posicaoArray = 0;
	}
	
	public Aluno[] Listar() {
		return this.alunos;
	}
	
	public void salvar(String nome, Double av1, Double av2) 
			throws NomeInvalidoException, ArrayCheioException {
		
		if (nome == null || nome.trim().length() <= 3) {
			NomeInvalidoException alunoInvalidoExcepetion = new NomeInvalidoException(nome);
			throw alunoInvalidoExcepetion; 
		}

		try {
			Aluno aluno = new Aluno(nome, av1, av2);
			alunos[posicaoArray] = aluno;
			posicaoArray++;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayCheioException();
		}
	}
	
	public Aluno pesquisaAlunos(String nome) {
		for (Aluno aluno : alunos) {
			
			String nomeAlunoMaiusculo = aluno.getNome().toUpperCase();
			String nomeMaiusculo = nome.toUpperCase();
			
			if (aluno != null && nomeAlunoMaiusculo.contains(nomeMaiusculo)) {
				
				double nota1 = aluno.getAv1();
				double nota2 = aluno.getAv2();
				double media = (nota1 + nota2) / 2;
				System.out.println(aluno.toString()); 
				
				System.out.println(" ");
				if (media < 4) {
					System.out.println("A média do aluno é: " + media + " | Situação do aluno é: REPROVADO!");
					System.out.println(" ");
				} else if (media >= 4 && media <= 7) {
					System.out.println("A média do aluno é: " + media + " | Situação do aluno é: PROVA FINAL.");
					System.out.println(" ");
				} else {
					System.out.println("A média do aluno é: " + media + " | Situação do aluno é: APROVADO!!!");
					System.out.println(" ");
				}
				return aluno;
			}
		}
		System.err.println("O Aluno " + nome + " não está na nossa base de dados de Alunos cadastrados.");
		System.out.println(" ");
		return null;
	}
}