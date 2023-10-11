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
     //* @param element elemento a ser inserido
     //* @return valor inteiro relativo ao número de ocorrências encontradas
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
}