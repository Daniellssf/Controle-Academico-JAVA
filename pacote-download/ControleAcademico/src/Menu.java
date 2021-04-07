import java.util.Scanner;
import java.util.stream.Stream;

public class Menu {

	private Scanner scanner;
	private AlunoRepository alunoRepository;
	private ProfessorRepository professorRepository;

	public Menu() {
		scanner = new Scanner(System.in);
		alunoRepository = new AlunoRepository();
		professorRepository = new ProfessorRepository();
	}

	public void mostrarMenu() {
		System.out.println("*****************************************");
		System.out.println("*Programa de Registro Acadêmico de Notas*");
		System.out.println("*****************************************");
		System.out.println("[1] Cadastrar as notas de um novo aluno.");
		System.out.println("[2] Consultar situação de um aluno.");
		System.out.println("[3] Consultar notas da turma.");
		System.out.println("[4] Cadastrar um professor e seu grau de formação.");
		System.out.println("[5] Consultar professor.");
		System.out.println("[6] Sair.");
	}

	public int lerOpcao() {
		System.out.print("# Digite a opção: ");
		String opcaoString = scanner.next();
		
		try {
			int opcao = Integer.parseInt(opcaoString);
			return opcao;
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public void cadastrarNotasAluno() throws ArrayCheioException {
		System.out.println("***Opção 1 selecionada***");
		String nome = "";
		System.out.print("---> Informe o nome completo do aluno (Primeiro Nome) (Nome do meio) (Nome final): ");
		while(("").equals(nome)) {
			nome=scanner.nextLine();
		} 
		
		System.out.print("---> Informe a nota av1 do aluno: ");
		String av1String = scanner.next();
		av1String = av1String.replace(",", ".");
		System.out.print("---> Informe a nota av2 do aluno: ");
		String av2String = scanner.next();
		av2String = av2String.replace(",", ".");
		System.out.println(" ");
		
		try {
			
			String[] nomeArray;
			nomeArray = nome.split("\\s+");
			
			String primeiroNome = nomeArray[0];
			String segundoNome = nomeArray[1];
			String terceiroNome = nomeArray[2];
			
			StringBuilder nomeCompleto = new StringBuilder();
			nomeCompleto.append(primeiroNome);
			nomeCompleto.append(" " + segundoNome);
			nomeCompleto.append(" " + terceiroNome);
			
			Double av1 = Double.parseDouble(av1String);
			Double av2 = Double.parseDouble(av2String);
			
			alunoRepository.salvar(nome, av1, av2);
			System.out.println(" ");
			System.out.println("---------Notas do Aluno "+ nomeCompleto + " de sobrenome " + terceiroNome + " tendo como nome do meio " + segundoNome +
								" e primeiro nome " + primeiroNome + " foram salvas com sucesso.---------");
			System.out.println(" ");
		} catch (NomeInvalidoException e) {
			System.err.println(e.getMessage());
		} catch (ArrayCheioException e) {
			System.err.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println("Nota INVÁLIDA. Insira uma nota Válida.");
			System.out.println(" ");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(" ");
			System.err.println("Digite um nome no formato (Primeiro Nome) (Nome do Meio) (Ultimo nome).");
			System.out.println(" ");
		}
	}
	
	public void consultarBoletim() {
		System.out.println("***Opção 2 selecionada***");
		System.out.print("---> Consultar Boletim. Digite o nome do aluno: ");
		String nome = scanner.next();
		System.out.println(" ");
		
		try {
			alunoRepository.pesquisaAlunos(nome);
		} catch (NullPointerException e) {
			System.err.println("Não existem Alunos cadastrados ainda.");
			System.out.println(" ");
		}
	}
	
	public void listarAlunos() {
		System.out.println("***Opção 3 selecionada***");
		System.out.println(" ");
		System.out.println("---> Listando notas da TURMA <---");
		System.out.println(" ");
		Aluno[] alunos = alunoRepository.Listar();

		for (int i = 0; i < alunos.length; i++) {
			Aluno aluno = alunos[i];
			if (aluno != null) {
				System.out.println(aluno.toString());
				System.out.println(" ");
			}
		}
	}
	
	private void consultarProfessor() {
		System.out.println("***Opção 5 selecionada***");
		System.out.print("---> Consultar Professor. Digite o nome do professor: ");
		String nome = scanner.next();
		System.out.println(" ");
		try {
			professorRepository.pesquisaAProfessor(nome);
		} catch (NullPointerException e) {
			System.err.println("Não existem Professores cadastrados ainda.");
			System.out.println(" ");
		}
				
	}

	private void cadastrarProfessor() throws ArrayCheioException, GrauInvalidoException {
		
		System.out.println("***Opção 4 selecionada***");
		String nome = "";
		System.out.print("---> Informe o nome completo do professor (Primeiro Nome) (Nome do meio) (Nome final): ");
		while(("").equals(nome)) {
			nome=scanner.nextLine();
		} 
		
		System.out.print("---> Informe o grau acadêmico do professor. Ex.: Doutor, Mestre, Bacharel, Licenciatura, Tecnologo e etc: ");
		String grau = scanner.next();
			
		try {
			String[] nomeArray;
			nomeArray = nome.split("\\s+");
			
			String primeiroNome = nomeArray[0];
			String segundoNome = nomeArray[1];
			String terceiroNome = nomeArray[2];
			
			StringBuilder nomeCompleto = new StringBuilder();
			nomeCompleto.append(primeiroNome);
			nomeCompleto.append(" " + segundoNome);
			nomeCompleto.append(" " + terceiroNome);
			
			professorRepository.salvarProfessor(nome, grau);
			System.out.println(" ");
			System.out.println("---------Professor " + nomeCompleto + " de sobrenome " + terceiroNome + " tendo como nome do meio "
								+ segundoNome +	" e primeiro nome " + primeiroNome + " foi salvo com sucesso.---------");
			System.out.println(" ");
		} catch (NomeInvalidoException e) {
			System.out.println(" ");
			System.err.println(e.getMessage());
			System.out.println(" ");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(" ");
			System.err.println("Digite um nome no formato (Primeiro Nome) (Nome do Meio) (Ultimo nome).");
			System.out.println(" ");
		} catch (ArrayCheioException e) {
			System.out.println(" ");
		} catch (GrauInvalidoException e) {
			System.out.println(" ");
		}
	}
	
	public void selecionarOpcao() throws ArrayCheioException, GrauInvalidoException {
		mostrarMenu();
		int opcao = lerOpcao();
		while (opcao != 6) {
			switch (opcao) {
			case 1: 
				cadastrarNotasAluno();
				break;
			case 2:
				consultarBoletim();
				break;
			case 3:
				listarAlunos();
				break;
			case 4:
				cadastrarProfessor();
				break;
			case 5:
				consultarProfessor();
				break;
			default:
				System.out.println(" ");
				System.err.println("Opção inválida! A OPÇÃO correta deve ser escolhida entre os"
						+ " numeros 1 e 6.");
				System.out.println(" ");
				break;
			}	
			mostrarMenu();
			opcao = lerOpcao();
		}
	}
	
	public static void main(String[] args) throws ArrayCheioException, GrauInvalidoException {
		
		Menu menu = new Menu();
		menu.selecionarOpcao();
	}
}
