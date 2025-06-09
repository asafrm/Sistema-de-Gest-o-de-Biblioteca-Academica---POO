import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Livro> livros = new ArrayList<>();
    private static final List<Emprestimo> emprestimos = new ArrayList<>();
    private static final List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {

        //Laço de repetição
        boolean sair = false;
        while (!sair) {
            int op = menu();
            switch (op) {
                case 1 -> livros.add(Livro.cadastrarLivro(sc));
                case 2 -> Livro.listarLivros(livros);
                case 3 -> {
                    System.out.print("ISBN a excluir: ");
                    int isbn = Integer.parseInt(sc.nextLine());
                    Livro.excluirLivro(livros, isbn);
                }
                case 4 -> {
                    System.out.print("ISBN para empréstimo: ");
                    int isbn = Integer.parseInt(sc.nextLine());
                    Emprestimo.emprestarLivro(livros, usuarios, emprestimos, isbn, sc);
                }
                case 5 -> {
                    System.out.print("ISBN para devolução: ");
                    int isbn = Integer.parseInt(sc.nextLine());
                    Emprestimo.devolverLivro(livros, emprestimos, isbn);
                }
                case 0 -> sair = true;
                default -> System.out.println("Opção inválida.\n");
            }
        }
        sc.close();
        System.out.println("Sistema encerrado.");
    }

    /* menu principal */
    private static int menu() {
        System.out.println("""
            === MENU BIBLIOTECA ===
            [1] Cadastrar livro
            [2] Listar livros
            [3] Excluir livro
            [4] Emprestar livro
            [5] Devolver livro
            [0] Sair""");
        System.out.print("Opção: ");
        return Integer.parseInt(sc.nextLine());
    }
}