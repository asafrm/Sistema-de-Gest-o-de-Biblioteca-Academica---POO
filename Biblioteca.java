import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {

        //Scanner para ler o que for digitado pelo usuário
        Scanner sc = new Scanner(System.in); //unico Scanner

        ArrayList<Livro> livros = new ArrayList<>();

        Servicos servicos = new Servicos(sc);

        //Laço de repetição
        boolean parar = false;
        do{
            int opcao = servicos.opcao();
            switch(opcao){

                //cadastro de livros
                case 1:
                    int isbn = sc.nextInt();
                    livros.add(servicos.adicionarLivro(isbn));
                    break;

                //listagem de livros
                case 2:
                    servicos.listarLivros(livros);
                    break;

                //exclusao de livros
                case 3:
                    System.out.println("Digite o ISBN do livro que deseja excluir: ");
                    isbn = sc.nextInt();
                    servicos.excluirLivro(livros, isbn);
                    break;

                //emprestimo de livros
                case 4:
                    System.out.println("Digite o ISBN do livro que deseja realizar um empréstimo: ");
                    isbn = sc.nextInt();
                    servicos.emprestarLivro(livros, isbn);
                    break;

                //devolucao de livros
                case 5:
                    System.out.println("Digite o ISBN do livro que deseja devolver: ");
                    isbn = sc.nextInt();
                    servicos.devolverLivro(livros, isbn);
                    break;

                //função para encerrar o loop
                case 0:
                    parar = true;
                    System.out.println("Sistema finalizado com sucesso!");
                    break;
            }
        }while(!parar);
    }
}
