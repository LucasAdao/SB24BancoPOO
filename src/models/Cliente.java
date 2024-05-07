package models;

public class Cliente {
	
    private String nome;
    private int idade;
    
    public Cliente() {
    	
    }
    public Cliente(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    
	public void setNome(String nome) {
		this.nome = nome;
	}
    public String getNome(){
        return nome;
    }
    
    public void setIdade(int idade) {
		this.idade = idade;
	}
    public int getIdade(){
        return idade;
    }

    @Override
    public String toString() {
        return "Cliente \n nome: " + nome + "\n idade: " + idade ;
    }

	

}
