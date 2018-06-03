public class Caixa {

    private FilaClientes filaCliente;

    public Caixa(FilaClientes fila) {
        filaCliente = fila;
    }
    //Efetua atendimento nos respectivos caixas
    public void efetuaAtendimento(int numCaixa) {
        if (numCaixa >= 1 && numCaixa <= 5)
            filaCliente.dequeueClientePrioritario();
        else
            filaCliente.dequeueClienteNormal();
    }

}