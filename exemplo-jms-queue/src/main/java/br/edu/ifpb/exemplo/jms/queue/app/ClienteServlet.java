/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.exemplo.jms.queue.app;

import br.edu.ifpb.exemplo.jms.queue.service.ProdutorEmail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author romulo
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/consumidor"})
public class ClienteServlet extends HttpServlet {
    
    @Inject
    private ProdutorEmail produtorEmail;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        
        this.produtorEmail.enviarEmail(email);
        
    }
    
}
