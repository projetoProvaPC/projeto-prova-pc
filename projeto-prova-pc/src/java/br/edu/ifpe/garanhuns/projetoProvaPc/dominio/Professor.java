package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.Persistivel;

public class Professor implements Persistivel<Professor> {

    private int siap;
    private String senha;

    public Professor(int siap, String senha) {
        this.siap = siap;
        this.senha = senha;
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

    public boolean testarSenha(String senha) {
        return senha != null && senha.equals(this.senha);
    }

    @Override
    public int getId() {
        return siap;
    }

    @Override
    public void alterar(Professor t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
