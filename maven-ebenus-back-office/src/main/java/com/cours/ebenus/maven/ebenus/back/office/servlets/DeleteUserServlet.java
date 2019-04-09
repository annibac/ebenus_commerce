package com.cours.ebenus.maven.ebenus.back.office.servlets;

import com.cours.ebenus.maven.ebenus.back.office.utils.Utils;
import com.cours.ebenus.maven.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.maven.ebenus.dao.entities.Commande;
import com.cours.ebenus.maven.ebenus.dao.entities.Produit;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.service.ServiceFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DeleteUserServlet extends HttpServlet {
    private ServiceFacade servicefacade = null;

    private static final Log log = LogFactory.getLog(DeleteUserServlet.class);

    @Override
    public void init() throws ServletException {
        this.servicefacade = ServiceFacade.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userCookie = Utils.getCookie(request.getCookies(), "user");
        Utilisateur userLogged = Utils.getUserLogged(userCookie);
        if (userLogged == null)  {
            response.sendRedirect(this.getServletContext().getContextPath() + "/login");
        } else {
            System.out.println("IN DELETE");
            HttpSession session = request.getSession();
            Utilisateur user = ServiceFacade.getInstance().getUtilisateurDao().findUtilisateurById(Integer.parseInt(request.getParameter("id")));
            if(user != null && !user.equals(userLogged))
                ServiceFacade.getInstance().getUtilisateurDao().deleteUtilisateur(user);
            else
                response.sendRedirect(this.getServletContext().getContextPath() + "/users?error=Utilisateur connecté ou inexistant.");
            response.sendRedirect(this.getServletContext().getContextPath() + "/users");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
