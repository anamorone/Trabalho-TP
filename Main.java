import java.util.*;

public class Main {

    public static void main(String[] args) {
		ArrayList<Produto> listaProduto = new ArrayList<>();
		ArrayList<Contato> listaContatos = new ArrayList<>();
		ArrayList<Carro> listaCarros = new ArrayList<>();
		ArrayList<Aluno> listaAlunos = new ArrayList<>();
		ArrayList<Livro> listaLivros = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);


		System.out.println("Escolha uma opção: \n1: Cadastrar livro.\n2: Listar livros.\n3: Emprestar livro.\n4: Devolver livro.\n5: Sair");
		int opcao = teclado.nextInt();

		switch(opcao){
			case 1:
				System.out.println("Digite a quantidade de livros que deseja cadastrar: ");
				int qnt = teclado.nextInt();

				for(int i = 1; i <= qnt; i++){
					System.out.println("Digite o título e autor do livro " + i);
					listaLivros.add(new Livro(teclado.next(), teclado.next()));
				}
					break;
			case 2:
				for(int i = 0; i < listaLivros.size(); i++){
					if(listaLivros.size() == 0){
						System.out.println("Não existem livros armazenados.");
					}else if(listaLivros.get(i).emprestado = false) {
					System.out.println("Livro " + listaLivros.get(i).titulo + ", autor: " + listaLivros.get(i).autor + ", situação: Disponível.");
					}else if(listaLivros.get(i).emprestado = true){
					System.out.println("Livro " + listaLivros.get(i).titulo + ", autor: " + listaLivros.get(i).autor + ", situação: Emprestado.");
					}
				}
					break;
			case 3: 
				System.out.println("Digite o título e autor do livro que deseja emprestar: ");
				String nomeEmprestarTitulo = teclado.next();
				String nomeEmprestarAutor = teclado.next();
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
				String nomeDevolverTitulo = teclado.next();
				String nomeDevolverAutor = teclado.next();
				listaLivros.add(new Livro(nomeDevolverTitulo, nomeDevolverAutor));
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
				break;

				}
		}

	}
