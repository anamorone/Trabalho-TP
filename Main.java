import java.util.*;

public class Main {

    public static void main(String[] args) {
		ArrayList<Produto> listaProduto = new ArrayList<>();
		ArrayList<Contato> listaContatos = new ArrayList<>();
		ArrayList<Carro> listaCarros = new ArrayList<>();
		ArrayList<Aluno> listaAlunos = new ArrayList<>();
		ArrayList<Livro> listaLivros = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);


		int opcaoPrograma = 0;

		while(opcaoPrograma != 8){
		System.out.println("\n--- MENU PROGRAMA ---");
		System.out.println("Escolha uma opção: \n1: Cadastro de vários alunos.\n2: Controle de estoque simples\n3: Agenda de contatos\n4: Sistema de carros\n5: Turma com média geral\n6: Cadastro e remoção de produtos\n7: Sistema de biblioteca simples\n8: Sair");
		opcaoPrograma = teclado.nextInt();
		teclado.nextLine();
		
		switch(opcaoPrograma){
			case 1: 
				System.out.println("Digite a quantidade de alunos que deseja cadastrar: ");

				int qntCase1 = teclado.nextInt();
				teclado.nextLine();

				for(int i = 1; i <= qntCase1; i++){
					System.out.println("Digite o nome do aluno " + i);
					String nomeAluno = teclado.nextLine();
					System.out.println("Digite a nota 1: ");
					double n1 = teclado.nextDouble();
					System.out.println("Digite a nota 2: ");
					double n2 = teclado.nextDouble();
					teclado.nextLine();
					listaAlunos.add(new Aluno(nomeAluno, n1, n2));
				}
			break;
			case 2: 
				System.out.println("Estoque total de produtos: \n");
				for(int i = 0; i < listaProduto.size(); i++){
					System.out.println(listaProduto.get(i).nome + ", " + listaProduto.get(i).codigo + ", R$: " + listaProduto.get(i).preco);
				}
			break;
			case 3:
				System.out.println("Digite a quantidade de pessoas que deseja adicionar na agenda de contatos: ");
				int qntCase3 = teclado.nextInt();
				teclado.nextLine();

				for(int i = 1; i <= qntCase3; i++){
					System.out.println("Digite o nome e o telefone da pessoa " + i + ": ");
					listaContatos.add(new Contato(teclado.nextLine(), teclado.nextLine()));
				}

				System.out.println("Digite um nome para verificar a existência em uma lista de contato: ");
				int count3 = 0;
				String nome = teclado.nextLine();

				for(int i = 0; i < listaContatos.size(); i++){
					if(listaContatos.get(i).nome.equals(nome)){
						System.out.println("O nome se encontra na lista de contatos.");
						count3++;
					}
				}
				if(count3 == 0){
					System.out.println("O contato não foi achado.");
				}
			break;
			case 4: 
				System.out.println("Digite a quantidade de carros que deseja cadastrar: ");
				int qntCase4 = teclado.nextInt();
				teclado.nextLine();

				for(int i = 1; i <= qntCase4; i++){
					System.out.println("Digite o modelo, o ano, e o valor do carro " + i + ": ");
					String modelo = teclado.nextLine();
					int ano = teclado.nextInt();
					double valor = teclado.nextDouble();
					teclado.nextLine();
					listaCarros.add(new Carro(modelo, ano, valor));
				}
				for(int i = 0; i < listaCarros.size(); i++){
					if(listaCarros.get(i).ano >= 2020){
						System.out.println(listaCarros.get(i).modelo + ", " + listaCarros.get(i).valor + ", e seu ano é " + listaCarros.get(i).ano);
					}
				}
			break;
			case 5: 
				double media = 0;
				double mediaGeral;
				double somaGeral = 0;

				for(int i = 0; i < listaAlunos.size(); i++){
					media = 0;
					double soma = (listaAlunos.get(i).nota1 + listaAlunos.get(i).nota2);
					media = soma / 2;
					System.out.println("A média do aluno " + listaAlunos.get(i).nome + " é: " + media);
					somaGeral += soma;
				}
				if(listaAlunos.isEmpty()){
					System.out.println("Lista não contém alunos.");
				}else{
					mediaGeral = somaGeral / (listaAlunos.size() * 2);
					System.out.println("A média geral da turma é: " + mediaGeral);
				}
			
			break;
			case 6:
					
					int opcao6 = 0;

					while(opcao6 != 3){
					System.out.println("Digite a opção desejada:\n1: Cadastrar produto\n2: Remover produto\n3: Sair");
					opcao6 = teclado.nextInt();
					teclado.nextLine();
					switch(opcao6){
					
					case 1:
						System.out.println("Digite a quantidade de produtos que deseja cadastrar: ");
					int qntCase2 = teclado.nextInt();
					teclado.nextLine();
					for(int i = 1; i <= qntCase2; i++){
						System.out.println("Digite o nome, o codigo e o preço do produto " + i + ": ");
						String nomeProduto = teclado.nextLine();
						int codigo = teclado.nextInt();
						double preco = teclado.nextDouble();
						teclado.nextLine();

						listaProduto.add(new Produto(nomeProduto, codigo, preco));
						}
					break;
					case 2:
						System.out.println("Digite o código do produto que deseja remover: ");
						int opcao6rem = teclado.nextInt();
						teclado.nextLine();
						int count6rem = 0;

						for(int i = 0; i < listaProduto.size(); i++){
							if(listaProduto.get(i).codigo == opcao6rem){
								listaProduto.remove(i);
								System.out.println("Produto removido com sucesso.");
								i--;
								count6rem++;
							}
						}
						if(count6rem == 0){
							System.out.println("Produto não foi encontrado.");
						}
					break;
					case 3:
						System.out.println("Encerrando o programa...");
						break;
					default:
						System.out.println("Erro. tente novamente.");
						break;
					}
				}
				break;
				case 7:
					int opcao7 = 0;

					while(opcao7 != 5){

						System.out.println("Escolha uma opção: \n1: Cadastrar livro.\n2: Listar livros.\n3: Emprestar livro.\n4: Devolver livro.\n5: Sair");
						opcao7 = teclado.nextInt();
						teclado.nextLine();

						switch(opcao7){
						case 1:
						System.out.println("Digite a quantidade de livros que deseja cadastrar: ");
						int qnt = teclado.nextInt();
						teclado.nextLine();

						for(int i = 1; i <= qnt; i++){
						System.out.println("Digite o título e autor do livro " + i);
						listaLivros.add(new Livro(teclado.nextLine(), teclado.nextLine()));
						}
						break;
						case 2:
				
						if(listaLivros.size() == 0){
						System.out.println("Não existem livros armazenados.");
						}else{
						for(int i = 0; i < listaLivros.size(); i++){
							if(listaLivros.get(i).emprestado == false){
								System.out.println("Livro " + listaLivros.get(i).titulo + ", autor: " + listaLivros.get(i).autor + ", situação: Disponível.");
							}else {
								System.out.println("Livro " + listaLivros.get(i).titulo + ", autor: " + listaLivros.get(i).autor + ", situação: Emprestado.");
							}
							
						}
						}
						break;
						case 3: 
							System.out.println("Digite o título e autor do livro que deseja emprestar: ");
							String nomeEmprestarTitulo = teclado.nextLine();
							String nomeEmprestarAutor = teclado.nextLine();
							int count = 0;

							for(int i = 0; i < listaLivros.size(); i++){
							if((listaLivros.get(i).titulo).equals(nomeEmprestarTitulo) && (listaLivros.get(i).autor).equals(nomeEmprestarAutor)){
							listaLivros.get(i).emprestado = true;
							System.out.println("Livro emprestado com sucesso.");
							count++;

							}
							}
							if(count == 0){
							System.out.println("Livro não encontrado. Por favor, tente novamente.");
							}

						break;
						case 4:
							System.out.println("Digite o título e autor do livro que deseja devolver: ");
							String nomeDevolverTitulo = teclado.nextLine();
							String nomeDevolverAutor = teclado.nextLine();
							for(int i = 0; i < listaLivros.size(); i++){
							if((listaLivros.get(i).titulo).equals(nomeDevolverTitulo) && (listaLivros.get(i).autor).equals(nomeDevolverAutor)){
							listaLivros.get(i).emprestado = false;
							System.out.println("Livro devolvido com sucesso.");
							}
							}
						break;
					case 5:
					break;
			
					default:
					System.out.println("Por favor, selecione alguma opção informada.");

					}
				}

				}

			}
			}


		}
