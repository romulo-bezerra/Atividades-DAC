/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.app.servlet.singleton;

import br.edu.ifpb.service.shared.SalaDeBatepapo;
import br.edu.ifpb.service.shared.ServiceLookup;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author romulo
 */
@WebServlet(name = "App", urlPatterns = {"/App"})
public class App extends HttpServlet {

    String mensagem;
    String mensagemRemove;

    SalaDeBatepapo sdb = new ServiceLookup()
            .lookup("host-core", "3700",
                    "java:global/service-core-singleton/SalaDeBatepapoOnline");

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
        response.setContentType("text/html;charset=UTF-8");

        this.mensagem = request.getParameter("mensagem");
        this.mensagemRemove = request.getParameter("mensagemRemove");

        if (request.getParameter("adicionar") != null) {
            sdb.addMensagem(mensagem);
        } else if (request.getParameter("remover") != null) {
            sdb.rmvMensagem(mensagemRemove);
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mensagens</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Mensagens</h1>");
            out.println("<form action='App' method='GET'>");
            out.println("<input name='mensagem' type='text' />");
            out.println("<input name='adicionar' value='+' type='submit' />");
            out.println("</form>");
            out.println("<table>\n");
            out.println("<tr>\n"
                    + "<th>Mensagem</th>\n"
                    + "<th>Ação</th> \n"
                    + "</tr>\n");
            for (String msg : sdb.listarMensagens()) {
                out.println("<tr>\n"
                        + "<td>" + msg + "</td>\n"
                        + "<td>"
                        + "<form action='App' method='GET'>\n "
                        + "<input type='submit' name='remover' value=' - '>\n"
                        + "<input type='hidden' name='mensagemRemove' value='" + msg + "'>\n"
                        + "</form>"
                        + "</td> \n"
                        + "</tr>\n");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

        }
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

}
