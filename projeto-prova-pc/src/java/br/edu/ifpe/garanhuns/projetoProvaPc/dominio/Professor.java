package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

public class Professor {

	private String nome;
	private int siap; 
	private String senha;

	Professor(String nome, int siap, String senha){
		this.nome = nome;
		this.siap = siap;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSiap() {
		return siap;
	}
	public void setSiap(int siap) {
		this.siap = siap;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void createProva(){

	}
        
	public void applyProva(){

	}




}