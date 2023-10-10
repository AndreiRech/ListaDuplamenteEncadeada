public class App {

    public static void main(String[] args) {

        System.out.println("\n------ [ TESTE DO TRABALHO (1a e 1b) ] --------");

        DoubleLinkedListOfInteger dlist = new DoubleLinkedListOfInteger();
        dlist.add(1);
        dlist.add(2);
        dlist.add(3);
        dlist.add(4);
        dlist.add(5);
        dlist.add(6);
        dlist.add(7);
        dlist.add(8);
        dlist.add(8);
        dlist.add(8);
        dlist.add(9);
        dlist.add(10);

        System.out.println("\nPrintando a lista original: " +dlist);
        System.out.println("\nQuantidade de vezes que o 8 aparece: " +dlist.countOccurrences(8));
        System.out.println("\nFoi removido algum número par da lista? : " +dlist.removeEvenNumbers());
        System.out.println(dlist);

        System.out.println("\n------ [ TESTE DO TRABALHO (2a) ] --------");
        StackOfInterger pilha = new StackOfInterger();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);
        pilha.push(5);
        pilha.push(6);
        System.out.println("Pilha inicial : " +pilha);

        pilha.pop();
        pilha.pop();
        System.out.println("Pilha após 2 pop's : " +pilha);

        System.out.println("Topo da pilha : " +pilha.top());
        System.out.println("Verifica se a pilha está vazia : " +pilha.isEmpty());

        pilha.clear();
        System.out.println("Pilha após o clear : " +pilha + "\nEstá vazia : " +pilha.isEmpty());

        System.out.println("\n------ [ TESTE DO TRABALHO (2b) ] --------");
        int [] array = {1, 2, 3, 4, 5, 6};
        int [] arrayInvertido = StackOfInterger.reverseArrayUsingStack(array);

        System.out.println("Array Original:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println("\nArray Invertido:");
        for (int num : arrayInvertido) {
            System.out.print(num + " ");
        }

    System.out.println("\n------ [ TESTE DO TRABALHO (3a) ] --------");

    QueueOfInteger fila = new QueueOfInteger();

        fila.add(46);
        fila.add(1);
        fila.add(57);
        fila.add(62);
        fila.add(29);
        fila.add(14);
        fila.add(31);
        fila.add(59);
        fila.add(50);

        System.out.println("\n");

        System.out.println("Fila: " + fila);
        System.out.println("Enqueue: " + fila.enqueue(32));
        System.out.println("Enqueue: " + fila.enqueue(42));
        System.out.println("Fila: " + fila);
        System.out.println("Tamanho: " + fila.size());
        System.out.println("Dequeue: " + fila.dequeue());
        System.out.println("Enqueue: " + fila.enqueue(52));
        System.out.println("Fila: " + fila);
        System.out.println("Head (topo): " + fila.head());
        System.out.println("Dequeue: " + fila.dequeue());
        System.out.println("Fila: " + fila);
        System.out.println("Head (topo): " + fila.head());
        System.out.println("Tamanho: " + fila.size());
        System.out.println("Está vazia? " + fila.isEmpty());
        fila.clear();
        System.out.println("Fila foi limpa");
        System.out.println("Está vazia? " + fila.isEmpty());


        System.out.println("\n------ [ TESTE DO TRABALHO (3b) ] --------");

        fila.add(46);
        fila.add(28);
        fila.add(57);
        fila.add(17);
        fila.add(29);
        fila.add(14);
        fila.add(31);
        fila.add(59);
        fila.add(50);

        System.out.println("\n");

        System.out.println(fila);
        fila.enqueuePriority(5);
        System.out.println("\nElemento 2 (prioridade) incluido\n");
        System.out.println(fila);
        fila.enqueuePriority(21);
        System.out.println("\nElemento 21 (sem prioridade) incluido\n");
        System.out.println(fila);
    
    }

}
