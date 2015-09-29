package br.edu.ifpe.garanhuns.projetoProvaPc.apresentacao.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifpe.garanhuns.projetoProvaPc.builders.ProvaBuilder;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 20141D12GR0122
 */
@WebServlet(urlPatterns = {"/NovaQuestaoServlet"})
public class NovaQuestaoServlet extends HttpServlet {

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
        
        ProvaBuilder pb = (ProvaBuilder) request.getSession().getAttribute("pb");
        /*
        pb.addQuestao(request.getAttribute("enunciado"));
        
        char correta = request.getParameter("correta").charAt(0);
        
        for(char l = 'a'; l<='e';l++) {
            String afirmacao = request.getParameter("afirmacao" + l);
            boolean veracidade = correta == l;
            pb.adicionarAlternativa(afirmacao,veracidade);
        }
        pb.buildQuestao();
        */
        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect("mostarProvaEmConstrucao.jsp");
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
