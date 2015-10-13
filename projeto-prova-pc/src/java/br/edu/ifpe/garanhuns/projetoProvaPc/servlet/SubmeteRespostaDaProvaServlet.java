/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.servlet;

import br.edu.ifpe.garanhuns.projetoProvaPc.builders.RespostaProvaQuestaoMultiplaEscolhaBuilder;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.QuestaoMultiplaEscolha;
import br.edu.ifpe.garanhuns.projetoProvaPc.fachada.Fachada;
import br.edu.ifpe.garanhuns.projetoProvaPc.fachada.Logger;
import br.edu.ifpe.garanhuns.projetoProvaPc.fachada.LoggerNivel;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucas
 */
@WebServlet(name = "SubmeteRespostaDaProvaServlet", urlPatterns = {"/SubmeteRespostaDaProvaServlet"})
public class SubmeteRespostaDaProvaServlet extends HttpServlet {

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prefix = "SubmeteRespostaDaProvaServlet::processRequest::";
        
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "nova requisicao!");
        
        HttpSession session = request.getSession();
        
        String matricula = request.getParameter("matricula");
        
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "request::param::matricula=" + matricula);
        
        String senha = request.getParameter("senha");
        
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "request::param::senha=" + senha);
        
        RespostaProvaQuestaoMultiplaEscolhaBuilder builder = Fachada.getInstance().getRespostaProvaQuestaoMultiplaEscolhaBuilder(matricula,senha);
        
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "criando builder");
        
        Iterator<QuestaoMultiplaEscolha> qs = builder.iterator();
        
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "recuperou iterator");
        
        int i=1;
        while(qs.hasNext()) {
            QuestaoMultiplaEscolha q = qs.next();
            Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "chamando builder.responder" + "\n" +
                    "param::"+ "request.getParameter(\"q\"+i).charAt(0)=" + request.getParameter("q"+i).charAt(0) +
                    "param::q" + q.toString()
            );
            builder.responder(q,request.getParameter("q"+i).charAt(0));
            if(q==null) {
                Logger.getInstance().print(LoggerNivel.ERRO, prefix + "q==null(line=52)");
                response.sendRedirect("pagina_erro.jsp");
                return;
            }
            i++;
            
            Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "i=" + (i-1) );
            Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "q=" + q.getEnunciado());
        }
        double nota = Fachada.getInstance().adicionar(builder);
        
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "adicionando builder pela fachada");
        
        session.setAttribute("matricula", matricula);
        session.setAttribute("nota", nota);
        response.sendRedirect("pagina_prova_terminada.jsp");
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "\n\n");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
