/**
 * @author sarav
 */

/*
 * POP = remove o elemento do topo da pilha
 * PUSH = insere um novo elemento no topo da pilha
 * TOP = acessa o elemento posicionado no topo da pilha
 */


class PilhaFlamenguista {
    // deve conter duas pilhas, pilhav e pilhap X
    // apenas um array com capacidade n > pilhav + pilhap X
    // pilhav começo e pilhap final do array X
    // quando array cheio tam array * 2
    private int topoVermelho;
    private int topoPreto;
    private int PilhaF[];


    public PilhaFlamenguista(int size) {
        this.PilhaF = new int[size];
        this.topoVermelho = -1; // começo do array (tentar com < 0)
        this.topoPreto = size; // topop = começo da pilha preta
    }

    // adicionar elementos (vermelhos) antes do topov
    public void pushPilhaVermelha(int elemento) {
        if (topoVermelho + 1 != topoPreto) {
            topoVermelho++; // indo pra próxima posição pra depois inserir
            this.PilhaF[topoVermelho] = elemento;
        } else {
            System.out.printf("Pilha Vermelha chegou ao topo, não é possível fazer a inserção do elemento '%d'.\n", elemento);
        }
    }

    // adicionar elementos (pretos) depois do topov
    public void pushPilhaPreta(int elemento) {
        if (topoPreto - 1 != topoVermelho) {
            topoPreto--; // indo para próxima posição para depois inserir
            this.PilhaF[topoPreto] = elemento; // topo do preto é o final do array
        } else {
            System.out.printf("Pilha Preta chegou ao topo, não é possível fazer a inserção do elemento '%d'\n", elemento);
        }
    }

    public class PilhaVaziaExcecao extends RuntimeException {
        public PilhaVaziaExcecao(String err) {
            super(err);
        }
    }

    public int popPilhaVermelha() {
        if (topoVermelho < 0){ // if isEmpty
            throw new PilhaVaziaExcecao("Não foi possível remover nenhum elemento pois a pilha vermelha está vazia");
        } else {
            int elementoParaRemover = this.PilhaF[topoVermelho];
            this.PilhaF[topoVermelho] = 0; // substitui o elemento removido por 0
            // t ← t − 1
            this.topoVermelho--; // volta uma "casa" para ter um novo topo
            return elementoParaRemover;
        }
    }
    public int popPilhaPreta() {
        if (topoPreto == PilhaF.length){ // if isEmpty
            throw new PilhaVaziaExcecao("Não foi possível remover nenhum elemento pois a pilha preta está vazia");
        } else {
            int elementoParaRemover = this.PilhaF[topoPreto];
            this.PilhaF[topoPreto] = 0; // substitui o elemento removido por 0
            // t ← t − 1
            this.topoPreto++; // volta uma "casa" para ter um novo topo
            return elementoParaRemover;
        }
    }

    // escrever o array com os elementos das pilhas
    @Override
    public String toString() {
        String saida = "[ ";
        for (int elemento : this.PilhaF) {
            saida += String.format("%d ", elemento);
        }
        saida += "]";
        return saida;
    }
//    private void duplicaArray(){
//        int novoArray[] = new
//    }
}
class Main {
    public static void main(String[] args) {
        // tamanho = N > pilhav(3) + pilhap(5)
        PilhaFlamenguista PilhaF = new PilhaFlamenguista(10);

        // inserir elementos na pilha vermelha
        System.out.println("inserindo");
        for(int elemento = 1; elemento <= 3; elemento++){
            System.out.println("->" + elemento);
            PilhaF.pushPilhaVermelha(elemento);
        }
        System.out.println(PilhaF);


        // inserir elementos na pilha preta
        System.out.println("inserindo");
        for(int elemento = 1; elemento <= 3; elemento++){
            System.out.println("->" + elemento);
            PilhaF.pushPilhaPreta(elemento);
        }
        System.out.println(PilhaF);


        // removendo elementos na pilha vermelha
        System.out.println(PilhaF);
        System.out.println("retirando:");
        for(int elemento = 1; elemento <= 5; elemento++) {
            System.out.print(" - "+PilhaF.popPilhaVermelha());
            System.out.println();
        }
        System.out.println(PilhaF);


        // removendo elementos na pilha preta
        System.out.println(PilhaF);
        System.out.println("retirando:");
        for(int elemento = 1; elemento <= 5; elemento++) {
            System.out.print(" - "+PilhaF.popPilhaPreta());
            System.out.println();
        }
        System.out.println(PilhaF);


    }
}