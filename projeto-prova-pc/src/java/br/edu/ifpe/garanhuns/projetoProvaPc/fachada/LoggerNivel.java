/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.fachada;

/**
 *
 * @author lucas
 */
public enum LoggerNivel {
    DEBUG(false, "DEBUG"), 
    ERRO(true, "ERRO"), 
    AVISO(false, "AVISO");
    
    private boolean status;
    private String prefix;

    private LoggerNivel(boolean status, String prefix) {
        this.status = status;
        this.prefix = prefix;
    }

    public boolean getStatus() {
        return status;
    }
    public String getPrefix() {
        return prefix;
    }
    
    
}
