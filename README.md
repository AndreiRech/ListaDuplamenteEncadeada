# Lista Duplamente Encadeada
Estruturas de Dados Lineares e Complexidade de Algoritmos

Passos a serem feitos:

1. Acrescentando métodos na implementação de Lista Duplamente Encadeada


a) Na classe DoubleLinkedListOfInteger acrescente o método abaixo seguindo as instruções dos comentários javadoc:

    /**
     * Método que conta o número de ocorrências do elemento passado como parâmetro na lista, retornando este valor
     * @param element elemento a ser inserido 
     * @return valor inteiro relativo ao número de ocorrências encontradas 
     */
     int countOccurrences(Integer element)


b) Na classe DoubleLinkedListOfInteger acrescente o método abaixo seguindo as instruções dos comentários javadoc:

    /**
     * Método que percorre a lista removendo todos os elementos pares.
     * Defina os atributos necessários para este algoritmo, pois nenhum método já implementado pode ser chamado
     * pois nenhum método já implementado pode ser chamado.
     * @return true se houver alguma remoção, e false caso não tenham elementos pares e não seja feita remoção
     */
     boolean removeEvenNumbers( ... )


2. Implementação de Pilhas

a) Apresente os métodos definidos a seguir para uma classe StackOfInterger que lida com números inteiros em um estrutura de pilha, considerando que os elementos da pilha devem ser armazenados em uma DoubleLinkedListOfInteger. Crie uma classe App e inclua nela o método main. Dentro deste método main instancie a pilha implementada, inclua elementos e use o restante dos métodos implementados.

     Integer pop()
     Integer push(Integer element)
     Integer top()
     int size()
     boolean isEmpty()
     void clear()


b) Construa o método estático abaixo seguindo as instruções dos comentários javadoc. Este método recebe um arranjo de inteiros por parâmetro e utiliza uma instância da pilha implementada para inverter o seu conteúdo. Chame este método main da classe App para testar o seu funcionamento. 

    /**
     * Método reverseArrayUsingStack()
     * Método estático que recebe um arranjo de inteiros e utiliza uma pilha implementada para inverter seu conteúdo
     * @param um arranjo inteiros
     * @return o arranjo de inteiros com os dados invertidos
     */
     reverseArrayUsingStack( ... )


3. Implementação de Filas

a) Apresente os métodos definidos a seguir para uma classe QueueOfInterger que lida com números inteiros em um estrutura de fila, considerando que os elementos da fila devem ser armazenados em uma DoubleLinkedListOfInteger. Crie uma classe App e inclua nela o método main. Dentro deste método main instancie a fila implementada, inclua elementos e use o restante dos métodos implementados.

     Integer enqueue(Integer element)
     Integer dequeue()
     Integer head()
     int size()
     boolean isEmpty()
     void clear()

b) Implemente um método que transforma que usa a lógica de fila de prioridades, onde um elemento inserido na fila deve ser posicionado de acordo com o seu valor. A ordem deve ser 

    /**
     * Método enqueuePriority()
     * Recebe como parâmetro um elemento que deve ser inserido na fila de acordo com a sua prioridade
     * @param element elemento a ser inserido 
     */
     void enqueuePriority(Integer element)


4) Complexidade de algoritmos

a) Construa um documento que apresenta a complexidade de tempo de pior caso (Notação O) para cada método construído com a justifique do porquê da classe de complexidade indicada e qual o raciocínio usado para chegar neste resultado.
