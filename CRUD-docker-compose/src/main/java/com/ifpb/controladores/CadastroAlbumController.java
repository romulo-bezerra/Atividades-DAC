package com.ifpb.controladores;

import com.ifpb.interfaces.Command;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroAlbumController implements Command {

    @Override
    public final void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {
//
//        UsuarioDAO userDAO = new UsuarioDAO();
//        Usuario u = new Usuario();
//
//        if(userDAO.userExists(req.getParameter("email"))){
//            res.sendRedirect("erro.jsp");
//        }else{
//            
//            u.setEmail(req.getParameter("email"));
//            
//            String data = req.getParameter("nascimento");
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            LocalDate date = LocalDate.parse(data,formatter);
//
//            if(date.isAfter(LocalDate.now())){
//                res.sendRedirect("erroData.jsp"); 
//            }else{
//                u.setNascimento(req.getParameter("nascimento"));
//                
//                String foto = uploadFile("fotosPerfil", req, 
//                req.getPart("fotoPerfil"), req.getParameter("email"));
//                u.setFotoPerfil(foto);
//            }
//     
//        }
//
//        u.setNome(req.getParameter("nome"));
//        u.setCidade(req.getParameter("cidade"));
//        u.setProfissao(req.getParameter("profissao"));
//        u.setSenha(req.getParameter("senha"));
//        u.setSexo(req.getParameter("sexo"));
//
//        if (userDAO.insert(u)) {
//            res.sendRedirect("index.jsp");
//            
//        }else{
//            res.sendRedirect("erro.jsp");
//        }
//
    }

}
