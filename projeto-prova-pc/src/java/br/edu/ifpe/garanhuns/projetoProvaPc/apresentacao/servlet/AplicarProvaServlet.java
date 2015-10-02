/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.projetoProvaPc.apresentacao.servlet;

import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.AplicacaoDaProva;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Prova;
import br.edu.ifpe.garanhuns.projetoProvaPc.fachada.Fachada;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 20151D12GR0065
 */
@WebServlet(name = "AplicarProvaServlet", urlPatterns = {"/AplicarProvaServlet"})
public class AplicarProvaServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        Prova p = (Prova) session.getAttribute("prova");
        String turma = request.getParameter("turma");
        if(turma==null) {
            session.setAttribute("exception", new Exception("Turma is null on AplicarProvaServlet.java"));
            response.sendRedirect("pagina_erro.jsp");
            return;
        }
        AplicacaoDaProva a = Fachada.getInstance().criarAplicacaoProva(p,turma);
        // tema, turma e senha
        session.setAttribute("tema", a.getTema());
        session.setAttribute("turma", a.getTurma());
        session.setAttribute("senha", a.getSenha());
        response.sendRedirect("pagina_aplicar_prova.jsp");
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
