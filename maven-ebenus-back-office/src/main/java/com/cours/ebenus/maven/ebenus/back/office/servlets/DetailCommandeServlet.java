package com.cours.ebenus.maven.ebenus.back.office.servlets;

import com.cours.ebenus.maven.ebenus.back.office.utils.Utils;
import com.cours.ebenus.maven.ebenus.dao.entities.Adresse;
import com.cours.ebenus.maven.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.maven.ebenus.dao.entities.Commande;
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

public class DetailCommandeServlet extends HttpServlet {
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
            HttpSession session = request.getSession();
            Commande cmd = servicefacade.getCommandeDao().findCommandeById(Integer.parseInt(request.getParameter("id")));
            Utilisateur user = servicefacade.getUtilisateurDao().findUtilisateurById(cmd.getIdUtilisateur());
            Adresse addrF = servicefacade.getAdresseDao().findUserMainAdresse(user);
            List<ArticleCommande> artCo = servicefacade.getArticleCommandeDao().findArticleCommandeByIdCommande(cmd.getIdCommande());
            request.setAttribute("cmd", cmd);
            request.setAttribute("user", user);
            request.setAttribute("addr", addrF);
            request.setAttribute("articles", artCo);
            request.setAttribute("artdao", servicefacade.getProduitDao());
            this.getServletContext().getRequestDispatcher("/pages/detailCo.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
