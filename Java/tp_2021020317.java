import java.util.Scanner;

public class OperacoesConjunto {

    // Verifica se um conjunto está vazio
    public static boolean ehVazio(Object[] A) {
        return A.length == 0;
    }

    // Realiza a união de dois conjuntos
    public static Object[] uniaoConj(Object[] A, Object[] B) {
        Object[] uniao = new Object[A.length + B.length];
        int i = 0;

        // Adiciona elementos do conjunto A
        for (Object elemento : A) {
            uniao[i++] = elemento;
        }

        // Adiciona elementos do conjunto B que não estão em A
        for (Object elemento : B) {
            if (!contemElemento(uniao, elemento)) {
                uniao[i++] = elemento;
            }
        }

        return redimensionarArray(uniao, i);
    }

    // Realiza a interseção de dois conjuntos
    public static Object[] intersConj(Object[] A, Object[] B) {
        Object[] intersecao = new Object[Math.min(A.length, B.length)];
        int i = 0;

        // Adiciona elementos que estão em ambos os conjuntos
        for (Object elemento : A) {
            if (contemElemento(B, elemento)) {
                intersecao[i++] = elemento;
            }
        }

        return redimensionarArray(intersecao, i);
    }

    // Calcula a diferença entre dois conjuntos (A - B)
    public static Object[] diffConj(Object[] A, Object[] B) {
        Object[] diferenca = new Object[A.length];
        int i = 0;

        // Adiciona elementos que estão em A e não em B
        for (Object elemento : A) {
            if (!contemElemento(B, elemento)) {
                diferenca[i++] = elemento;
            }
        }

        return redimensionarArray(diferenca, i);
    }

    // Calcula a diferença simétrica entre dois conjuntos (A ⊕ B)
    public static Object[] diffSimConj(Object[] A, Object[] B) {
        Object[] diferencaSimetrica = new Object[A.length + B.length];
        int i = 0;

        // Adiciona elementos que estão em A e não em B, e vice-versa
        for (Object elemento : A) {
            if (!contemElemento(B, elemento) && !contemElemento(diferencaSimetrica, elemento)) {
                diferencaSimetrica[i++] = elemento;
            }
        }

        for (Object elemento : B) {
            if (!contemElemento(A, elemento) && !contemElemento(diferencaSimetrica, elemento)) {
                diferencaSimetrica[i++] = elemento;
            }
        }

        return redimensionarArray(diferencaSimetrica, i);
    }

    // Adiciona um elemento ao conjunto, se ainda não estiver presente
    public static Object[] addConj(Object[] A, Object x) {
        if (!contemElemento(A, x)) {
            A = redimensionarArray(A, A.length + 1);
            A[A.length - 1] = x;
        }
        return A;
    }

    // Remove um elemento do conjunto, se presente
    public static Object[] remConj(Object[] A, Object x) {
        int indice = indiceDe(A, x);
        if (indice != -1) {
            A = removerElemento(A, indice);
        }
        return A;
    }

    // Retorna o tamanho do conjunto
    public static int tamConj(Object[] A) {
        return A.length;
    }

    // Verifica se um elemento está presente no conjunto
    public static boolean ehElemConj(Object[] A, Object x) {
        return contemElemento(A, x);
    }

    // Função principal para testar as operações de conjunto
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada dos conjuntos A e B
        System.out.print("Digite os elementos do conjunto A separados por espaço: ");
        Object[] conjunto_A = lerArray(scanner);

        System.out.print("Digite os elementos do conjunto B separados por espaço: ");
        Object[] conjunto_B = lerArray(scanner);

        // Exibição dos conjuntos A e B
        System.out.println("A: " + arrayParaString(conjunto_A));
        System.out.println("B: " + arrayParaString(conjunto_B));

        // Realização das operações e exibição dos resultados
        System.out.println("É vazio (A): " + ehVazio(conjunto_A));
        System.out.println("União de A e B: " + arrayParaString(uniaoConj(conjunto_A, conjunto_B)));
        System.out.println("Interseção de A e B: " + arrayParaString(intersConj(conjunto_A, conjunto_B)));
        System.out.println("Diferença A - B: " + arrayParaString(diffConj(conjunto_A, conjunto_B)));
        System.out.println("Diferença Simétrica A ⊕ B: " + arrayParaString(diffSimConj(conjunto_A, conjunto_B)));

        // Adição de um elemento ao conjunto A
        System.out.print("Digite um elemento para adicionar ao conjunto A: ");
        Object elemento_add = lerElemento(scanner);
        conjunto_A = addConj(conjunto_A, elemento_add);
        System.out.println("A após adição: " + arrayParaString(conjunto_A));

        // Remoção de um elemento do conjunto A
        System.out.print("Digite um elemento para remover do conjunto A: ");
        Object elemento_rem = lerElemento(scanner);
        conjunto_A = remConj(conjunto_A, elemento_rem);
        System.out.println("A após remoção: " + arrayParaString(conjunto_A));

        // Exibição do tamanho do conjunto A
        System.out.println("Tamanho de A: " + tamConj(conjunto_A));

        // Verificação se um elemento está presente no conjunto A
        System.out.print("Digite um elemento para verificar se está em A: ");
        Object elemento_verificar = lerElemento(scanner);
        System.out.println(elemento_verificar + " pertence a A: " + ehElemConj(conjunto_A, elemento_verificar));
    }

    // Verifica se um elemento está presente no array
    private static boolean contemElemento(Object[] arr, Object x) {
        if (x == null) {
            for (Object elemento : arr) {
                if (elemento == null) {
                    return true;
                }
            }
        } else {
            for (Object elemento : arr) {
                if (x.equals(elemento)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Encontra o índice de um elemento no array
    private static int indiceDe(Object[] arr, Object x) {
        for (int i = 0; i < arr.length; i++) {
            if ((x == null && arr[i] == null) || (x != null && x.equals(arr[i]))) {
                return i;
            }
        }
        return -1;
    }

    // Remove um elemento do array
    private static Object[] removerElemento(Object[] arr, int indice) {
        Object[] novoArray = new Object[arr.length - 1];
        int novoIndice = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != indice) {
                novoArray[novoIndice++] = arr[i];
            }
        }
        return novoArray;
    }

    // Redimensiona o array para um novo tamanho
    private static Object[] redimensionarArray(Object[] arr, int novoTamanho) {
        Object[] novoArray = new Object[novoTamanho];
        System.arraycopy(arr, 0, novoArray, 0, Math.min(arr.length, novoTamanho));
        return novoArray;
    }

    // Converte a entrada do usuário em um array de objetos
    private static Object[] lerArray(Scanner scanner) {
        String[] elementos = scanner.nextLine().split(" ");
        Object[] array = new Object[elementos.length];
        for (int i = 0; i < elementos.length; i++) {
            array[i] = converteElemento(elementos[i]);
        }
        return array;
    }

    // Converte a entrada do usuário em um objeto
    private static Object lerElemento(Scanner scanner) {
        String elemento = scanner.next();
        return converteElemento(elemento);
    }

    // Converte elementos da entrada em tipos específicos (inteiro ou string)
    private static Object converteElemento(String elemento) {
        try {
            return Integer.parseInt(elemento);
        } catch (NumberFormatException e) {
            return elemento;
        }
    }

    // Converte um array de objetos em uma string formatada
    private static String arrayParaString(Object[] arr) {
        StringBuilder resultado = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            resultado.append(arr[i]);
            if (i < arr.length - 1) {
                resultado.append(", ");
            }
        }
        resultado.append("]");
        return resultado.toString();
    }
}

