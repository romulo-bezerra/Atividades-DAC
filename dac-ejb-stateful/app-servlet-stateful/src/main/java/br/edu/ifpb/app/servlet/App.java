package br.edu.ifpb.app.servlet;

import br.edu.ifpb.service.shared.Carrinho;
import br.edu.ifpb.service.shared.ServiceLookup;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.PostConstruct;
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

    private Carrinho carrinho;
    private String produto;
    private String remove;

    @PostConstruct
    @Override
    public void init() {
        this.carrinho = new ServiceLookup()
                    .lookup("host-core", "3700", 
                            "java:global/service-core-stateful/CarrinhoOnline");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.produto = request.getParameter("produto");

        if(request.getParameter("finalizarCompra") != null){
            carrinho.finalizarCompra();
        }
            
        if (request.getParameter("add") != null) {
            carrinho.adicionarProduto(produto);
        }

        if (request.getParameter("remove") != null) {
            carrinho.removerProduto(request.getParameter("produtoRemove"));
        }

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Carrinho</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Carrinho!</h1>");
            out.println("<form action='App' method=\"GET\">\n "
                    + "<input type=\"text\" name=\"produto\" required>\n"
                    + "<input type=\"submit\" name=\"add\" value=\"Add\">\n"
                    + "</form>");
            out.println("<table>\n");
            out.println("<tr>\n"
                    + "<th>Produtos</th>\n"
                    + "<th>Ação</th> \n"
                    + "</tr>\n");

            for (String car : carrinho.listarProdutos()) {
                out.println("<tr>\n"
                        + "<td>" + car + "</td>\n"
                        + "<td>"
                        + "<form action='App' method='GET'>\n "
                        + "<input type='submit' name='remove' value=' - '>\n"
                        + "<input type='hidden' name='produtoRemove' value='" + car + "'>\n"
                        + "</form>"
                        + "</td> \n"
                        + "</tr>\n");
            }
            out.println("</table>");

            out.println("<form action='App' method='GET'>\n "
                    + "<input type='submit' name='finalizarCompra' value='finalizar compra'>\n"
                    + "</form>");

            out.println("</body>");
            out.println("</html>");
        }

    }

}
