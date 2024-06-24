package searchandsort;
import java.util.Arrays;
import java.util.Scanner;

public class SortAndSearch {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicita ao utilizador o tamanho da lista
        System.out.println("Digite quantos números irá colocar na lista:"); 
        int size = scanner.nextInt();
        int[] array = new int[size];
        
        // Solicita ao utilizador os elementos da lista
        System.out.println("Digite os elementos da sua lista separando os mesmos por espaço:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        boolean exit = false;
        
        // exibe o menu e executa a escolha do utilizador
        while (!exit) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Pesquisa Binária");
            System.out.println("4. Pesquisa Sequencial");
            System.out.println("5. Sair");
            int choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    // Executa o Bubble Sort e mede o tempo de execução
                    long startTime = System.nanoTime();
                    bubbleSort(array);
                    long endTime = System.nanoTime();
                    System.out.println("Tempo de execução: " + (endTime - startTime) + " nanossegundos");
                    break;
                case 2:
                    // Executa o Insertion Sort e mede o tempo de execução
                    startTime = System.nanoTime();
                    insertionSort(array);
                    endTime = System.nanoTime();
                    System.out.println("Tempo de execução: " + (endTime - startTime) + " nanossegundos");
                    break;
                case 3:
                    // Executa a Pesquisa Binária e mede o tempo de execução
                    startTime = System.nanoTime();
                    Arrays.sort(array); 
                    System.out.println("Array ordenado: " + Arrays.toString(array));
                    System.out.println("Digite o elemento a ser pesquisado:");
                    int target = scanner.nextInt();
                    int index = binarySearch(array, target);
                    if(index != -1)
                        System.out.println("Elemento encontrado na posição: " + index);
                    else
                        System.out.println("Elemento não encontrado.");
                    endTime = System.nanoTime();
                    System.out.println("Tempo de execução: " + (endTime - startTime) + " nanossegundos");
                    break;
                case 4:
                    // Executa a Pesquisa Sequencial e mede o tempo de execução
                    startTime = System.nanoTime();
                    System.out.println("Digite o elemento a ser pesquisado:");
                    target = scanner.nextInt();
                    index = sequentialSearch(array, target);
                    if(index != -1)
                        System.out.println("Elemento encontrado na posição: " + index);
                    else
                        System.out.println("Elemento não encontrado.");
                    endTime = System.nanoTime();
                    System.out.println("Tempo de execução: " + (endTime - startTime) + " nanossegundos");
                    break;
                case 5:
                    // Sai do programa
                    exit = true;
                    System.out.println("Adeus.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        
        scanner.close();
    }
    
    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        System.out.println("Array ordenado usando Bubble Sort: " + Arrays.toString(arr));
    }
    
    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println("Array ordenado usando Insertion Sort: " + Arrays.toString(arr));
    }
    
    // Pesquisa Binária
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    
    // Pesquisa Sequencial
    public static int sequentialSearch(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target)
                return i;
        }
        return -1;
    }
}
