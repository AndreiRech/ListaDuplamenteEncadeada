/**
 * CLASSE LinkedListOfInteger
 * Trabalhando com estruturas lineares em formato de listas duplamente encadeadas
 * */

public class DoubleLinkedListOfInteger {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Referencia para a posicao corrente.
    private Node current;    
    // Contador do numero de elementos da lista.
    private int count;

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**********************************************************************************
     /*** CREATE | Operações de inserção de dados na lista duplamente encadeada
     /**********************************************************************************

     /**
     * Método add() padrão
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
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
    
    /**
     * Método add() em posição específica
     * Insere um elemento em uma determinada posicao da lista
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) throws IndexOutOfBoundsException {
        // Primeiro verifica se index eh valido 
        if (index < 0 || index > count ) 
        	throw new IndexOutOfBoundsException();
        
        if (index == count) { // se insercao no final
            this.add(element);
        }
        else {
            // Primeiro cria o nodo
            Node n = new Node(element);
            // "Caminha" ate a posicao index
            Node aux = this.getNodeIndex(index);
            // "Encadear" o nodo na lista
            n.next = aux;           // o next do n é o aux
            n.prev = aux.prev;      // o prev do n recebe o prev do aux (o nodo entra no meio)
            aux.prev.next = n;      // o nodo que está atrás do n (estava atrás do aux primeiramente) vai se conectar ao n
            aux.prev = n;
            // Atualiza o count
            count++;
        }
    }

     /**********************************************************************************
     /*** READ | Operações de leitura de dados na lista encadeada
     /**********************************************************************************

     /**
     * Método get()
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        // Primeiro verifica se o indice eh valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        return aux.element;
    }
    
    /**
     * Método getNodeIndex()
     * Retorna a referencia para o nodo da posicao index
     * @param index
     * @return 
     */
    private Node getNodeIndex(int index) {
        Node aux = null;
        
        if (index < count/2) { // caminha do inicio para o meio
            aux = header.next;
            for (int i=0; i<index; i++) {
                aux = aux.next;
            }
        }
        else { // caminha do fim para o meio
            aux = trailer.prev;
            for (int i=count-1; i>index; i--) {
                aux = aux.prev;
            }
        }
        return aux;
    }


    /**********************************************************************************
    /*** UPDATE | Operações de substituição de dados na lista encadeada
    /**********************************************************************************

    /**
     * Método set()
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) {
        // Primeiro verifica se index eh valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        Integer elem = aux.element;
        aux.element = element;
        return elem;
    }

    /**********************************************************************************
    /*** DELETE | Operações de remoção de dados na lista encadeada
    /**********************************************************************************

     /**
     * Método remove()
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count;i++) {
            if (aux.element.equals(element)) {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Método removeByIndex()
     * Remove o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        // "Caminha" ate a posicao index
        Node aux = getNodeIndex(index);

        // Faz a remocao
        aux.next.prev = aux.prev;
        aux.prev.next = aux.next;

        // Atualiza count
        count--;

        // Retorna o elemento removido
        return aux.element;
    }


    /**********************************************************************************
    /*** OUTRAS OPERAÇÕES
    /**********************************************************************************

     /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    /**
     * Esvazia a lista
     */
    /*public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }    
        
    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    /*public int size() {
        return count;
    }
    
    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    /*public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Inicializa o current na primeira posicao (para percorrer do inicio para o fim).
     */
    public void reset() {
        current = header.next;
    }

    /**
     * Retorna o elemento da posicao corrente e faz current apontar para o proximo
     * elemento da lista.
     * @return elemento da posicao corrente
     */
    public Integer next() {
        if (current != trailer) {
            Integer num = current.element;
            current = current.next;
            return num;
        }
        return null;
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
    
    public String toStringBackToFront()
    {
        StringBuilder s = new StringBuilder();
        Node aux = trailer.prev;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.prev;
        }
        return s.toString();
    }



    //----------------------------- [MÉTODOS DO TRABALHO 1] --------------------------------//


    // QUESTÃO DE NÚMERO 1)
    // LETRA A)

    /**
     * Método que conta o número de ocorrências do elemento passado como parâmetro na lista, retornando este valor
     * @param element elemento a ser inserido 
     * @return valor inteiro relativo ao número de ocorrências encontradas 
     */

    public int countOccurrences(Integer elemento) {
        Node aux = header.next;     //cria o nodo auxiliar
        int cont = 0;
        for (int i=0; i<count; i++) {
            if (aux.element.equals(elemento)) {
                cont++;
            }
            aux = aux.next;
        }
        return cont;
    }

    //LETRA B)

    /**
     * Método que percorre a lista removendo todos os elementos pares.
     * Defina os atributos necessários para este algoritmo, pois nenhum método já implementado pode ser chamado
     * pois nenhum método já implementado pode ser chamado.
     * @return true se houver alguma remoção, e false caso não tenham elementos pares e não seja feita remoção
     */

    public boolean removeEvenNumbers() {
        Node aux = header.next;             //cria o nodo auxiliar
        int countOriginal = count;

        for (int i=0; i<countOriginal; i++) {
            int auxiliar = aux.element;
            if (auxiliar%2 == 0) {  
                aux.next.prev = aux.prev;   //retira as conexões do elemento com o prev e next dele e conecta no proximo
                aux.prev.next = aux.next;   //retira as conexões do elemento com o prev e next dele e conecta no proximo
                count--;
            }
            aux = aux.next;
        }

        if (countOriginal == count) {
            return false;
        }
        return true;
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

     public Integer enqueue(Integer elemento){
        Node n = new Node(elemento);

        n.next = trailer;       //o novo nodo aponta para o trailer
        n.prev = trailer.prev;  //o prev do nodo aponta para o prev do trailer
        trailer.prev.next = n;  //o next do nodo anterior ao trailer aponta para o novo nodo
        trailer.prev = n;       //o prev do trailer aponta vai apontar para o novo nodo
        count++;
        return elemento; 
    }

    public Integer dequeue(){
        Integer elemento = header.next.element;  //pegamos o elemento do header
        header.next = header.next.next;          //atualiza o next do header para o proximo nodo
        header.next.prev = header;               //atualiza o prev do proximo nodo para o header
        count--;
        return elemento;
    }

    public Integer head(){
        return header.next.element;  //retorna o elemento da frente
    }

    public int size(){
        return count;     //retorna a quantidade de elementos
    }

    public boolean isEmpty(){
        return (count == 0);  //retorna true if coount == 0
    }

    public void clear(){
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

    public void enqueuePriority(Integer elemento){
        if(elemento > 0 && elemento < 10){
        Node n = new Node(elemento);
        Node current = header.next;     //começa na frente da fila

        while(current != trailer && (current.element > 0 && current.element < 10)){ //while não estiver no final & elemento entre 1 e 9
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
}