public class App {

    public static void main(String[] args) {

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

        StackOfInterger pilha = new StackOfInterger();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);
        pilha.push(5);
        pilha.push(6);

        System.out.println("\n------ [ TESTE DO TRABALHO (1a e 1b) ] --------");

        System.out.println("\nPrintando a lista original: " +dlist);
        System.out.println("\nQuantidade de vezes que o 8 aparece: " +dlist.countOccurrences(8));
        System.out.println("\nFoi removido algum número par da lista? : " +dlist.removeEvenNumbers());
        System.out.println(dlist);

        System.out.println("\n------ [ TESTE DO TRABALHO (2) ] --------");
        System.out.println(pilha);

        System.out.println("\n------ [ TESTE DO TRABALHO (3a) ] --------");

        DoubleLinkedListOfInteger dlist3 = new DoubleLinkedListOfInteger();

        dlist3.add(46);
        dlist3.add(1);
        dlist3.add(57);
        dlist3.add(62);
        dlist3.add(29);
        dlist3.add(14);
        dlist3.add(31);
        dlist3.add(59);
        dlist3.add(50);

        System.out.println("\n");

        System.out.println("Fila: " + dlist3);
        System.out.println("Enqueue: " + dlist3.enqueue(32));
        System.out.println("Enqueue: " + dlist3.enqueue(42));
        System.out.println("Fila: " + dlist3);
        System.out.println("Tamanho: " + dlist3.size());
        System.out.println("Dequeue: " + dlist3.dequeue());
        System.out.println("Enqueue: " + dlist3.enqueue(52));
        System.out.println("Fila: " + dlist3);
        System.out.println("Head (topo): " + dlist3.head());
        System.out.println("Dequeue: " + dlist3.dequeue());
        System.out.println("Fila: " + dlist3);
        System.out.println("Head (topo): " + dlist3.head());
        System.out.println("Tamanho: " + dlist3.size());
        System.out.println("Está vazia? " + dlist3.isEmpty());
        dlist3.clear();
        System.out.println("Fila foi limpa");
        System.out.println("Está vazia? " + dlist3.isEmpty());


        System.out.println("\n------ [ TESTE DO TRABALHO (3b) ] --------");

        dlist3.add(46);
        dlist3.add(19);
        dlist3.add(57);
        dlist3.add(62);
        dlist3.add(29);
        dlist3.add(14);
        dlist3.add(31);
        dlist3.add(59);
        dlist3.add(50);

        System.out.println("\n");

        System.out.println(dlist3);
        dlist3.enqueuePriority(2);
        System.out.println("\nElemento 2 (prioridade) incluido\n");
        System.out.println(dlist3);
        dlist3.enqueuePriority(21);
        System.out.println("\nElemento 21 (sem prioridade) incluido\n");
        System.out.println(dlist3);
    }

}
