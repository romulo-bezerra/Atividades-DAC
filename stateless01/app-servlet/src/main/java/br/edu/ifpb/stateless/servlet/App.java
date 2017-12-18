package br.edu.ifpb.stateless.servlet;

import br.edu.ifpb.service.shared.Calculadora;
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
    
    private final Calculadora calc = new ServiceLookup()
            .lookup("java:global/service-core/CalculadoraSimples");
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        
        int resultado = calc.somar(a, b);
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet App</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>A soma é: " + resultado + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

}
