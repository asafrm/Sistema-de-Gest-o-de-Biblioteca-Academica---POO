import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Livro> livros = new ArrayList<>();
    private static final List<Emprestimo> emprestimos = new ArrayList<>();
    private static final List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            int op = menuPrincipal(); // Chama o menu principal
            switch (op) {
                case 1 -> gerenciarLivros();     // Chama o submenu de livros
                case 2 -> gerenciarUsuarios();    // Chama o submenu de usuários
                case 3 -> gerenciarEmprestimos(); // Chama o submenu de empréstimos
                case 0 -> sair = true;
                default -> System.out.println("Opção inválida. Tente novamente.\n");
            }
        }
        sc.close();
        System.out.println("Sistema encerrado.");
    }
    /* Menu Principal */
    private static int menuPrincipal() {
        System.out.println("""
            \n=== MENU PRINCIPAL DA BIBLIOTECA ===
            [1] Gerenciar Livros
            [2] Gerenciar Usuários
            [3] Gerenciar Empréstimos
            [0] Sair""");
        System.out.print("Opção: ");
        return lerOpcao();
    }

    // Submenu para Gerenciamento de Livros
    private static void gerenciarLivros() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("""
                \n=== GERENCIAR LIVROS ===
                [1] Cadastrar livro
                [2] Listar livros
                [3] Excluir livro
                [0] Voltar ao Menu Principal""");
            System.out.print("Opção: ");
            int op = lerOpcao();
            switch (op) {
                case 1 -> livros.add(Livro.cadastrarLivro(sc));
                case 2 -> Livro.listarLivros(livros);
                case 3 -> {
                    System.out.print("ISBN  do livro que deseja excluir: ");
                    int isbn = Integer.parseInt(sc.nextLine());
                    Livro.excluirLivro(livros, isbn);
                }
                case 0 -> voltar = true;
                default -> System.out.println("Opção inválida. Tente novamente.\n");
            }
        }
    }

    // Submenu para Gerenciamento de Usuários
    private static void gerenciarUsuarios() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("""
                \n=== GERENCIAR USUÁRIOS ===
                [1] Cadastrar Usuário
                [2] Listar Usuários
                [3] Excluir Usuário
                [0] Voltar ao Menu Principal""");
            System.out.print("Opção: ");
            int op = lerOpcao();
            switch (op) {
                case 1 -> usuarios.add(CadastroUsuario.cadastrarUsuario(sc));
                case 2 -> CadastroUsuario.listarUsuarios(usuarios);
                case 3 -> {
                    System.out.print("Matrícula do usuário a excluir: ");
                    int matricula = Integer.parseInt(sc.nextLine());
                    CadastroUsuario.excluirUsuario(usuarios, matricula);     // Você precisará criar Usuario.excluirUsuario(List<Usuario>, int)
                }
                case 0 -> voltar = true;
                default -> System.out.println("Opção inválida. Tente novamente.\n");
            }
        }
    }

    /* Submenu para Gerenciamento de Empréstimos */
    private static void gerenciarEmprestimos() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("""
                \n=== GERENCIAR EMPRÉSTIMOS ===
                [1] Realizar Empréstimo
                [2] Realizar Devolução
                [3] Listar Empréstimos Ativos/Todos (Opcional)
                [0] Voltar ao Menu Principal""");
            System.out.print("Opção: ");
            int op = lerOpcao();
            switch (op) {
                case 1 -> {
                    System.out.print("ISBN do livro para empréstimo: ");
                    int isbn = Integer.parseInt(sc.nextLine());
                    Emprestimo.emprestarLivro(livros, usuarios, emprestimos, isbn, sc);
                }
                case 2 -> {
                    System.out.print("ISBN do livro para devolução: ");
                    int isbn = Integer.parseInt(sc.nextLine());
                    Emprestimo.devolverLivro(livros, emprestimos, isbn);
                }
                case 0 -> voltar = true;
                default -> System.out.println("Opção inválida. Tente novamente.\n");
            }
        }
    }

    // Metodo auxiliar para ler a opção do usuário e tratar erros
    private static int lerOpcao() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            return -1; // Retorna uma opção inválida para o switch lidar
        }
    }
}