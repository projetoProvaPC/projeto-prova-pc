/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.estrutura.repositorios;

import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.IdNaoDisponivelException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author lucas
 * @param <Tipo>
 */
public class RepositorioMemoria<Tipo extends Persistivel> implements Repositorio<Tipo> {

    private final Map<Integer,Tipo> elementos = new HashMap<>();

    @Override
    public void adicionar(Tipo t) throws IdNaoDisponivelException {
        if(elementos.containsKey(t.getId()))
            throw new IdNaoDisponivelException();
        elementos.put(t.getId(), t);
    }

    @Override
    public Tipo remover(int id) {
        return elementos.remove(id);
    }

    @Override
    public void alterar(Tipo t) {
        try {
            elementos.get(t.getId()).alterar(t);
        } catch(NullPointerException e) {
            return;
        }
    }

    @Override
    public List<Tipo> recuperar() {
        ArrayList<Tipo> al = new ArrayList<>();
        for (Map.Entry<Integer, Tipo> e : elementos.entrySet()) {
            al.add(e.getValue());
        }
        return al;
    }

    @Override
    public Tipo recuperar(int id) {
        return elementos.get(id);
    }

    @Override
    public int proxId() {
        Set<Integer> set = elementos.keySet();
        int i = 1;
        for (int j : set) {
            if(i==j) {
                i++;
            }
        }
        return i;
    }
    
    
}
