package models;

public abstract class Conta implements IConta {
    
    protected int agencia;
    protected int numero;  
    protected double saldo;
    protected Cliente cliente;
   

    protected static final int AGENCIA_PADRAO = 1;
    protected static int SEQUENCIAL = 1;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }
    public void setCliente(Cliente cliente) {
    	if(cliente.getIdade() > 18) {
    		this.cliente = cliente;
    	}else {
    		System.out.println("Você precisa ter mais de 18 anos para abrir sua conta!");
    	}
    }
    public Cliente getCliente() {
    	return cliente;
    }
    public int getAgencia() {
        return agencia;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public double getSaldo() {
        return saldo;
    }
    public void consultarSaldo(){
        System.out.printf("Você possui um saldo de %.2f", saldo);
    }
    @Override
    public void sacar(double valor) {
        if(valor>saldo){
            System.out.println("Saldo insuficiente!");
            consultarSaldo();
        }else{
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
            consultarSaldo();
        }
    }

    @Override
    public void depositar(double valor) {
       saldo += valor;
       System.out.println("Deposito Realizado!");
       consultarSaldo();
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
    protected void imprimirInfosComuns(){
        System.out.println(String.format("Agência: %d", agencia));
        System.out.println(String.format("Número: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
        System.out.println("Titular: " + cliente.getNome());
    }
}
