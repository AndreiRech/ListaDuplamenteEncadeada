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

    }

}
