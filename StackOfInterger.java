public class StackOfInterger {
    private Node top;
    private Node bottom;
    private int count;

    public StackOfInterger() {
        top = new Node(null);
        bottom = new Node(null);
        top.next = bottom;
        bottom.prev = top;
        count = 0;
    }

    public boolean pop() { // remover do topo
        if (count <= 0) {
            return false;
        }

        top.next = top.next.next;
        top.next.prev = top;
        count--;
        return true;
    }

    public void push(Integer elemento) { // adicionar no topo
        Node aux = new Node(elemento);

        aux.next = top.next;
        aux.prev = top;

        top.next.prev = aux;
        top.next = aux;

        count++;
    } 

    public int top() { //verifica qual o elemento no topo da pilha
        return top.next.element;
    }

    public int size() { //retorna o tamanho
        return count;
    }

    public boolean isEmpty() { //verifica se está vazia
        return (count == 0);
    }

    public static int[] reverseArrayUsingStack(int[] array) {
        StackOfInterger p = new StackOfInterger();

        for (int numero : array) {
            p.push(numero);
        }

        int[] arrayReverso = new int[array.length];
        int index = 0;
        while (!p.isEmpty()) {
            arrayReverso[index++] = p.top();
            p.pop();
        }

        return arrayReverso;
    }

    public void clear() { //esvazia a pilha
        top = new Node(null);
        bottom = new Node(null);
        top.next = bottom;
        bottom.prev = top;
        count = 0;
    }

    @Override
    public String toString() {
        Node aux = top.next;
        StringBuilder s = new StringBuilder();

        if (count == 0) {
            return "Vazia";
        }

        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append(" | ");
            aux = aux.next;
        }
        return s.toString();
    } 
}