import java.util.*;

public class Main {

    public static void main(String[] args) {
		ArrayList<Produto> listaProduto = new ArrayList<>();
		ArrayList<Contato> listaContatos = new ArrayList<>();
		ArrayList<Carro> listaCarros = new ArrayList<>();
		ArrayList<Aluno> listaAlunos = new ArrayList<>();
		ArrayList<Livro> listaLivros = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);


		System.out.println("Digite a quantidade de produtos que deseja cadastrar: ");
		int qnt = teclado.nextInt();

		for(int i = 1; i <= qnt; i++){
			System.out.println("Digite o nome, codigo e preço do item " + i + ": ");
			listaProduto.add(new Produto(teclado.next(), teclado.nextInt(), teclado.nextDouble()));

		}

		System.out.println("Insira o código do produto que deseja remover da lista de cadastro: ");
		int codigo = teclado.nextInt();
		int countRem = 0;

		for(int i = 0; i < listaProduto.size(); i++){
			
			if(listaProduto.get(i).codigo == codigo){
				listaProduto.remove(i);
				System.out.println("O produto " + i + " foi removido com sucesso");
				countRem++;
				break;
		}
	
		}

		if(countRem == 0){
				System.out.println("O código " + codigo + " não pertence a nenhum produto cadastrado na lista.");
			}

		for(int i = 0; i < listaProduto.size(); i++){
			System.out.println("nome do produto: " + listaProduto.get(i).nome + ", código: " + listaProduto.get(i).codigo + ", preço: R$:" + listaProduto.get(i).preco);
		}

	}
}