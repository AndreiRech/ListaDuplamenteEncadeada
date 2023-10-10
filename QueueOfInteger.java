public class QueueOfInteger {
    private Node header;
    private Node trailer;
    private int count;

    public QueueOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public void add(Integer element) {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Conecta o nodo criado na lista
        n.prev = trailer.prev;
        n.next = trailer;
        // Atualiza os encadeamentos
        trailer.prev.next = n;
        trailer.prev = n;
        // Atualiza count
        count++;      
    }

    // QUESTÃO DE NÚMERO 3)
    // LETRA A)
    
    /*Apresente os métodos definidos a seguir para uma classe QueueOfInterger que lida com números inteiros em um estrutura de fila, 
    considerando que os elementos da fila devem ser armazenados em uma DoubleLinkedListOfInteger. 
    Crie uma classe App e inclua nela o método main. 
    Dentro deste método main instancie a fila implementada, inclua elementos e use o restante dos métodos implementados. */

    /*Integer enqueue(Integer element)
      Integer dequeue()
      Integer head()
      int size()
      boolean isEmpty()
      void clear()
     */

    public Integer enqueue(Integer elemento) {
        Node n = new Node(elemento);

        n.next = trailer;       // o novo nodo aponta para o trailer
        n.prev = trailer.prev;  // o prev do nodo aponta para o prev do trailer
        trailer.prev.next = n;  // o next do nodo anterior ao trailer aponta para o novo nodo
        trailer.prev = n;       // o prev do trailer aponta vai apontar para o novo nodo
        count++;
        return elemento;
    }

    public Integer dequeue() {
        Integer elemento = header.next.element;  // pegamos o elemento do header
        header.next = header.next.next;          // atualiza o next do header para o próximo nodo
        header.next.prev = header;               // atualiza o prev do próximo nodo para o header
        count--;
        return elemento;
    }

    public Integer head() {
        return header.next.element;  // retorna o elemento da frente
    }

    public int size() {
        return count;     // retorna a quantidade de elementos
    }

    public boolean isEmpty() {
        return (count == 0);  // retorna true if count == 0
    }

    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    // QUESTÃO DE NÚMERO 3)
    // LETRA B)

    /*Implemente um método que transforma que usa a lógica de fila de prioridades, 
    onde um elemento inserido na fila deve ser posicionado de acordo com o seu valor. 
    A ordem deve ser: 

    /**
     * Método enqueuePriority()
     * Recebe como parâmetro um elemento que deve ser inserido na fila de acordo com a sua prioridade
     * @param element elemento a ser inserido 
     */

    //Prioridade = valores positivos de apenas 1 digito

    public void enqueuePriority(Integer elemento){
        if(elemento > 0 && elemento < 10){
        Node n = new Node(elemento);
        Node current = header.next;     //começa na frente da fila

        while(current != trailer && current.element <= 9){ //while não estiver no final & elemento entre 1 e 9
            if(elemento >= current.element){
                break;                  //se o elemento for igual ou menor que o elemento atual, ele para na fila
            }
            current = current.next;     //avança na fila
        }

        n.next = current;           // Define o next node do novo nodo como o nodo atual (avança o novo nodo na fila)
        n.prev = current.prev;      // Define o prev node do novo nodo como o prev node do nodo atual
        current.prev.next = n;      // Atualiza o next node do prev node do nodo atual para apontar para o novo nodo
        current.prev = n;           // Atualiza o prev node do nodo atual para apontar para o novo nodo
        count++;
        }
        else{
            enqueue(elemento);
        }
     }


     @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append(" | ");
            aux = aux.next;
        }
        return s.toString();
    } 
}
