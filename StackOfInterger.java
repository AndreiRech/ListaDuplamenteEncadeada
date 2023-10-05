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

        top.next.prev = top.prev;
        top.prev.next = top.next;
        count--;
        return true;
    }

    public void push(Integer elemento) { // adicionar no topo
        Node aux = new Node(elemento);

        aux.prev = top.next;
        aux.next = top;

        bottom.prev.next = aux;
        bottom.prev = aux;

        count++;
    } 

    public int top() { //verifica qual o elemento no topo da pilha
        return top.element;
    }

    public int size() { //retorna o tamanho
        return count;
    }

    public boolean isEmpty() { //verifica se está vazia
        return (count == 0);
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

        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append(" | ");
            aux = aux.next;
        }
        return s.toString();
    } 
}