/**
 * @author sarav
 */

/*
 * POP = remove o elemento do topo da pilha
 * PUSH = insere um novo elemento no topo da pilha
 * TOP = acessa o elemento posicionado no topo da pilha
 */

//public interface Pilha {
//    public int size();
//    public boolean isEmpty();
//    public Object top() throws PilhaVaziaExcecao;
//    public void pushpushPilhaVermelha(int elemento);
//    public void pushPilhaPreta(int elemento);
//    public Object pop() throws PilhaVaziaExcecao;
//    implements Pilha
//}
class PilhaFlamenguista {
    // deve conter duas pilhas, pilhav e pilhap
    // apenas um array com capacidade n > pilhav + pilhap
    // pilhav começo e pilhap final do array
    // quando array cheio tam array * 2
    private int topoVermelho;
    private int topoPreto;
    private int PilhaF[];

    public PilhaFlamenguista(int tamanho){
        this.PilhaF = new int[tamanho];
        this.topoVermelho = -1; // começo do array (tentar com < 0)
        this.topoPreto = tamanho; // topop = começo da pilha preta
    }

    // adicionar elementos (vermelhos) antes do topov
    public void pushPilhaVermelha(int elemento){
        if (topoVermelho +1 != topoPreto){
            topoVermelho++; // indo pra próxima posição pra depois inserir
            this.PilhaF[topoVermelho] = elemento;
        }
        else{
            System.out.printf("Pilha Vermelha chegou ao topo, não é possível fazer a inserção do elemento '%d'.\n",elemento);
        }
    }
    // adicionar elementos (pretos) depois do topov
    public void pushPilhaPreta(int elemento) {
        if (topoPreto - 1 != topoVermelho) { (
            topoPreto--; // indo para próxima posição para depois inserir
            this.PilhaF[topoPreto] = elemento; //topo do preto é o final do array
        } else {
            System.out.printf("Pilha Preta chegou ao topo, não é possível fazer a inserção do elemento '%d'\n", elemento);
        }
    }
    public int popPilhaVermelha(){
        if (topoVermelho != -1){ // (tentar com < 0)
            int elementoASerRemovido = this.PilhaF[topoVermelho];
            this.PilhaF[topoVermelho] = 0;
            this.topoVermelho--;
            return elementoASerRemovido;
        }
        else{
          throws PilhaVaziaExcecao;
        }
    }
    public class PilhaVaziaExcecao extends RuntimeException {
        public PilhaVaziaExcecao(String err){
        super(err);
        }
    }

    // imprimir o array
    @Override
    public String toString(){
        String saida = "[ ";
        for (int elemento : this.PilhaF){
            saida += String.format("%d ", elemento);
        }
        saida += "]";
        return saida;
    }
}

/*
if PilhaF cheia{
 int ArrayNovo[] = new int[len*2];
}
*/

class testePilha {
    public static void main(String[] args) {
        // tamanho = N > pilhav(5) + pilhap(5)
        PilhaFlamenguista PilhaF = new PilhaFlamenguista(15);
        //   System.out.println("inserindo");
        //   for(int f=0;f<10;f++){
        //   System.out.println(f);
        //   pilha.pushPilhaVermelha(new Integer(f));
        // }
       PilhaF.pushPilhaVermelha(10);
       PilhaF.pushPilhaPreta(11);
       PilhaF.pushPilhaPreta(12);
       PilhaF.pushPilhaPreta(13);
       System.out.print(PilhaF);
    }
}
