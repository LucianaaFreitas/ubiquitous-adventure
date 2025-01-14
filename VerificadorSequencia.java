import java.util.Stack;
import java.util.Scanner;

    public class VerificadorSequencia {

        //Metodo principal onde o programa começa a execução
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);//Objeto para ler a entrada do usuário
            System.out.println("Digite a sequência de parênteses e colchetes:");// Solicita a entrada do usuário
            String entrada = scanner.nextLine(); //Lê a sequencia digitada pelo usuário

            // Chama o metodo para verificar se a sequência está bem-formada
            if (verificarBemFormada(entrada)) {
                System.out.println("BEM-FORMADA");// Imprime se a sequencia é bem-formada
            } else {
                System.out.println("MALFORMADA");//Imprime se a sequencia é malformada
            }
            scanner.close();// Fecha o scanner para liberar recursos
        }

        // Metodo que verifica se uma sequencia de parentese e colchetes está bem-formada
        // Utiliza uma estrutura de dados do tipo pilha para gerenciar a abertura e fechamento.
        public static boolean verificarBemFormada(String sequencia) {
            Stack<Character> pilha = new Stack<>();// Pilha para armazenar os caracteres de abertura.

            for (char ch : sequencia.toCharArray()) {
                // Se for um caractere de abertura, empilha
                if (ch == '(' || ch == '[') {
                    pilha.push(ch);
                }
                // Se for um caractere de fechamento, verifica a correspondência
                else if (ch == ')' || ch == ']') {
                    // Pilha vazia implica falta de correspondência
                    if (pilha.isEmpty()) {
                        return false; // A sequencia está malformada
                    }

                    //Remove o topo da pilha (ultimo caractere de abertura)
                    char topo = pilha.pop();
                    // Verifica se o par está correto
                    if ((ch == ')' && topo != '(') || (ch == ']' && topo != '[')) {
                        return false;//Par de abertura e fechamento incompatível
                    }
                }
            }
            // No final, a pilha deve estar vazia se tudo foi fechado corretamente.
            return pilha.isEmpty();
        }
    }

