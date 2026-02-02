import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGerenciamentoNomes {

    public static void main(String[] args) {
        
        ArrayList<String> nomes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("=== Bem-vindo ao Sistema de Gerenciamento de Nomes ===");

        
        while (opcao != 5) {
         
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar nome");
            System.out.println("2 - Listar nomes cadastrados");
            System.out.println("3 - Atualizar um nome existente");
            System.out.println("4 - Remover um nome");
            System.out.println("5 - Sair do sistema");
            System.out.print("Escolha uma opção: ");

            
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Por favor, digite um número válido.");
                scanner.nextLine(); 
                continue; 
            }

            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome para cadastrar: ");
                    String novoNome = scanner.nextLine();
                    nomes.add(novoNome);
                    System.out.println("Nome cadastrado com sucesso!");
                    break;

                case 2: 
                    System.out.println("\n--- Lista de Nomes ---");
                    if (nomes.isEmpty()) {
                        System.out.println("A lista está vazia.");
                    } else {
                        for (int i = 0; i < nomes.size(); i++) {
                            
                            System.out.println((i + 1) + ". " + nomes.get(i));
                        }
                    }
                    break;

                case 3: 
                    System.out.println("\n--- Atualizar Nome ---");
                    if (nomes.isEmpty()) {
                        System.out.println("Não há nomes para atualizar.");
                    } else {
                        
                        for (int i = 0; i < nomes.size(); i++) {
                            System.out.println((i + 1) + ". " + nomes.get(i));
                        }
                        
                        System.out.print("Digite o número do nome que deseja atualizar: ");
                        int indiceAtualizar = scanner.nextInt() - 1; 
                        scanner.nextLine(); 

                        if (indiceAtualizar >= 0 && indiceAtualizar < nomes.size()) {
                            System.out.print("Digite o novo nome: ");
                            String nomeAtualizado = scanner.nextLine();
                            nomes.set(indiceAtualizar, nomeAtualizado);
                            System.out.println("Nome atualizado com sucesso!");
                        } else {
                            System.out.println("Número inválido.");
                        }
                    }
                    break;

                case 4: 
                    System.out.println("\n--- Remover Nome ---");
                    if (nomes.isEmpty()) {
                        System.out.println("Não há nomes para remover.");
                    } else {
                        for (int i = 0; i < nomes.size(); i++) {
                            System.out.println((i + 1) + ". " + nomes.get(i));
                        }

                        System.out.print("Digite o número do nome que deseja remover: ");
                        int indiceRemover = scanner.nextInt() - 1; 
                        scanner.nextLine(); 

                        if (indiceRemover >= 0 && indiceRemover < nomes.size()) {
                            String nomeRemovido = nomes.remove(indiceRemover);
                            System.out.println("O nome '" + nomeRemovido + "' foi removido.");
                        } else {
                            System.out.println("Número inválido.");
                        }
                    }
                    break;

                case 5: 
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}