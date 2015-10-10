/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.fachada;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author lucas
 */
public class Logger {
    
    private class Mensagem {
        LoggerNivel nivel;
        String msg;

        public Mensagem(LoggerNivel nivel, String msg) {
            this.nivel = nivel;
            this.msg = msg;
        }
        
    }
    
    private static Logger instance = null;
    
    private Logger() {
        mensagens = new LinkedList<>();
    }
    
    public static Logger getInstance () {
        if(instance == null) instance = new Logger();
        return instance;
    }
    
    private Queue<Mensagem> mensagens = null;
    
    
    public void print(LoggerNivel nivel, String mensagem) {
        if(nivel.getStatus()) 
            mensagens.add(new Mensagem(nivel, mensagem));
    }
    
    public boolean hasNextMessage() {
        return ! mensagens.isEmpty();
    }
    
    public String proxMensagem() {
       return mensagens.poll().msg;
    }
 
    public List<String> getAll() {
        List<String> msgs = new LinkedList<>();
        for (Iterator<Mensagem> it = mensagens.iterator(); it.hasNext();) {
            Logger.Mensagem mensagem = it.next();
            msgs.add(mensagem.nivel.getPrefix() + ": " + mensagem.msg);
        }
        return msgs;
    }
    
}
