public class FilaClientes {

    private LinkedListCliente filaNormal;
    private LinkedListCliente filaPrioritaria;

    // Instancia filas com linkedlist
    public FilaClientes() {
        this.filaNormal = new LinkedListCliente();
        this.filaPrioritaria = new LinkedListCliente();
    }

    // Adiciona clientes conforme idade em suas respectivas filas, normal ou prioritaria
    public void enqueue(Cliente c) {
        if (c.getIdade() > 0 && c.getIdade() < 65)
            filaNormal.add(c);
        else
            filaPrioritaria.add(c);
    }

    //Remove cliente prioritário, se tiver algum na fila
    public void dequeueClientePrioritario() {
        if (sizeFilaNormal() == 0 && sizeFilaPrioritaria() == 0)
            throw new RuntimeException("Fila está vazia");

        else {
            if (sizeFilaPrioritaria() == 0)
                dequeueClienteNormal();
            else
                filaPrioritaria.removeByIndex(0);
        }
    }

    //Remove cliente sem prioridade, se tiver algum na fila
    public void dequeueClienteNormal() {
        if (sizeFilaNormal() == 0)
            dequeueClientePrioritario();

        else
            filaNormal.removeByIndex(0);
    }

    // Pega o primeiro da fila normal
    public Cliente headFilaNormal() {
        try {
            return filaNormal.get(0);
        } catch (Exception e) {
            return filaPrioritaria.get(0);
        }

    }

    // Pega o primeiro da fila prioritaria
    public Cliente headFilaPrioritaria() {
        try {
            return filaPrioritaria.get(0);
        } catch (Exception e) {
            return filaNormal.get(0);
        }
    }

    // Retorna o tamanho da filanormal
    public int sizeFilaNormal() {
        return filaNormal.size();
    }

    // Retorna o tamanho da fila prioritaria
    public int sizeFilaPrioritaria() {
        return filaPrioritaria.size();
    }

    // Retorna true se a fila normal está vazia
    public boolean isEmptyFilaNormal() {
        if (sizeFilaNormal() == 0)
            return true;
        else
            return false;
    }

    // Retorna true se a fila prioritaria está vazia
    public boolean isEmptyFilaPrioritaria() {
        if (sizeFilaPrioritaria() == 0)
            return true;
        else
            return false;
    }

    // Clear fila normal
    public void clearFilaNormal() {
        filaNormal.clear();
    }

    // Clear fila prioritaria
    public void clearFilaPrioritaria() {
        filaPrioritaria.clear();
    }

}