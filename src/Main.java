import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Aluno> alunos = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();

		int opcao;
		do {
			System.out.println("Menu:");
			System.out.println("1 - Cadastrar Aluno");
			System.out.println("2 - Realizar Venda");
			System.out.println("3 - Visualizar Vendas");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine(); 

			if (opcao == 1) {
				System.out.print("Digite o nome do aluno: ");
				String nomeAluno = scanner.nextLine();
				System.out.print("Digite o número de matrícula do aluno: ");
				int matriculaAluno = scanner.nextInt();
				scanner.nextLine(); 
				Aluno aluno = new Aluno(nomeAluno, matriculaAluno);
				alunos.add(aluno);
				System.out.println("Aluno cadastrado com sucesso!");
			} else if (opcao == 2) {
				System.out.print("Digite o número de matrícula do aluno: ");
				int matriculaVenda = scanner.nextInt();
				scanner.nextLine(); 
				Aluno alunoVenda = null;
				for (Aluno a : alunos) {
					if (a.getMatricula() == matriculaVenda) {
						alunoVenda = a;
						break;
					}
				}
				if (alunoVenda == null) {
					System.out.println("Aluno não encontrado.");
				} else {
					List<CachorroQuente> cachorrosQuentesVenda = new ArrayList<>();
					while (true) {
						System.out.println(
								"Escolha a proteína do cachorro-quente (salsicha, linguiça, frango ou bacon): ");
						String proteina = scanner.nextLine();
						System.out.println(
								"Escolha o queijo do cachorro-quente (mussarela, prato, parmesão ou coalho): ");
						String queijo = scanner.nextLine();
						List<String> ingredientesAdicionais = new ArrayList<>();
						System.out.println("Deseja adicionar maionese? (S/N): ");
						if (scanner.nextLine().equalsIgnoreCase("S")) {
							ingredientesAdicionais.add("maionese");
						}
						System.out.println("Deseja adicionar ketchup? (S/N): ");
						if (scanner.nextLine().equalsIgnoreCase("S")) {
							ingredientesAdicionais.add("ketchup");
						}
						System.out.println("Deseja adicionar ovo? (S/N): ");
						if (scanner.nextLine().equalsIgnoreCase("S")) {
							ingredientesAdicionais.add("ovo");
						}
						System.out.println("Deseja adicionar batata palha? (S/N): ");
						if (scanner.nextLine().equalsIgnoreCase("S")) {
							ingredientesAdicionais.add("batata palha");
						}
						System.out.println("Escolha a bebida (Coca-cola, Del Rio ou Suco do Chaves): ");
						String bebida = scanner.nextLine();

						CachorroQuente cachorroQuente = new CachorroQuente(proteina, queijo, ingredientesAdicionais,
								bebida);
						cachorrosQuentesVenda.add(cachorroQuente);

						System.out.println("Deseja adicionar mais um cachorro-quente? (S/N): ");
						if (!scanner.nextLine().equalsIgnoreCase("S")) {
							break;
						}
					}

					Venda venda = new Venda(alunoVenda);
					for (CachorroQuente cq : cachorrosQuentesVenda) {
						venda.adicionarCachorroQuente(cq);
					}
					vendas.add(venda);

					System.out.println("Venda registrada com sucesso!");
				}
			} else if (opcao == 3) {
				System.out.println("Lista de vendas:");
				for (Venda v : vendas) {
					Aluno vendidoPara = v.getAluno();
					System.out.println(
							"Aluno: " + vendidoPara.getNome() + " (Matrícula: " + vendidoPara.getMatricula() + ")");
					List<CachorroQuente> cachorrosVendidos = v.getCachorrosQuentes();
					for (int i = 0; i < cachorrosVendidos.size(); i++) {
						CachorroQuente cq = cachorrosVendidos.get(i);
						System.out.println("Cachorro-Quente " + (i + 1) + ":");
						System.out.println("Proteína: " + cq.getProteina());
						System.out.println("Queijo: " + cq.getQueijo());
						System.out.println("Ingredientes adicionais: " + cq.getIngredientesAdicionais());
						System.out.println("Bebida: " + cq.getBebida());
					}
					System.out.println("------------------------");
				}
			} else if (opcao == 4) {
				System.out.println("Encerrando o programa.");
			} else {
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao != 4);

		scanner.close();
	}
}